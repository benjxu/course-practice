package com.zucc.demo.controller;

import com.zucc.demo.dao.WikiPageDAO;
import com.zucc.demo.model.WikiPageVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hxu on 7/2/17.
 */
@Controller
@RequestMapping("/wiki-pages")
public class WikiPagesController {
    private List<WikiPageVo> pages = new ArrayList<>();
    private static final Logger logger = LoggerFactory.getLogger(WikiPagesController.class);

    @Autowired
    WikiPageDAO dao;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView search() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("WikiPagesSearch");
        return mav;
    }

    @RequestMapping(value="/getPages.do", method=RequestMethod.POST)
    @ResponseBody
    public List<WikiPageVo> getUser(@RequestBody SearchParam searchParam) {
        logger.info("getPages {}", searchParam.getWord());
        if (pages.isEmpty()) {
            pages = dao.getAllPages();
        }

        List<WikiPageVo> result;
        if (StringUtils.isEmpty(searchParam.getWord())) {
            result = pages.subList(1, 10);
        } else {
            result = new ArrayList<>();
            for (WikiPageVo page : pages) {
                if (page.getTitle().contains(searchParam.getWord())) {
                    result.add(page);
                    if (result.size() >= 10) break;
                }
            }
        }
        return result;
    }

    @RequestMapping(value="/suggestWord.do", method=RequestMethod.POST)
    @ResponseBody
    public List<String> suggestWord(@RequestBody SearchParam searchParam) {
        logger.info("suggestWord {}", searchParam.getWord());
        if (pages.isEmpty()) {
            pages = dao.getAllPages();
        }

        List<String> result;
        if (StringUtils.isEmpty(searchParam.getWord())) {
            result = new ArrayList<>();
        } else {
            result = new ArrayList<>();
            for (WikiPageVo page : pages) {
                if (page.getTitle().contains(searchParam.getWord())) {
                    result.add(page.getTitle());
                    if (result.size() >= 10) break;
                }
            }
        }
        return result;
    }
}
