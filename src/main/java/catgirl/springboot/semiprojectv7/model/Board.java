package catgirl.springboot.semiprojectv7.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="board")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;
    private String title;
    private String userid;
    @Column(insertable = false, updatable = false)
    private Integer thumbs;
    @Column(insertable = false, updatable = false)
    private Integer views;
    private String content;
    @CreatedDate
    @Column(insertable = false, updatable = false)
    private LocalDateTime regdate;


}
