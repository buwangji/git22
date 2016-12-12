package com.laowang.web;

import com.qiniu.util.Auth;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2016/12/12.
 */
@WebServlet("/qiniu2")
public class QiuNiu2Servlet extends BaseServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ak = "Mjibzd_3sWhKcJ0seIJaSi5qjBwx8AsPW3g_pqtX";
        String sk = "MkiUj_wsWw6KmHkbbdr-z6Pv3iy9-2613YHXW-fW";
        String name = "qiniuyun";
        Auth auth = Auth.create(ak,sk);

        String token = auth.uploadToken(name);
        req.setAttribute("id",11223);
        req.setAttribute("token",token);
        req.getRequestDispatcher("upload-qiniu.jsp").forward(req,resp);

    }
}
