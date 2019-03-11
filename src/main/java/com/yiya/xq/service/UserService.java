package com.yiya.xq.service;

import com.yiya.xq.bean.ResultBean;
import com.yiya.xq.bean.UserBean;
import com.yiya.xq.repository.UserRepository;
import com.yiya.xq.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public ResultBean register(UserBean userBean) {
        if (userBean.getUid() == null && userBean.getPwd() == null) {
            return ResultUtil.error(601, "账号或者密码不能为空");
        }
//        if (userBean.getPwd().length() < 6) {
//            return ResultUtil.error(601, "密码不能少于6位");
//        } else if (userBean.getUid().length() < 4) {
//            return ResultUtil.error(601, "账号不能少于5位");
//        } else {
        Map map = new HashMap();
        userRepository.save(userBean);
        map.put("uid", userBean.getUid());
        return ResultUtil.success(map, "注册成功");
//        }
    }

    public ResultBean login(UserBean userBean) {
        UserBean bean = userRepository.findByUid(userBean.getUid());
        if (bean.getPwd().equals(userBean.getPwd())) {
            System.out.println("用户名:" + bean.getPwd() + "&" + "密码:" + userBean.getPwd());
            Map map = new HashMap();
            map.put("uid", userBean.getUid());
            return ResultUtil.success(map, "登陆成功");
        } else {
            return ResultUtil.error(601, "密码错误或用户不存在");
        }
    }
}
