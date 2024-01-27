package com.trading.domain.board;

import com.trading.common.annotation.Description;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "BoardViewHist")
public class BoardViewHist {

    @Id
    private String boardViewHistId;

//    @ManyToOne
//    @JoinColumn(name = "board_id")
    private String boardId;

    @Column(name = "cret_dtime")
    @CreatedDate
    private LocalDateTime cretDatetime;

    @Description("생성자ID")
    private String cretId;

}
