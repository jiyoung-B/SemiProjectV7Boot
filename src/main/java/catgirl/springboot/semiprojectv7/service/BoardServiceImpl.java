package catgirl.springboot.semiprojectv7.service;

import catgirl.springboot.semiprojectv7.dao.BoardDAO;
import catgirl.springboot.semiprojectv7.model.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("brdsrv")
public class BoardServiceImpl implements BoardService{
    @Autowired
    private BoardDAO brddao;
    @Override
    public List<Board> boardList(int cpage) {// 현재페이지를 알아야하니 cpage

        int stbno = (cpage -1) * 25; // 25page씩나타넴
        return brddao.selectBoard(stbno);
    }

    @Override
    public List<Board> readBoard(int cpage, String ftype, String fkey) {
        int stbno = (cpage - 1) * 25;
        // 처리시 사용할 데이터들을 해쉬맵에 담아서 보냄
        Map<String, Object> params = new HashMap<>();
        params.put("stbno", stbno);
        params.put("ftype", ftype);
        params.put("fkey", fkey);

        return brddao.selectBoard(params);  // 나중에 if 써서 메서드 합칠 수 있어.
    }

    @Override
    public int countBoard() {

        return brddao.countBoard();
    }

    @Override
    public int countBoard(String ftype, String fkey) {
        // 처리시 사용할 데이터들을 해쉬맵에 담아서 보냄
        Map<String, Object> params = new HashMap<>();
        params.put("ftype", ftype);
        params.put("fkey", fkey);

        return brddao.countBoard(params);
    }

    @Override
    public boolean newBoard(Board bd) {
        boolean result = false;
        if(brddao.insertBoard(bd) > 0) {result = true;}
        return result;
    }

    @Override
    public Board readOneBoard(int bno) {
        return brddao.selecOneBoard(bno);
    }
}
