package com.yiya.xq.controller;

import com.yiya.xq.bean.NoteBean;
import com.yiya.xq.bean.ResultBean;
import com.yiya.xq.service.NoteService;
import com.yiya.xq.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/appApi")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @RequestMapping(value = "/note")
    public ResultBean note(String uid, int pageNum, int size) {
        return ResultUtil.success(noteService.note(uid, pageNum, size));
    }

    @RequestMapping(value = "/saveNote")
    public ResultBean saveNoteBean(NoteBean noteBean) {
        noteService.saveNote(noteBean);
        return ResultUtil.success();
    }

    @RequestMapping(value = "/deleteNote")
    public ResultBean deleteNoteBean(int id) {
        noteService.deleteNoteBean(id);
        return ResultUtil.success();
    }

    @RequestMapping(value = "/updateNote")
    public ResultBean updateNoteBean(NoteBean noteBean) {
        if (noteService.updateNoteById(noteBean) > 0) {
            return ResultUtil.success();
        } else {
            return ResultUtil.error(601, "更新失败");
        }
    }

    @RequestMapping(value = "/findNoteBeanById")
    public ResultBean findNoteBeanById(int id) {
        return ResultUtil.success(noteService.findNoteBeanById(id));
    }

}
