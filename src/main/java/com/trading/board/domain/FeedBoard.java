package com.trading.board.domain;

import com.trading.board.constants.BoardType;
import com.trading.board.dto.FeedBoardRequest;
import com.trading.config.orm.BaseTimeEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.util.List;

@Getter
@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FeedBoard extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private byte[] image;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    private List<FeedComment> comments;

    private String marketCode;

    @Enumerated(EnumType.STRING)
    private BoardType boardType;

    @ManyToMany
    @JoinTable(
            name = "board_tag",
            joinColumns = @JoinColumn(name = "board_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tags;

    private String title;
    private String content;
    private String writer;
    private int viewCount;
    private int bookmarksCount;
    private int likeCount;
    private boolean isLike;
    private boolean isFollow;


    public static FeedBoard from(FeedBoardRequest request) throws IOException {
        return FeedBoard.builder()
                .image(request.getImage().getBytes())
                .title(request.getTitle())
                .content(request.getContent())
                .boardType(request.getBoardType())
                .marketCode(request.getMarketCode())
                .viewCount(0)
                .bookmarksCount(0)
                .writer(request.getWriter())
                .build();
    }
}
