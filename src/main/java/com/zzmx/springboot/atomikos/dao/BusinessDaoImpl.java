package com.zzmx.springboot.atomikos.dao;

import com.zzmx.springboot.atomikos.entity.Business;
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
 * @Date: 2019/10/18 12:54
 * @Description:
 */
@Repository
public class BusinessDaoImpl implements BusinessDao {

    @Resource(name = "busJdbcTemplate")
    private JdbcTemplate busJdbcTemplate;

    public Business getById(Long id) {
        List<Business> list = busJdbcTemplate.query("select * from xa_business where id = ?", new Object[]{id}, new RowMapper<Business>() {
            public Business mapRow(ResultSet rs, int rowNum) throws SQLException {
                Business business = new Business();
                business.setId(rs.getLong("id"));
                business.setBusinessname(rs.getString("businessname"));
                return business;
            }
        });
        if(CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0);

    }
}
