package catgirl.springboot.semiprojectv7.dao;

import catgirl.springboot.semiprojectv7.model.Board;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("brddao")
public class BoardDAOImpl implements BoardDAO{


    @Override
    public List<Board> selectBoard(int stbno) {
        return null;
    }

    @Override
    public List<Board> selectBoard(Map<String, Object> params) {
        return null;
    }

    @Override
    public int countBoard() {
        return 0;
    }

    @Override
    public int countBoard(Map<String, Object> params) {
        return 0;
    }

    @Override
    public int insertBoard(Board bd) {
        return 0;
    }

    @Override
    public Board selecOneBoard(String bno) {
        return null;
    }
}
