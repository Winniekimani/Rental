package com.winnie.app.model.entity;

import com.winnie.database.helper.DbTableColumn;
import com.winnie.database.helper.DbTableId;

import java.io.Serializable;
import java.lang.annotation.Inherited;


public class BaseEntity implements Serializable {

    @DbTableId
    @DbTableColumn(name = "id", type = "int")

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
