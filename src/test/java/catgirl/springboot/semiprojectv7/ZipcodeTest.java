package catgirl.springboot.semiprojectv7;

import catgirl.springboot.semiprojectv7.model.Zipcode;
import catgirl.springboot.semiprojectv7.repository.ZipcodeRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static oracle.sql.DatumWithConnection.assertNotNull;

@SpringBootTest

public class ZipcodeTest {
    @Autowired
    ZipcodeRepository zipcodeRepository;

    @Test
    @DisplayName("zipcode")
    public void findZipByDong(){
        String dong = "구로";
        List<Zipcode> addr = zipcodeRepository.findZipcodeByDong(dong);
        System.out.println(addr);

    }

}
