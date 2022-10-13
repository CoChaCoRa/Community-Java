package com.example.community.controller;

import com.example.community.Exception.CustomizedErrorCode;
import com.example.community.dto.CommentDTO;
import com.example.community.dto.ResultDTO;
import com.example.community.enums.CommentTypeEnum;
import com.example.community.mapper.CommentMapper;
import com.example.community.model.Comment;
import com.example.community.model.User;
import com.example.community.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CommentController {

    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private CommentService commentService;

    @ResponseBody
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public Object post(@RequestBody CommentDTO commentDTO,
                       HttpServletRequest request){

        User user = (User) request.getSession().getAttribute("user");
        if(user == null) {
            return ResultDTO.errorOf(CustomizedErrorCode.NO_LOGIN);
        }

        Comment comment = new Comment();
        comment.setCreator(user.getId());
        comment.setParentId(commentDTO.getParentId());
        comment.setParentType(commentDTO.getParentType());
        comment.setContent(commentDTO.getContent());
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setGmtModified(System.currentTimeMillis());
        commentService.insert(comment);

        return ResultDTO.success();
    }

    @ResponseBody
    @RequestMapping(value = "/comment/{id}", method = RequestMethod.GET)
    public ResultDTO<List<CommentDTO>> getList(@PathVariable(name = "id") Integer id,
                                               Model model) {

        List<CommentDTO> commentDTOList = commentService.getListByParentId(id, CommentTypeEnum.COMMENT);
        return ResultDTO.success(commentDTOList);
    }

}
