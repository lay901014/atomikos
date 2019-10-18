package com.zzmx.springboot.atomikos.dao;

import com.zzmx.springboot.atomikos.entity.Business;

/**
 * @Author: Lay
 * @Date: 2019/10/18 13:12
 * @Description:
 */
public interface BusinessDao  {

    Business getById(Long id);
}
