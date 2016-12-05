package com.laowang;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ajax")
public class AjavServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        name = new String(name.getBytes("ISO8859-1"),"UTF-8");

        System.out.println("Hello,Ajax!!! -> " + name);
        PrintWriter out = resp.getWriter();
        out.print("Hello,World");
        out.flush();
        out.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        //给客服端设置响应编码
        resp.setCharacterEncoding("UTF-8");
        //设置响应内容
        resp.setContentType("text/plain;charset=UTF-8");
        String name = req.getParameter("name");

        PrintWriter out = resp.getWriter();
        if ("aa".equals(name)){
            System.out.println("账号被占用");
            out.print("失败");
        } else {
            System.out.println("账号可以使用");
            out.print("成功");
        }
        System.out.println("Hello,Ajax doPost ->" + name);

        out.flush();
        out.close();


    }
}
