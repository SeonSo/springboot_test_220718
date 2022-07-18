package mysite.test.reply.service;

import lombok.RequiredArgsConstructor;
import mysite.test.article.domain.Article;
import mysite.test.reply.dao.ReplyRepository;
import mysite.test.reply.domain.Reply;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class ReplyService {
    private final ReplyRepository replyRepository;

    public void create(Article article, String content) {
        Reply reply = new Reply();
        reply.setContent(content);
        reply.setCreateDate(LocalDateTime.now());
        reply.setArticle(article);
        this.replyRepository.save(reply);
    }
}
