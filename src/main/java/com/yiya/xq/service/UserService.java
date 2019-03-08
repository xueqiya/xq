package com.yiya.xq.service;

import com.yiya.xq.bean.UserBean;
import com.yiya.xq.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Map addUser(UserBean userBean) {
        Map map = new HashMap();
        userRepository.save(userBean);
        map.put("uid", userBean.getUid());
        return map;
    }
}
