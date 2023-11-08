package com.winnie.app.View.html;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface WinnieHtmlForms {
    String label()  ;

    String url() default".";

    String httpMethod() default "POST";
}
