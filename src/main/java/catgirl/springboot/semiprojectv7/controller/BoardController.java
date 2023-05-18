package catgirl.springboot.semiprojectv7.controller;

import catgirl.springboot.semiprojectv7.model.Board;
import catgirl.springboot.semiprojectv7.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService brdsrv;

    @GetMapping("/list")
    public ModelAndView list(@RequestParam Integer cpg){
        ModelAndView mv = new ModelAndView();

        mv.setViewName("board/list");
        if (cpg == null || cpg == 0) cpg = 1;
        // sungjuklist.jsp에 성적조회결과를 sjs라는 이름으로 넘김
        mv.addObject("bdlist", brdsrv.boardList(cpg));
        mv.addObject("cpg", cpg);
        mv.addObject("stpg", ((cpg - 1) / 10) * 10 + 1); // startPage = ((cpg - 1) / 10) * 10 + 1);
        mv.addObject("cntpg", brdsrv.countBoard()); // startPage = ((cpg - 1) / 10) * 10 + 1);
        //mv.setViewName("board/list");

        return mv;
    }

    @GetMapping("/find")  // 검색처리 - 매개변수 ftype, fkey 추가
    public ModelAndView find(int cpg, String ftype, String fkey){
        ModelAndView mv = new ModelAndView();
        mv.addObject("bdlist", brdsrv.readBoard(cpg, ftype, fkey));
        mv.addObject("cpg", cpg);
        mv.addObject("stpg", ((cpg - 1) / 10) * 10 + 1); // startPage = ((cpg - 1) / 10) * 10 + 1);
        mv.addObject("cntpg", brdsrv.countBoard(ftype, fkey)); // startPage = ((cpg - 1) / 10) * 10 + 1);
        mv.setViewName("board/list");


        return mv;
    }

    @GetMapping("/write")
    public String write(){
        return "board/write";
    }
    @PostMapping("/write")
    public String writeok(Board bd){
        String viewPage = "error";
        if(brdsrv.newBoard(bd)){
            viewPage = "redirect:/board/list?cpg=1";
        }
        return viewPage;
    }

    @GetMapping("/view")
    public ModelAndView view(@RequestParam String bno){
        ModelAndView mv = new ModelAndView();
        mv.addObject("bd", brdsrv.readOneBoard(bno));
        mv.setViewName("board/view");

        return mv;
    }

}
