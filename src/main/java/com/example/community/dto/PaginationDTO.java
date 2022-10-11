package com.example.community.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PaginationDTO<T> {
    private List<T> data;
    private boolean showPrevious;
    private boolean showFirst;
    private boolean showNext;
    private boolean showEnd;
    private Integer currentPage;
    private Integer totalPages;
    private List<Integer> pages = new ArrayList<>();

    public void setPaginationDTO(Long totalCount, Integer pageIndex, Integer pageSize){
        this.totalPages = Math.toIntExact(Math.ceilDiv(totalCount, pageSize));
        if(pageIndex < 1) pageIndex = 1;
        if(pageIndex > totalPages) pageIndex = totalPages;
        this.currentPage = pageIndex;

        // 添加当前页的前3页和后3页的index（如果有）
        pages.add(currentPage);
        for(int i = 1; i <= 2; i++) {
            if(currentPage - i > 0) {
                pages.add(0,currentPage-i);
            }
            if(currentPage + i <= totalPages) {
                pages.add(currentPage+i);
            }
        }

        //是否展示第一页/下一页/上一页/最后一页
        if(pages.contains(1)){
            showFirst = false;
        }
        else {
            showFirst = true;
        }
        if(currentPage.equals(1)) {
            showPrevious = false;
        }
        else {
            showPrevious = true;
        }
        if(currentPage.equals(totalPages)){
            showNext = false;
        }
        else {
            showNext = true;
        }
        if(pages.contains(totalPages)) {
            showEnd = false;
        }
        else {
            showEnd = true;
        }
    }
}
