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

    private String desc;

    @Description("생성자ID")
    private String cretId;

    @Description("수정자ID")
    private String modId;

}
