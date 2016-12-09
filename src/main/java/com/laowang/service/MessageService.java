package com.laowang.service;

import com.laowang.dao.MessageDao;
import com.laowang.entity.Message;

import java.util.List;

/**
 * Created by Administrator on 2016/12/9.
 */
public class MessageService {
    private MessageDao messageDao = new MessageDao();

    public List<Message> findAll() {
        return messageDao.findAll();
    }

    public List<Message> findByMaxId(int maxId) {
        return messageDao.findByMaxId(maxId);
    }
}


