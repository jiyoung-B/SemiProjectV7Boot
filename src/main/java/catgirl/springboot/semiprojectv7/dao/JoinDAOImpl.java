package catgirl.springboot.semiprojectv7.dao;

import catgirl.springboot.semiprojectv7.model.Member;
import catgirl.springboot.semiprojectv7.model.Zipcode;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("jndao")
public class JoinDAOImpl implements JoinDAO{

    @Override
    public List<Zipcode> selectZipcode(String dong) {
        return null;
    }

    @Override
    public int insertMember(Member m) {
        return 0;
    }

    @Override
    public int selectOneUserid(String uid) {
        return 0;
    }

    @Override
    public int selectOneMember(Member m) {
        return 0;
    }
}