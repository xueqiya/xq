package com.yiya.xq.repository;

import com.yiya.xq.bean.NoteBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface NoteRepository extends JpaRepository<NoteBean, Integer> {

    @Query(value = "select * from note where uid =?1 order by time desc limit ?2,?3 ", nativeQuery = true)
    List<NoteBean> getNote(String uid,int cutoff, int size);

    NoteBean findNoteBeanById(int id);

    @Transactional
    int deleteNoteBeanById(int id);

    @Modifying
    @Transactional
    @Query(value = "update note set  time=?1,title=?2,details=?3 where id = ?4", nativeQuery = true)
    int updateNoteById(String time, String title, String details, int id);
}