package mysite.test.reply.controller;

import lombok.RequiredArgsConstructor;
import mysite.test.article.domain.Article;
import mysite.test.article.service.ArticleService;
import mysite.test.reply.service.ReplyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/reply")
public class ReplyController {
    private final ArticleService articleService;
    private final ReplyService replyService;

    @PostMapping("/create/{id}")
    public String createReply(Model model, @PathVariable("id") Integer id, @RequestParam String content) {
        Article article = this.articleService.getArticle(id);
        this.replyService.create(article, content);
        return String.format("redirect:/article/detail/%s", id);
    }

    @PostMapping("/like/{articleId}/{replyId}")
    public String createReply(@PathVariable("articleId") Integer articleId, @PathVariable("replyId") Integer replyId) {
        this.replyService.setLike(replyId);

        return String.format("/redirect:/article/detail/%s, articleId");
    }
}
