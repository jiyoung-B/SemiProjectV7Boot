package catgirl.springboot.semiprojectv7.dao;

import catgirl.springboot.semiprojectv7.model.Member;

public interface MemberDAO {
    int selectLogin(Member m);
}
