package mysite.test.article.service;

import lombok.RequiredArgsConstructor;
import mysite.test.article.dao.ArticleRepository;
import mysite.test.article.domain.Article;
import mysite.test.util.DataNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    public List<Article> getList() {
        return this.articleRepository.findAll();
    }

    public Article getArticle(Integer id) {
        Optional<Article> opArticle = this.articleRepository.findById(id);
        if (opArticle.isPresent()) {
            Article article = opArticle.get();
            article.setView(article.getView()+1);
            this.articleRepository.save(article);
            return article;
        } else {
            throw new DataNotFoundException("article not found");
        }
    }

    public void create(String subject, String content) {
        Article article = new Article();
        article.setSubject(subject);
        article.setContent(content);
        article.setCreateDate(LocalDateTime.now());
        this.articleRepository.save(article);
    }
}
