package com.laowang.web;

import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/wysiwyg")
public class WysiwygServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ak = "Mjibzd_3sWhKcJ0seIJaSi5qjBwx8AsPW3g_pqtX";
        String sk = "MkiUj_wsWw6KmHkbbdr-z6Pv3iy9-2613YHXW-fW";
        String bucketName = "qiniuyun";
        Auth auth = Auth.create(ak,sk);
        String returnBody = "{\"success\":true,\"file_path\":\"http://oi1y0qaj2.bkt.clouddn.com/${key}\"}";
        StringMap map = new StringMap();
        map.put("returnBody",returnBody);
        String token = auth.uploadToken(bucketName,null,3600,map);
        req.setAttribute("token",token);
        req.getRequestDispatcher("wysiwyg.jsp").forward(req,resp);

    }
}
