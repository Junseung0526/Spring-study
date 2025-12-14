package com.spring.study.controller;

import com.spring.study.dto.ArticleForm;
import com.spring.study.entity.Article;
import com.spring.study.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class ArticleController {
    //스프링 부트가 미리 생성해 놓은 레포지토리 객체 주임 (DI)
    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm() {
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm articleForm) {
        // 1. DTO를 엔티티로 변환
        Article article = articleForm.toEntity();
        log.info(articleForm.toString());

        // 2. 레포지토리로 엔티티를 DB에 저장
        Article saved = articleRepository.save(article);
        log.info(saved.toString());

        return "";
    }
}
