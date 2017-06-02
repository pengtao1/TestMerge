package com.example.annotations;

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
