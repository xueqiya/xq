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
        UserBean bean = userRepository.findUserBeanByUid(userBean.getUid());
        if (bean != null) {
            return ResultUtil.error(601, "用户已注册");
        } else if (userBean.getUid() == null && userBean.getPwd() == null) {
            return ResultUtil.error(601, "账号或者密码不能为空");
        } else if (userBean.getPwd().length() < 4) {
            return ResultUtil.error(601, "密码不能少于4位");
        } else if (userBean.getUid().length() < 4) {
            return ResultUtil.error(601, "账号不能少于4位");
        } else {
            userRepository.save(userBean);
            return ResultUtil.success();
        }
    }

    public ResultBean login(UserBean userBean) {
        UserBean bean = userRepository.findUserBeanByUid(userBean.getUid());
        if (bean == null) {
            return ResultUtil.error(601, "用户不存在");
        }
        if (!bean.getPwd().equals(userBean.getPwd())) {
            return ResultUtil.error(601, "密码错误");
        } else {
            Map map = new HashMap();
            map.put("uid", userBean.getUid());
            return ResultUtil.success(map);
        }
    }
}
