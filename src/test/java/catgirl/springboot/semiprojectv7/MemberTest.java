package catgirl.springboot.semiprojectv7;

import catgirl.springboot.semiprojectv7.model.Member;
import catgirl.springboot.semiprojectv7.model.Zipcode;
import catgirl.springboot.semiprojectv7.repository.MemberRepository;
import catgirl.springboot.semiprojectv7.repository.ZipcodeRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

public class MemberTest {
    @Autowired
    MemberRepository memberRepository;

    @Test
    @DisplayName("showall")
    public void findAllMember(){
        List<Member> mbs = memberRepository.findAll();
        System.out.println(mbs);

    }

    @Test
    @DisplayName("member save")
    public void saveMember(){
        Member m = new Member(null, "abc123", "123456", "123467", "abc123", "987xyz", "123-456", "서울시 구로구 구로동", "더조은 IT 아카데미", "abc123@987xyz.co.kr", "010-1234-5678", null);
        memberRepository.save(m);

    }

    @Test
    @DisplayName("member update")
    public void updateMember(){
        Member m = new Member(2L, "987xyz", "777777", "123467",
                "abc123", "987xyz", "456-789", "서울시 구로구 구로동",
                "더 더 조은 아카데미", "qwer@987xyz.co.kr", "123-0000-0000", null);

        memberRepository.save(m);

    }

    @Test
    @DisplayName("member delete")
    public void deleteMember(){
        Member m = new Member();
        m.setMbno(2L);
        memberRepository.delete(m);

    }

    @Test
    @DisplayName("member login")
    public void loginMember(){
        Member m = new Member();
        m.setUserid("abc123");
        m.setPasswd("abd123"); // 틀리게 넣기
        assertNull(memberRepository.findByUseridAndPasswd(m.getUserid(), m.getPasswd()));
        m.setUserid("abc123");
        m.setPasswd("987xyz"); // 맞게 넣기
        assertNotNull(memberRepository.findByUseridAndPasswd(m.getUserid(), m.getPasswd()));


    }

}
