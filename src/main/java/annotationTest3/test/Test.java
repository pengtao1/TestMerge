package annotationTest3.test;

import java.util.List;

import annotationTest3.model.BlackPeople;
import annotationTest3.util.AnnotationUtil;
import annotationTest3.util.ClassUtil;

/**
 * Created by pengtao on 2017/6/2.
 */
public class Test {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        // 获取特定包下所有的类(包括接口和类)
        List<Class<?>> clsList = ClassUtil.getAllClassByPackageName(BlackPeople.class.getPackage());
        //输出所有使用了特定注解的类的注解值
        AnnotationUtil.validAnnotation(clsList);
    }
}
