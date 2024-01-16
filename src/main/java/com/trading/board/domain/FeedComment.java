package com.trading.board.domain;

import com.trading.board.dto.FeedBoardCommentRequest;
import com.trading.config.orm.BaseTimeEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class FeedComment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private FeedBoard board;

    @Lob
    private byte[] image;

    @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL)
    private List<FeedCommentReply> replies = new ArrayList<>();

    private String comment;
    private String writer;
    private int likeCount;

    public static FeedComment from(FeedBoardCommentRequest request, FeedBoard board) throws IOException {
        return FeedComment.builder()
                .image(request.getImage() == null ? new byte[]{} : request.getImage().getBytes())
                .board(board)
                .comment(request.getComment())
                .writer(request.getWriter())
                .likeCount(0)
                .build();
    }
}
