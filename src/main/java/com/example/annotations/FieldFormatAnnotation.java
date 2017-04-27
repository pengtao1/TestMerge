package com.example.annotations;

/**
 * Created by wb-zhangkenan on 2017/4/19.
 *
 * @date 2017/04/19
 */
public @interface FieldFormatAnnotation {

    /**
     * list集合的长度
     * @return
     */
    int listSize() default 4;

    /**
     * map集合的长度
     * @return
     */
    int mapSize() default 4;

    /**
     * 字符串的长度
     * @return
     */
    int stringLength() default 8;
}
