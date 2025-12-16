package com.spring.study.serivce;

import com.spring.study.dto.ArticleForm;
import com.spring.study.entity.Article;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleServiceTest {
    @Autowired
    ArticleService articleService;

    @Test
    void findIndex() {
        // 1. 예상 데이터
        Article a = new Article(1L, "AAAA", "1111");
        Article b = new Article(2L, "BBBB", "2222");
        Article c = new Article(3L, "CCCC", "3333");
        List<Article> expected = new ArrayList<Article>(Arrays.asList(a, b, c));

        // 2. 실제 데이터
        List<Article> articles = articleService.findIndex();

        // 3. 비교 및 검증
        assertEquals(expected.toString(), articles.toString());
    }

    @Test
    void findId() {
        // 1. 예상 데이터
        Long id = 1L;
        Article expected = new Article(id, "AAAA", "1111");

        // 2. 실제 데이터
        Article article = articleService.findId(id);

        // 3. 비교 및 검증
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    @Transactional
    void create_성공_title과_content만_있는_dto_입력() {
        // 1. 예상 데이터
        String title = "라라라라";
        String content = "4444";
        ArticleForm dto = new ArticleForm(null, title, content);
        Article expected = new Article(4L, title, content);

        // 2. 실제 데이터
        Article actual = articleService.create(dto);

        // 3. 비교 및 검증
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void create_실패_id가_포함된_dto_입력(){
        // 1. 예상 데이터
        Long id = 4L;
        String title = "라라라라";
        String content = "4444";
        ArticleForm dto = new ArticleForm(id, title, content);
        Article expected = null;

        // 2. 실제 데이터
        Article actual = articleService.create(dto);

        // 3. 비교 및 검증
        assertEquals(expected, actual);
    }
}
