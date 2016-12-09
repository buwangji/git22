package com.laowang.web;



import com.laowang.dao.MessageDao;
import com.laowang.entity.Message;
import com.laowang.service.MessageService;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2016/12/9.
 */
@WebServlet("/timeline")
public class TimeLineServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String maxid = req.getParameter("maxid");
        int id = 0;
        if(StringUtils.isNumeric(maxid)){
            id = Integer.parseInt(maxid);
        }
       MessageService messageService = new MessageService();
        List<Message> messageList = messageService.findByMaxId(id);
        renderJSON(messageList,resp);
    }
}
