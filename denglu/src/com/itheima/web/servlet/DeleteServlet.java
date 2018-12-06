package com.itheima.web.servlet;

import com.itheima.service.ContactService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        ContactService service = new ContactService();
        boolean flag = service.deleteContact(id);

        //判断是否删除成功
        if (flag) {
            response.sendRedirect("all");
        } else {
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write("删除失败");
        }
    }
}
