package mysite.test.article;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class ArticleForm {
    @NotEmpty(message = "제목이 없습니다.")
    @Size(max = 200)
    private String subject;

    @NotEmpty(message = "내용이 없습니다.")
    private String content;
}
