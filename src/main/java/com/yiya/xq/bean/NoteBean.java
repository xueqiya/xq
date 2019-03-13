package com.yiya.xq.bean;

import javax.persistence.*;

@Entity
@Table(name = "note")
public class NoteBean {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "uid")
    private String uid;

    @Column(name = "title")
    private String title;

    @Column(name = "time")
    private String time;

    @Column(name = "details")
    private String details;

    public NoteBean() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
