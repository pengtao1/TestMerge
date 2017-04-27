package com.example.util;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.annotations.FieldFormatAnnotation;
import com.example.result.DataResult;
import com.example.result.SimpleResult;

public class ObjectRandomFieldValueUtil {
    public static <T> T getObject(Class<?> clazz) {
        T t = null;
        if (clazz == null) {
            return t;
        }
        if ((t = (T)getPrimitive(clazz)) != null) {
            return t;
        }
        //需要有无参的构造器
        try {
            t = (T)clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        Field[] fields = clazz.getDeclaredFields();
        List<Field> fieldList = new ArrayList<Field>();
        if (fields != null && fields.length > 0) {
            fieldList.addAll(Arrays.asList(fields));
        }
        Class<?> tClass = clazz;
        while (tClass.getSuperclass() != Object.class) {
            tClass = tClass.getSuperclass();
            fields = tClass.getDeclaredFields();
            if (fields != null && fields.length > 0) {
                fieldList.addAll(Arrays.asList(fields));
            }
        }
        fields = fieldList.toArray(new Field[0]);
        //属性字段
        String fileName = "";
        //符合JavaBean规则的属性
        PropertyDescriptor property = null;
        //set方法对象
        Method method = null;
        for (int i = 0; i < fields.length; i++) {
            //属性字段
            fileName = fields[i].getName();
            //获取属性上的注解
            FieldFormatAnnotation annotation = fields[i].getAnnotation(FieldFormatAnnotation.class);
            try {
                property = new PropertyDescriptor(fileName, clazz);
            } catch (IntrospectionException e) {
                //没有设置set方法，或者不符合JavaBean规范
                continue;
            }
            //获取set方法对象
            method = property.getWriteMethod();
            //如果是字节类型(包含基本类型和包装类)
            if (fields[i].getType() == byte.class || fields[i].getType() == Byte.class) {
                try {
                    method.invoke(t, FieldValuesUtil.getByteValue());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
            //如果是short类型(包含基本类型和包装类)
            else if (fields[i].getType() == short.class || fields[i].getType() == Short.class) {
                try {
                    method.invoke(t, FieldValuesUtil.getShortValue());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
            //如果是char类型(包含基本类型和包装类)
            else if (fields[i].getType() == char.class || fields[i].getType() == Character.class) {
                try {
                    method.invoke(t, FieldValuesUtil.getCharValue());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
            //如果是整型(包含基本类型和包装类)
            else if (fields[i].getType() == int.class || fields[i].getType() == Integer.class) {
                try {
                    //为属性赋值
                    method.invoke(t, FieldValuesUtil.getIntValue());
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            //如果是float(包含基本类型和包装类)
            else if (fields[i].getType() == float.class || fields[i].getType() == Float.class) {
                try {
                    //为属性赋值
                    method.invoke(t, FieldValuesUtil.getFloatValue());
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            //如果是double(包含基本类型和包装类)
            else if (fields[i].getType() == double.class || fields[i].getType() == Double.class) {
                try {
                    //为属性赋值
                    method.invoke(t, FieldValuesUtil.getDoubleValue());
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            //如果是Long(包含基本类型和包装类)
            else if (fields[i].getType() == long.class || fields[i].getType() == Long.class) {
                try {
                    //为属性赋值
                    method.invoke(t, FieldValuesUtil.getLongValue());
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            //如果是boolean(包含基本类型和包装类)
            else if (fields[i].getType() == boolean.class || fields[i].getType() == Boolean.class) {
                try {
                    //为属性赋值
                    method.invoke(t, FieldValuesUtil.getBooleanValue());
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            //如果是String
            else if (fields[i].getType() == String.class) {
                try {
                    int length = 8;
                    if (annotation != null) {
                        length = annotation.stringLength();
                    }
                    //为属性赋值
                    method.invoke(t, FieldValuesUtil.getRamdomString(length));
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            //如果是日期类型
            else if (fields[i].getType() == Date.class) {
                try {
                    method.invoke(t, FieldValuesUtil.getDateValue());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
            //如果是List类型
            else if (fields[i].getType().isAssignableFrom(List.class)) {
                //获取泛型
                Type type = fields[i].getGenericType();
                //如果不是泛型，不做处理
                if (type == null) {
                    continue;
                }
                if (type instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType)type;
                    Class<?> genericClazz = (Class)parameterizedType.getActualTypeArguments()[0];
                    int size = 0;
                    if (annotation != null) {
                        size = annotation.listSize();
                    }
                    List<Object> list = new ArrayList<Object>(size);
                    for (int j = 0; j < size; j++) {
                        list.add(getObject(genericClazz));
                    }
                    try {
                        method.invoke(t, list);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
            //如果是Map类型
            else if (fields[i].getType().isAssignableFrom(Map.class)) {
                //获取泛型
                Type types = fields[i].getGenericType();
                //如果不是泛型的话则不处理
                if (types == null) {
                    continue;
                }
                if (types instanceof ParameterizedType) {
                    int size = 4;
                    if (annotation != null) {
                        size = annotation.mapSize();
                    }
                    ParameterizedType parameterizedType = (ParameterizedType)types;
                    Map<Object, Object> map = new HashMap<Object, Object>();
                    for (int j = 0; j < size; j++) {
                        map.put(getObject((Class<?>)parameterizedType.getActualTypeArguments()[0]),
                            getObject((Class<?>)parameterizedType.getActualTypeArguments()[1]));
                    }
                    try {
                        method.invoke(t, map);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
            //这里默认处理的是自定义对象
            else {
                try {
                    Object obj = getObject(fields[i].getType());
                    method.invoke(t, obj);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return t;
    }

    private static Object getPrimitive(Class<?> clazz) {
        //如果是byte类型(包含基本类型和包装类)
        if (clazz == byte.class || clazz == Byte.class) {
            return FieldValuesUtil.getByteValue();
        }
        //如果是short类型(包含基本类型和包装类)
        if (clazz == short.class || clazz == Short.class) {
            return FieldValuesUtil.getShortValue();
        }
        //如果是char类型(包含基本类型和包装类)
        if (clazz == char.class || clazz == Character.class) {
            return FieldValuesUtil.getCharValue();
        }
        //如果是整型(包含基本类型和包装类)
        if (clazz == int.class || clazz == Integer.class) {
            //为属性赋值
            return FieldValuesUtil.getIntValue();
        }
        //如果是float(包含基本类型和包装类)
        if (clazz == float.class || clazz == Float.class) {
            //为属性赋值
            return FieldValuesUtil.getFloatValue();
        }
        //如果是double(包含基本类型和包装类)
        if (clazz == double.class || clazz == Double.class) {
            //为属性赋值
            return FieldValuesUtil.getDoubleValue();
        }
        //如果是double(包含基本类型和包装类)
        if (clazz == long.class || clazz == Long.class) {
            //为属性赋值
            return FieldValuesUtil.getLongValue();
        }
        //如果是boolean(包含基本类型和包装类)
        if (clazz == boolean.class || clazz == Boolean.class) {
            return FieldValuesUtil.getBooleanValue();
        }
        //如果是boolean(包含基本类型和包装类)
        if (clazz == String.class) {
            //为属性赋值
            return FieldValuesUtil.getRamdomString(8);
        }
        //如果是日期类型
        if (clazz == Date.class) {
            return FieldValuesUtil.getDateValue();
        }
        return null;
    }

    public static <B, T> Object getRealObject(Class<B> objClazz, Class<T> bClass, int size) {
        Object obj = ObjectRandomFieldValueUtil.getObject(objClazz);
        //SimpleResult
        if (objClazz == SimpleResult.class) {
            return obj;
        }
        //DataResult
        //集合类型
        if (size > 1) {
            List<T> listB = new ArrayList<T>(size);
            for (int i = 0; i < size; i++) {
                listB.add((T)ObjectRandomFieldValueUtil.getObject(bClass));
            }
            ((DataResult)obj).setData(listB);
        }
        if (size <= 1) {
            ((DataResult)obj).setData(ObjectRandomFieldValueUtil.getObject(bClass));
        }
        return obj;
    }

    public static <A, B, C> Object getMapDataResult(Class<A> objClazz, int size, Class<B> firClazz, Class<C> secClazz) {

        Object obj = ObjectRandomFieldValueUtil.getObject(objClazz);
        //SimpleResult
        if (objClazz == SimpleResult.class) {
            return obj;
        }
        if (size <= 0) {
            return obj;
        }
        Map<B, C> resultMap = new HashMap<B, C>(size);
        for (int i = 0; i < size; i++) {
            resultMap.put((B)ObjectRandomFieldValueUtil.getObject(firClazz),(C)ObjectRandomFieldValueUtil.getObject(secClazz));
        }
        ((DataResult)obj).setData(resultMap);
        return obj;
    }
}
