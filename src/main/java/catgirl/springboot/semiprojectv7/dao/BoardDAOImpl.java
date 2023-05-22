package catgirl.springboot.semiprojectv7.dao;

import catgirl.springboot.semiprojectv7.model.Board;
import catgirl.springboot.semiprojectv7.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("brddao")
public class BoardDAOImpl implements BoardDAO{
    @Autowired
    BoardRepository boardRepository;


    @Override
    public List<Board> selectBoard(int cpage) {
        Pageable paging = //PageRequest.of(cpage, 25, Sort.by("bno").descending());
        PageRequest.of(cpage, 25, Sort.Direction.DESC, "bno");
        return boardRepository.findAll(paging).getContent();
    }

    @Override
    public List<Board> selectBoard(Map<String, Object> params) {
        String fkey = params.get("fkey").toString();
        String ftype = params.get("ftype").toString();
        int cpage = (int) params.get("stbno");
        Pageable paging =
                PageRequest.of(cpage, 25, Sort.Direction.DESC, "bno");

        List<Board> result = null;
        switch (ftype){
            case "title": // 제목으로 검색
                result = boardRepository.findByTitle(paging, fkey); break;
            case "titcont": // 제목+본문으로 검색
                result = boardRepository.findByTitleOrContent(paging, fkey, fkey); break;
            case "content": // 작성자로 검색
                result = boardRepository.findByUserid(paging, fkey); break;
            case "userid": // 본문으로 검색
                result = boardRepository.findByContent(paging, fkey); break;
        }
        return result;
    }

    @Override
    public int countBoard() {
        // select ceil(count(bno)/25) from board
        int allcnt = boardRepository.countBoardBy();

        return (int)Math.ceil(allcnt/25);
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
