package com.spring.study.controller;

import com.spring.study.dto.ArticleForm;
import com.spring.study.entity.Article;
import com.spring.study.serivce.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j  //로그를 찍을 수 있게 어노테이션 추가
@RestController
public class ArticleApiController {
    @Autowired
    private ArticleService articleservice;

    //GET
    //전체 찾기
    @GetMapping("/api/articles")
    public List<Article> index() {
        return articleservice.findIndex();
    }

    //단일 찾기
    @GetMapping("/api/article/{id}")
    public Article show(@PathVariable Long id) {
        return articleservice.findId(id);
    }

    //POST
    @PostMapping("/api/article")
    public ResponseEntity<Article> create(@RequestBody ArticleForm dto) {
        Article created = articleservice.create(dto);
        return (created != null) ?
                ResponseEntity.status(HttpStatus.OK).body(created) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    //PUT
    @PutMapping("/api/article/{id}")
    public ResponseEntity<Article> update(@PathVariable Long id, @RequestBody ArticleForm dto) {
        Article updated = articleservice.update(id, dto);
        return (updated != null) ?
                ResponseEntity.status(HttpStatus.OK).body(updated) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }


    //DELETE
    @DeleteMapping("/api/article/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Article deleted = articleservice.delete(id);
        return (deleted != null) ?
                ResponseEntity.status(HttpStatus.OK).build() :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }


    @PostMapping("/api/transaction-test")
    public ResponseEntity<List<Article>> transactionTest(@RequestBody List<ArticleForm> dtos) {
        List<Article> createdList = articleservice.createArticles(dtos);
        return (createdList != null) ?
                ResponseEntity.status(HttpStatus.OK).body(createdList) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
