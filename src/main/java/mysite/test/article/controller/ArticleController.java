package mysite.test.article.controller;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import mysite.test.article.ArticleForm;
import mysite.test.article.domain.Article;
import mysite.test.article.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/article")
@AllArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @RequestMapping("/list")
    public String showArticleList(@NotNull Model model) {
        List<Article> articleList = this.articleService.getList();
        model.addAttribute("articleList", articleList);

        return "articleList";
    }

    @RequestMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        Article article = this.articleService.getArticle(id);
        model.addAttribute("article", article);

        return "articleDetail";
    }

    @GetMapping("/create")
    public String articleCreate(ArticleForm articleForm) {
        return "articleForm";
    }

    @PostMapping("/create")
    public String questionCreate(@Valid ArticleForm articleForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "articleForm";
        }
        this.articleService.create(articleForm.getSubject(), articleForm.getContent());
        return "redirect:/article/list";
    }
}
