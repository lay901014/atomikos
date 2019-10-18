package com.zzmx.springboot.atomikos.service;

import com.zzmx.springboot.atomikos.entity.Business;
import com.zzmx.springboot.atomikos.entity.System;

/**
 * @Author: Lay
 * @Date: 2019/10/18 13:36
 * @Description:
 */
public interface XaTransactionService {

    Business getBusinessById(Long id);

    System getSystemById(Long id);
}
