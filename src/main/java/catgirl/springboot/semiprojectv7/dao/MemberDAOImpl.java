package catgirl.springboot.semiprojectv7.dao;

import catgirl.springboot.semiprojectv7.model.Member;
import org.springframework.stereotype.Repository;

@Repository("mdao")
public class MemberDAOImpl implements MemberDAO{

    @Override
    public int selectLogin(Member m) {
        return 0;
    }
}
