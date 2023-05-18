package catgirl.springboot.semiprojectv7.model;

import lombok.Data;

@Data
public class Board {
    private int bno;
    private String title;
    private String userid;
    private int thumbs;
    private int views;
    private String content;
    private String regdate;
}
