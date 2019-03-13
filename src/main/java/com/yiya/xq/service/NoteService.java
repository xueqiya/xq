package com.yiya.xq.service;

import com.yiya.xq.bean.NoteBean;
import com.yiya.xq.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    @Autowired
    NoteRepository noteRepository;

    public List<NoteBean> note(String uid,int pageNum, int size) {
        int cutoff = (pageNum - 1) * size;
        return noteRepository.getNote(uid,cutoff, size);
    }

    public NoteBean saveNote(NoteBean noteBean) {
        return noteRepository.save(noteBean);
    }

    public NoteBean findNoteBeanById(int id) {
        return noteRepository.findNoteBeanById(id);
    }

    public int deleteNoteBean(int id) {
        return noteRepository.deleteNoteBeanById(id);
    }

    public int updateNoteById(NoteBean noteBean) {
        return noteRepository.updateNoteById(noteBean.getTime(), noteBean.getTitle(), noteBean.getDetails(), noteBean.getId());
    }
}
