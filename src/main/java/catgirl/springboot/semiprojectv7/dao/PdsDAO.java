package catgirl.springboot.semiprojectv7.dao;

import catgirl.springboot.semiprojectv7.model.Pds;
import catgirl.springboot.semiprojectv7.model.PdsAttach;

public interface PdsDAO {

    int insertPds(Pds pds);
    int insertPdsAttach(PdsAttach pa);
}
