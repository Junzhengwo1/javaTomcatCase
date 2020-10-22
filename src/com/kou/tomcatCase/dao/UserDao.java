package com.kou.tomcatCase.dao;

import com.kou.tomcatCase.domain.User;
import com.kou.tomcatCase.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author JIAJUN KOU
 *
 * 操作数据库中User表的类
 */
public class UserDao {

    //声明JDBCTemplate对象 共用

    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 登录方法
     * @param loginUser 只有用户名和密码
     * @return 包含用户全部数据
     */
    public User login( User loginUser){
        try {
            //1.编写sql
            String sql="select * from user where username=? and password=?";
            //2.调用方法获取User对象
            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(), loginUser.getPassword());
            //3.返回user
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();//记录日志
            return null;
        }
    }
}
