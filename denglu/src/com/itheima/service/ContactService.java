package com.itheima.service;

import com.itheima.dao.ContactDao;
import com.itheima.dao.Contactdao;
import com.itheima.domain.Contact;
import com.itheima.domain.PageBean;

import java.util.List;

/**
 * 包名:com.itheima.service
 * 作者:Leevi
 * 日期2018-08-27  11:30
 */
public class ContactService {
    private Contactdao dao = new Contactdao();
    /**
     * 查询所有联系人的业务方法
     * @return
     */
    public List<Contact> findAllContacts() {
        //调用dao层的方法，查询所有联系人的信息

        List<Contact> contacts = null;
        try {
            contacts = dao.findAllContacts();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contacts;
    }

    public boolean saveContact(Contact contact) {
        //调用dao层的方法保存数据到数据库
        boolean flag = false;
        try {
            flag = dao.saveContact(contact);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean deleteContact(String id) {
        //调用dao层的方法，根据id到数据库删除指定数据
        boolean flag = false;
        try {
            flag = dao.deleteContact(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public Contact findContactById(String id) {
        //调用业务层的方法，根据id查询联系人信息
        Contact contact = null;
        try {
            contact = dao.findContactById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contact;
    }

    public boolean updateContact(Contact contact) {
        //调用dao层的方法修改联系人
        boolean flag = false;
        try {
            flag = dao.updateContact(contact);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public PageBean findPageBean(Long currentPage) {
        //1.创建PageBean对象
        PageBean pageBean = new PageBean();
        //2.设置PageBean对象的内容
        //2.1设置当前页数currentPage
        pageBean.setCurrentPage(currentPage);

        //2.2设置每页的数据条数，pageSize
        Integer pageSize = 4;
        pageBean.setPageSize(pageSize);

        //2.3设置总数据条数
        //调用dao层的方法，查询到总联系人个数
        try {
            Long totalSize = dao.findContactCount();
            pageBean.setTotalSize(totalSize);

            //2.4设置总页数，totalPage
            Long totalPage = totalSize % pageSize == 0 ? totalSize/pageSize : (totalSize/pageSize)+1;
            pageBean.setTotalPage(totalPage);

            //2.5设置每页的数据集合
            //调用dao层的方法，获取该页的数据集合
            List<Contact> list = dao.findPageContacts(currentPage,pageSize);
            pageBean.setList(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageBean;
    }
}
