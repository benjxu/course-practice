package com.zucc.demo.dao;

import com.zucc.demo.model.WikiPageVo;

import java.util.List;

/**
 * Created by hxu on 7/2/17.
 */
public interface WikiPageDAO
{
    public List<WikiPageVo> getAllPages();
}