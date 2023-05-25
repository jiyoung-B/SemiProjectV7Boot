package catgirl.springboot.semiprojectv7.dao;

import catgirl.springboot.semiprojectv7.model.Pds;
import catgirl.springboot.semiprojectv7.model.PdsAttach;

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
}
