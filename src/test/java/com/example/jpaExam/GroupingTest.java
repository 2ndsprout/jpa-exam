package com.example.jpaExam;

import com.example.jpaExam.article.Article;
import com.example.jpaExam.article.ArticleRepository;
import com.example.jpaExam.article.CountPerYmDto;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@SpringBootTest
public class GroupingTest {

    @Autowired
    ArticleRepository articleRepository;

    @Test
    @Transactional
    @Rollback(value = false)
    void t1() {
        Random random = new Random();

        for(int i = 0; i < 100; i++) {

            int randInt = random.nextInt(12);

            Article article = new Article();
            article.setTitle("제목" + i);
            article.setContent("내용" + i);
            article.setCreateDate(LocalDateTime.now().minusMonths(randInt));

            articleRepository.save(article);
        }
    }

    @Test
    @Transactional
    @Rollback(value = false)
    void t2() {
        // 월별 게시물 등록 수

        List<CountPerYmDto> countPerYmDtos = articleRepository.findCountPerYm();
        for (CountPerYmDto dto : countPerYmDtos) {
            System.out.println(dto.getYm() + ":" + dto.getCnt());
        }


    }
    @Test
    @Transactional
    @Rollback(value = false)
    void t3 () {
        String sql = "select MyTest.name from MyTest";
        MyTest myTest = new MyTest();
        System.out.println(myTest.name);

        // 문자열 값은 에러 체크가 안된다.
        // 문자열이 아닌 코드는 툴이 문제를 체크해준다.
    }

}
class MyTest {
    String name;
}