package com.zzmx.springboot.atomikos.entity;

import java.io.Serializable;

/**
 * @Author: Lay
 * @Date: 2019/10/18 12:48
 * @Description:
 */
public class System implements Serializable {

    private static final long serialVersionUID = -2705679550792632970L;

    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
