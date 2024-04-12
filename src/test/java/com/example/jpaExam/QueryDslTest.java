package com.example.jpaExam;

import com.example.jpaExam.article.Article;
import com.example.jpaExam.article.ArticleRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@SpringBootTest
public class QueryDslTest {

    @Autowired
    ArticleRepository articleRepository;

    @Test
    @Transactional
    @Rollback(value = false)
    void t1() {
//        List<Article> articleList = articleRepository.search("제목");
    }
    @Test
    @Transactional
    @Rollback(value = false)
    void t2() {

        // 제목, 내용, 작성자로 검색
        String keyword = "제목";
        List<String> types = List.of("content","title","memberName");

        // 제목, 내용으로 검색
        List<String> types2 = List.of("content","title");

        List<Article> articleList = articleRepository.search(types,keyword);

    }
}
