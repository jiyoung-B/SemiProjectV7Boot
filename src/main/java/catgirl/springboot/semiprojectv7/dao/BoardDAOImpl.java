package catgirl.springboot.semiprojectv7.dao;

import catgirl.springboot.semiprojectv7.model.Board;
import catgirl.springboot.semiprojectv7.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("brddao")
public class BoardDAOImpl implements BoardDAO{
    @Autowired
    BoardRepository boardRepository;


    @Override
    public List<Board> selectBoard(int cpage) {
        Pageable paging = PageRequest.of(cpage, 25);
        return boardRepository.findAll(paging).getContent();
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

        return Math.toIntExact(boardRepository.save(bd).getBno());
    }

    @Override
    public Board selecOneBoard(int bno) {
        boardRepository.countViewBoard((long) bno); // 조회수 증가 후 글 가져오기
        return boardRepository.findById((long)bno).get();
    }
}
