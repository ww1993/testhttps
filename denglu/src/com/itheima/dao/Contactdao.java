package com.itheima.dao;

import com.itheima.domain.Contact;
import com.itheima.utils.JDBCUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class Contactdao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtil.getDataSource());
    public List<Contact> findAllContacts() throws Exception{
        String sql ="select * from contact ";
        List<Contact> contacts = template.query(sql, new BeanPropertyRowMapper<>(Contact.class));
        return contacts;
    }

    public boolean savaContact(Contact contact) throws Exception{
        String sql = "insert into contact values (null,?,?,?,?,?,?)";
        int i = template.update(sql, contact.getName(), contact.getSex(),contact.getAge(), contact.getAddress(), contact.getQq(), contact.getEmail());
       boolean flag = false;
        if (i==1) {
            flag=true;
        }
        return flag;
    }

    public boolean deleteContact(String id) throws Exception{
        String sql = "delete from contact where id=?";
        int i = template.update(sql, id);
        boolean flag = false;
        if (i==1) {
            flag=true;
        }
        return flag;
    }
}
