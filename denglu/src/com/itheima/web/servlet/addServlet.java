package com.itheima.web.servlet;

import com.itheima.domain.Contact;
import com.itheima.service.ContactService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/add")
public class addServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> map = request.getParameterMap();
        Contact contact = new Contact();
        boolean flag = false;
        try {
            BeanUtils.populate(contact,map);

            ContactService service = new ContactService();
             flag = service.saveContact(contact);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(contact);
        //判断是否存储成功
        if(flag){
          response.sendRedirect("all");
        }else{
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write("添加失败");
        }
    }
}
