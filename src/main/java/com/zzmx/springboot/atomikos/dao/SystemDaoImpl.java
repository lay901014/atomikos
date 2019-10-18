package com.zzmx.springboot.atomikos.dao;

import com.zzmx.springboot.atomikos.entity.System;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author: Lay
 * @Date: 2019/10/18 13:13
 * @Description:
 */
@Repository
public class SystemDaoImpl implements SystemDao {

    @Resource(name = "sysJdbcTemplate")
    private JdbcTemplate sysJdbcTemplate;

    public System findById(Long id) {
        List<System> list = sysJdbcTemplate.query("select * from xa_system where id = ?", new Object[]{id}, new RowMapper<System>() {
            public System mapRow(ResultSet rs, int rowNum) throws SQLException {
                System system = new System();
                system.setId(rs.getLong("id"));
                system.setName(rs.getString("name"));
                return system;
            }
        });
        if(CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }
}
