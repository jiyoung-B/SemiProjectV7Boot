package catgirl.springboot.semiprojectv7.dao;

import catgirl.springboot.semiprojectv7.model.Pds;
import catgirl.springboot.semiprojectv7.model.PdsAttach;
import catgirl.springboot.semiprojectv7.model.PdsReply;

import java.util.List;
import java.util.Map;

public interface PdsDAO {

    int insertPds(Pds pds);
    int insertPdsAttach(PdsAttach pa);

    Map<String, Object> selectPds(int cpg);
    Pds selectOnePds(int pno);
    PdsAttach selectOnePdsAttach(int pno);

    void countDownload(int pno);

    List<String> selectFtype();
    List<PdsReply> selectPdsReply(int pno);

    // 댓글
    int insertReply(PdsReply reply);

    // 대댓글
    int insertRreply(PdsReply reply);
}
