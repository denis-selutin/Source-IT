package main;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD, ElementType.TYPE, ElementType.FIELD})
public @interface MyAnnotation {
    enum MyEnum {
        VALUE_1, VALUE_2, VALUE_3
    }

    MyEnum enumValue() default MyEnum.VALUE_1;

    String[] tags() default "";

    String name() default "some field";
}
