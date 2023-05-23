package catgirl.springboot.semiprojectv7.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Setter
@Getter
public class Checkme {

    @NotBlank(message = "이름은 필수 입력항목입니다!!")
    private String name;
    @NotBlank(message = "주민번호는 필수 입력항목입니다!!")
    private String jumin1;
    @NotBlank(message = "주민번호는 필수 입력항목입니다!!")
    private String jumin2;

}
