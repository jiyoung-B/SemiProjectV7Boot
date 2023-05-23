package catgirl.springboot.semiprojectv7.controller;

import catgirl.springboot.semiprojectv7.model.Board;
import catgirl.springboot.semiprojectv7.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService brdsrv;

    @GetMapping("/list")
    public ModelAndView list(Integer cpg){
        ModelAndView mv = new ModelAndView();

        mv.setViewName("board/list");
        if (cpg == null || cpg == 0) cpg = 1;


        Map<String, Object> bds = brdsrv.readBoard(cpg);

        mv.addObject("bdlist", bds.get("bdlist"));
        mv.addObject("cpg", cpg);
        mv.addObject("stpg", ((cpg - 1) / 10) * 10 + 1); // startPage = ((cpg - 1) / 10) * 10 + 1);
        mv.addObject("cntpg", bds.get("cntpg"));
        //mv.setViewName("board/list");

        return mv;
    }

    @GetMapping("/find")  // 검색처리 - 매개변수 ftype, fkey 추가
    public ModelAndView find(int cpg, String ftype, String fkey){
        ModelAndView mv = new ModelAndView();

        Map<String, Object> bds = brdsrv.readBoard(cpg, ftype, fkey);

        mv.addObject("bdlist", bds.get("bdlist"));
        mv.addObject("cpg", cpg);
        mv.addObject("stpg", ((cpg - 1) / 10) * 10 + 1);
        mv.addObject("cntpg", bds.get("cntpg"));
        mv.setViewName("board/list");


        return mv;
    }

    @GetMapping("/write")
    public String write(Model m){

        // validation을 위한 첫번째 코드
        m.addAttribute("board", new Board());

        return "board/write";
    }
    @PostMapping("/write")
    public String writeok(@Valid Board board,
                          BindingResult br){  // 서버가 정상적으로 작동하지 않았을 때 오류가 bindingresult에 쌓인다.
        String viewPage = "redirect:/board/list?cpg=1";

        if(br.hasErrors()) // 유효성 검사시 오류가 발생하면
            viewPage = "board/write";
        else
            brdsrv.newBoard(board);

        return viewPage;
    }

    @GetMapping("/view")
    public ModelAndView view(@RequestParam int bno){
        ModelAndView mv = new ModelAndView();
        mv.addObject("bd", brdsrv.readOneBoard(bno));
        mv.setViewName("board/view");

        return mv;
    }

}
