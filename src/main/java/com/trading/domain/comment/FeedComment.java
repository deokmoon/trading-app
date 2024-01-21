package com.trading.domain.comment;

import com.trading.config.orm.BaseTimeEntity;
import com.trading.domain.board.FeedBoard;
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
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
    private List<FeedCommentReply> replies;

    private String comment;
    private String writer;
    private int likeCount;

}
