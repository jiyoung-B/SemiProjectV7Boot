package catgirl.springboot.semiprojectv7.dao;

import catgirl.springboot.semiprojectv7.model.Member;
import catgirl.springboot.semiprojectv7.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("mdao")
public class MemberDAOImpl implements MemberDAO{

    @Autowired
    MemberRepository memberRepository;

    // 로그인 가능 여부 확인
    @Override
    public int selectLogin(Member m) {
        int isLogin = -1;
        if(memberRepository.findByUseridAndPasswd(m.getUserid(), m.getPasswd()) != null)
            isLogin = 1;

        return isLogin;
    }
}
