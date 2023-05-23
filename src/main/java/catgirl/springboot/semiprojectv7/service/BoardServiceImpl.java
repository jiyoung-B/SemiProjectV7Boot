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
    public Map<String, Object> readBoard(int cpage) {

        return brddao.selectBoard(cpage - 1);
    }

    @Override
    public Map<String, Object> readBoard(int cpage, String ftype, String fkey) {
        int stbno = (cpage - 1);
        // 처리시 사용할 데이터들을 해쉬맵에 담아서 보냄
        Map<String, Object> params = new HashMap<>();
        params.put("stbno", stbno);
        params.put("ftype", ftype);
        params.put("fkey", fkey);

        return brddao.selectBoard(params);
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
