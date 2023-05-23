package catgirl.springboot.semiprojectv7.dao;

import catgirl.springboot.semiprojectv7.model.Board;

import java.util.List;
import java.util.Map;

public interface BoardDAO {

    Map<String, Object> selectBoard(int cpage);
    Map<String, Object> selectBoard(Map<String, Object> params);
    int insertBoard(Board bd);
    Board selecOneBoard(int bno);

}
