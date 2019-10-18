package com.zzmx.springboot.atomikos.service;

import com.zzmx.springboot.atomikos.dao.BusinessDao;
import com.zzmx.springboot.atomikos.dao.SystemDao;
import com.zzmx.springboot.atomikos.entity.Business;
import com.zzmx.springboot.atomikos.entity.System;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Lay
 * @Date: 2019/10/18 13:37
 * @Description:
 */
@Service
public class XaTransactionServiceImpl implements XaTransactionService {

    @Autowired
    private BusinessDao businessDao;

    @Autowired
    private SystemDao systemDao;

    public Business getBusinessById(Long id) {
        return businessDao.getById(id);
    }

    public System getSystemById(Long id) {
        return systemDao.findById(id);
    }
}
