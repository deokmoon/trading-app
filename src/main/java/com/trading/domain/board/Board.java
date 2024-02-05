package com.trading.domain.board;

import com.trading.common.annotation.Description;
import com.trading.config.orm.BaseTimeEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "BoardBaseInfo")
public class Board extends BaseTimeEntity {

    @Id
    private String boardId;

    private String subject;

    private String boardDesc;

//    @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL)
//    private List<FeedComment> commentList;

    @Description("생성자ID")
    private String cretId;

    @Description("수정자ID")
    private String modId;

    private long likeCount = 0;

    public void increaseLikeCount() {
        this.likeCount = this.likeCount + 1;
    }
}
