package catgirl.springboot.semiprojectv7;

import catgirl.springboot.semiprojectv7.model.Zipcode;
import catgirl.springboot.semiprojectv7.repository.ZipcodeRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

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

    @Test
    @DisplayName("zipcode page1")
    public void pageZipcode(){
        Pageable pageable = PageRequest.of(1, 15);
        Page<Zipcode> page = zipcodeRepository.findAll(pageable);
        List<Zipcode> zips = page.getContent();
        System.out.println(zips);

    }

    @Test
    @DisplayName("zipcode page2")
    public void page2Zipcode(){
        String dong = "%"+"구로"+"%";
        Pageable pageable = PageRequest.of(0, 15); // 1페이지
        Page<Zipcode> page = zipcodeRepository.findByDongLike(dong, pageable);
        List<Zipcode> zips = page.getContent();
        System.out.println(zips);
    }

}
