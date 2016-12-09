package com.laowang.dao;


import com.laowang.entity.Message;
import com.laowang.utils.DbHelp;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class MessageDao {

    public List<Message> findAll() {
        String sql = "select * from message order by id desc";
        return DbHelp.query(sql,new BeanListHandler<>(Message.class));
    }

    public List<Message> findByMaxId(int maxId) {
        String sql = "select * from message where id > ? order by id desc";
        return DbHelp.query(sql,new BeanListHandler<>(Message.class),maxId);
    }
}
