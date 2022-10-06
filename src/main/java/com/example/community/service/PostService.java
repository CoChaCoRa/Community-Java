package com.example.community.service;

import com.example.community.Model.Post;
import com.example.community.Model.User;
import com.example.community.dto.PaginationDTO;
import com.example.community.dto.PostDTO;
import com.example.community.mapper.PostMapper;
import com.example.community.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostMapper postMapper;
    @Autowired
    private UserMapper userMapper;

    public PaginationDTO getList(Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<Post> posts = postMapper.getList();
        Integer totalCount = postMapper.getCount();

        PaginationDTO paginationDTO = createPaginationDTO(posts, totalCount, pageIndex, pageSize);

        return paginationDTO;
    }

    public PaginationDTO getListByCreator(Integer id, Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<Post> posts = postMapper.getListByCreator(id);
        Integer totalCount = postMapper.getCountByCreator(id);

        PaginationDTO paginationDTO = createPaginationDTO(posts, totalCount, pageIndex, pageSize);

        return paginationDTO;
    }

    public PostDTO getPostById(Integer id) {
        Post post = postMapper.getPostById(id);
        PostDTO postDTO = createPostDTO(post);

        return postDTO;
    }

    public PostDTO createPostDTO(Post post) {
        User user = userMapper.findById(post.getCreator());
        PostDTO postDTO = new PostDTO();
        BeanUtils.copyProperties(post, postDTO);
        postDTO.setUser(user);

        return postDTO;
    }

    public PaginationDTO createPaginationDTO(List<Post> posts,
                                             Integer totalCount,
                                             Integer pageIndex,
                                             Integer pageSize) {
        PaginationDTO paginationDTO = new PaginationDTO();
        paginationDTO.setPaginationDTO(totalCount, pageIndex, pageSize);

        List<PostDTO> postDTOList = new ArrayList<>();
        for (Post post : posts) {
            PostDTO postDTO = createPostDTO(post);
            postDTOList.add(postDTO);
        }

        paginationDTO.setPosts(postDTOList);
        return paginationDTO;
    }

    public void createOrUpdate(Post post) {
        if(post.getId() == null) {
            post.setGmtCreate(System.currentTimeMillis());
            post.setGmtModified(post.getGmtCreate());
            postMapper.create(post);
        } else {
            post.setGmtModified(System.currentTimeMillis());
            postMapper.updateById(post);
        }
    }
}
