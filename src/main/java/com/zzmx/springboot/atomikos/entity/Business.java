package com.zzmx.springboot.atomikos.entity;

import java.io.Serializable;

/**
 * @Author: Lay
 * @Date: 2019/10/18 12:48
 * @Description:
 */
public class Business implements Serializable {

    private static final long serialVersionUID = -4094988701365475118L;

    private Long id;

    private String businessname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBusinessname() {
        return businessname;
    }

    public void setBusinessname(String businessname) {
        this.businessname = businessname;
    }
}
