package com.spring.study.dto;

import com.spring.study.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class CommentDto {
    private Long id;
    private String articleId;
    private String nickname;
    private String body;

    public CommentDto(Long id, Long articleId, String nickname, String body) {
        this.id = id;
        this.articleId = articleId.toString();
        this.nickname = nickname;
        this.body = body;
    }

    public static CommentDto createCommentDto(Comment comment) {
        return new CommentDto(
                comment.getId(),
                comment.getArticle().getId(),
                comment.getNickname(),
                comment.getBody()
        );
    }
}
