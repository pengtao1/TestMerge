package annotationTest.test;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import annotationTest.annotation.RequestMapping;
import annotationTest.model.ExecutorBean;
import annotationTest.util.AnnoManageUtil;

public class Test {
    public static void main(String[] args) {
        Map<String, ExecutorBean> mmap = AnnoManageUtil.getRequestMappingMethod("annotationTest.service");
        ExecutorBean bean = mmap.get("/test1");

        try {
            bean.getMethod().invoke(bean.getObject());
            RequestMapping annotation = bean.getMethod().getAnnotation(RequestMapping.class);
            System.out.println("注解名称：" + annotation.name() + "\t注解描述：" + annotation.description());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
