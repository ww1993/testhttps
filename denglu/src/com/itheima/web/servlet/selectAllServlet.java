package com.itheima.web.servlet;

import com.itheima.domain.Contact;
import com.itheima.service.ContactService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/all")
public class selectAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ContactService service = new ContactService();
        List<Contact> contacts = service.findAllContacts();
        //System.out.println(contacts);
        //存放到request集合中
         request.setAttribute("list",contacts);

         //请求转发到contact.jsp页面
        request.getRequestDispatcher("contact.jsp").forward(request,response);

    }
}
