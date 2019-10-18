package com.zzmx.springboot.atomikos.web.controller;

import com.zzmx.springboot.atomikos.entity.Business;
import com.zzmx.springboot.atomikos.entity.System;
import com.zzmx.springboot.atomikos.service.XaTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {

	@Autowired
	private JdbcTemplate sysJdbcTemplate;

	@Autowired
	private JdbcTemplate busJdbcTemplate;

	@Autowired
	private XaTransactionService xaTransactionService;

	@Transactional
	@RequestMapping("")
	@ResponseBody
	public String test() {
		sysJdbcTemplate.execute("insert into xa_system(id) values(12)");
		busJdbcTemplate.execute("insert into xa_business(id) values(23)");
		int i= 0;
		try {
			if(i == 0) {
				throw new RuntimeException("a");
			}
		}catch (Exception e) {
			throw new RuntimeException("s");
		}
		return "ok";
	}

	@RequestMapping(value = "bus/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Business getBusiness(@PathVariable Long id) {
		return xaTransactionService.getBusinessById(id);
	}

	@RequestMapping(value = "sys/{id}", method = RequestMethod.GET)
	@ResponseBody
	public System getSystem(@PathVariable Long id) {
		return xaTransactionService.getSystemById(id);
	}
}
