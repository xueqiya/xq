package com.yiya.xq.repository;

import com.yiya.xq.bean.UserBean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserBean, Integer> {
    UserBean findByUid(String uid);
}
