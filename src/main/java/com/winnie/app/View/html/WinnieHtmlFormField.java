package com.winnie.app.View.html;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface WinnieHtmlFormField {
    String labelFor() default "";

    String label() default "";

    String id() default "";

    String name() default "";

    String selectName() default "";

    String selectList() default "";

    String selectValue() default "";

    boolean selectValueInSuper() default false;

    String selectDisplay() default "";

    boolean selectDisplayInSuper() default false;

    boolean required() default false;

}
