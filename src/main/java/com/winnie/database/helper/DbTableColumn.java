package com.winnie.database.helper;

import java.lang.annotation.*;

@Inherited
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DbTableColumn {
    String name();
    String type ()default "varchar(255)";
}
