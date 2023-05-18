package catgirl.springboot.semiprojectv7.dao;

import catgirl.springboot.semiprojectv7.model.Member;
import catgirl.springboot.semiprojectv7.model.Zipcode;

import java.util.List;

public interface JoinDAO {
    List<Zipcode> selectZipcode(String dong);

    int insertMember(Member m);
    int selectOneUserid(String uid);

    int selectOneMember(Member m);

}
