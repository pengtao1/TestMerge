package annotationTest.test;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import annotationTest.annotation.Controller;
import annotationTest.model.ExecutorBean;
import annotationTest.util.AnnoManageUtil;

public class Test {
    public static void main(String[] args) {
        List<Class<?>> classesList = null;
        classesList = AnnoManageUtil.getPackageController("annotationTest.service", Controller.class);

        Map<String, ExecutorBean> mmap = new HashMap<String, ExecutorBean>();

        AnnoManageUtil.getRequestMappingMethod(classesList, mmap);

        ExecutorBean bean = mmap.get("/test1");
        try {
            bean.getMethod().invoke(bean.getObject());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
