package com.zzmx.springboot.atomikos.dao;

import com.zzmx.springboot.atomikos.entity.System;

/**
 * @Author: Lay
 * @Date: 2019/10/18 13:13
 * @Description:
 */
public interface SystemDao {

    System findById(Long id);
}
