package com.example.demo.Utils;

import java.util.List;

public class Page<T>{
    private int totalCount; //总记录数
    private int totalPage; //总页数
    private int rows; //每页显示的数据
    private int currentPage; //当前页数
    private List<T> list;   //每页存放的数据


    public int getCurrentPage(){
        return currentPage;
    }

    public void setCurrentPage(int currentPage){
        this.currentPage = currentPage;
    }

    public int getTotalCount(){
        return totalCount;
    }

    public void setTotalCount(int totalCount){
        this.totalCount = totalCount;
    }

    public int getTotalPage(){
        return totalPage;
    }

    public void setTotalPage(int totalPage){
        this.totalPage = totalPage;
    }

    public int getRows(){
        return rows;
    }

    public void setRows(int rows){
        this.rows = rows;
    }

    public List<T> getList(){
        return list;
    }

    public void setList(List<T> list){
        this.list = list;
    }
}





























