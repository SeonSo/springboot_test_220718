package mysite.test;

import mysite.test.article.dao.ArticleRepository;
import mysite.test.article.domain.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TestApplicationTests {

	@Autowired
	private ArticleRepository articleRepository;
	@Test
	void testJpa() {
		Article q1 = new Article();
		q1.setSubject("sbb가 무엇인가요?");
		q1.setContent("sbb에 대해서 알고 싶습니다.");
		q1.setCreateDate(LocalDateTime.now());
		this.articleRepository.save(q1);  // 첫번째 질문 저장

		Article q2 = new Article();
		q2.setSubject("스프링부트 모델 질문입니다.");
		q2.setContent("id는 자동으로 생성되나요?");
		q2.setCreateDate(LocalDateTime.now());
		this.articleRepository.save(q2);  // 두번째 질문 저장
	}

	@Test
	void testJpaTest() {
		List<Article> all = this.articleRepository.findAll();
		assertEquals(5, all.size());

		Article q = all.get(3);
		assertEquals("sbb가 무엇인가요?", q.getSubject());
	}

}
