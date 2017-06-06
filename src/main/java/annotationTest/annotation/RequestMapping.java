package annotationTest.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestMapping {
    String value() default "";

    /**
     * 是否为序列号
     *
     * @return
     */
    boolean id() default false;

    /**
     * 字段名称
     *
     * @return
     */
    String name() default "";

    /**
     * 字段描述
     *
     * @return
     */
    String description() default "";
}