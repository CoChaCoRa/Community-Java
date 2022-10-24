package com.example.community.service;

import com.example.community.Exception.CustomizedErrorCode;
import com.example.community.Exception.CustomizedException;
import com.example.community.mapper.CustomizedPostMapper;
import com.example.community.model.Post;
import com.example.community.model.PostExample;
import com.example.community.model.User;
import com.example.community.dto.PaginationDTO;
import com.example.community.dto.PostDTO;
import com.example.community.mapper.PostMapper;
import com.example.community.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import org.h2.util.StringUtils;
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
    private CustomizedPostMapper customizedPostMapper;
    @Autowired
    private UserMapper userMapper;

    public PaginationDTO getList(Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        PostExample postExample = new PostExample();
        postExample.setOrderByClause("gmt_modified desc");
        List<Post> posts = postMapper.selectByExample(postExample);
        long totalCount = postMapper.countByExample(new PostExample());

        PaginationDTO paginationDTO = createPaginationDTO(posts, totalCount, pageIndex, pageSize);

        return paginationDTO;
    }

    public PaginationDTO getListByCreator(Integer id, Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        PostExample postExample = new PostExample();
        postExample.createCriteria().andCreatorEqualTo(id);
        List<Post> posts = postMapper.selectByExample(postExample);
        postExample.clear();
        postExample.createCriteria().andCreatorEqualTo(id);
        long totalCount = postMapper.countByExample(postExample);

        PaginationDTO paginationDTO = createPaginationDTO(posts, totalCount, pageIndex, pageSize);

        return paginationDTO;
    }

    public PostDTO getPostById(Integer id) {
        Post post = postMapper.selectByPrimaryKey(id);
        if(post == null) throw new CustomizedException(CustomizedErrorCode.POST_NOT_FOUND);
        PostDTO postDTO = createPostDTO(post);

        return postDTO;
    }

    public PostDTO createPostDTO(Post post) {
        User user = userMapper.selectByPrimaryKey(post.getCreator());
        PostDTO postDTO = new PostDTO();
        BeanUtils.copyProperties(post, postDTO);
        postDTO.setUser(user);

        return postDTO;
    }

    public PaginationDTO createPaginationDTO(List<Post> posts,
                                             long totalCount,
                                             Integer pageIndex,
                                             Integer pageSize) {
        PaginationDTO paginationDTO = new PaginationDTO();
        paginationDTO.setPaginationDTO(totalCount, pageIndex, pageSize);

        List<PostDTO> postDTOList = new ArrayList<>();
        for (Post post : posts) {
            PostDTO postDTO = createPostDTO(post);
            postDTOList.add(postDTO);
        }

        paginationDTO.setData(postDTOList);
        return paginationDTO;
    }

    public void createOrUpdate(Post post) {
        if(post.getId() == null) {
            post.setGmtCreate(System.currentTimeMillis());
            post.setGmtModified(post.getGmtCreate());
            post.setViewCount(0);
            post.setCommentCount(0);
            post.setLikeCount(0);
            postMapper.insertSelective(post);
        } else {
            post.setGmtModified(System.currentTimeMillis());
            int update = postMapper.updateByPrimaryKeySelective(post);
            if(update != 1) throw new CustomizedException(CustomizedErrorCode.POST_NOT_FOUND);
        }
    }

    public void incView(Integer id) {
        Post post = new Post();
        post.setId(id);
        post.setViewCount(1);
        customizedPostMapper.incView(post);
    }

    public List<PostDTO> getRelatedListByTag(Integer id) {

        Post post = postMapper.selectByPrimaryKey(id);
        String tag = post.getTag();

        if(StringUtils.isNullOrEmpty(tag)) {
            return new ArrayList<>();
        }

        PostExample postExample = new PostExample();
        postExample.createCriteria()
                .andTagLike("%" + tag + "%")
                .andIdNotEqualTo(id);
        postExample.setOrderByClause("gmt_create desc");
        List<Post> relatedPosts = postMapper.selectByExample(postExample);

        List<PostDTO> relatedPostDTOs = new ArrayList<>();
        for(Post relatedPost : relatedPosts) {
            PostDTO postDTO = new PostDTO();
            BeanUtils.copyProperties(relatedPost, postDTO);
            relatedPostDTOs.add(postDTO);
        }

        return relatedPostDTOs;
    }
}
