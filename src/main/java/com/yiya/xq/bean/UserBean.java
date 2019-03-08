package com.yiya.xq.bean;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserBean {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "uid")
    private String uid;

    @Column(name = "pwd")
    private String pwd;

    public UserBean() {

    }

    public UserBean(String uid, String pwd) {
        this.uid = uid;
        this.pwd = pwd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
