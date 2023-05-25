package catgirl.springboot.semiprojectv7.controller;

import catgirl.springboot.semiprojectv7.model.Pds;
import catgirl.springboot.semiprojectv7.service.PdsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

@Controller
@RequestMapping("/pds")
public class PdsController {
    @Autowired
    PdsService pdssrv;

    @GetMapping("/list")
    public ModelAndView list(Integer cpg){
        ModelAndView mv = new ModelAndView();

        mv.setViewName("pds/list");
        if (cpg == null || cpg == 0) cpg = 1;


        Map<String, Object> bds = pdssrv.readBoard(cpg);

        mv.addObject("pdslist", bds.get("pdslist"));
        mv.addObject("cpg", cpg);
        mv.addObject("stpg", ((cpg - 1) / 10) * 10 + 1); // startPage = ((cpg - 1) / 10) * 10 + 1);
        mv.addObject("cntpg", bds.get("cntpg"));
        //mv.setViewName("board/list");

        return mv;
    }
    @GetMapping("/write")
    public String write(Model m){
        m.addAttribute("pds", new Pds());
        return "pds/write";
    }

    @PostMapping("/write") // 전송된 데이터 처리
    public String writeok(Pds pds,
                          MultipartFile attach) throws IOException {
        String viewPage = "error";

        Map<String, Object> pinfo = pdssrv.newPds(pds);

        if(!attach.isEmpty())   // 첨부파일이 존재한다면
            pdssrv.newPdsAttach(attach, pinfo);

        viewPage = "redirect:/pds/list";

        return viewPage;
    }

    @GetMapping("/down")
    public ResponseEntity<Resource> down(int pno) throws IOException {
        // 다운로드 전송할 파일 식별
        String savePath = "C:/Java/bootUpload/";
        String fname = "";
        if(pno == 1) fname = "cat.jpg";
        else if(pno == 2) fname = "write.html";
        else if(pno == 3) fname = "catzip.zip";

        // 파일이름에 한글이 포함된 경우 적절한 인코딩 작업 수행
        fname = UriUtils.encode(fname, StandardCharsets.UTF_8);

        // 다운로드할 파일 객체 생성
        UrlResource resource =
                new UrlResource("file:" + savePath + fname);

        // MIME 타입 지정
        // 브라우저에 다운로드할 파일에 대한 정보 제공
        HttpHeaders header = new HttpHeaders();
        header.add("Content-Type",
                Files.probeContentType(Paths.get(savePath+fname)));
        header.add("Content-Disposition",
                "attachment; filename=" + fname + "");

        // 브라우저로 파일 전송하기
        return ResponseEntity.ok().headers(header).body(resource);
    }

    @GetMapping("/view")
    public String view(@RequestParam int pno, Model m){
        ModelAndView mv = new ModelAndView();
        mv.addObject("pds", pdssrv.readPds(bno));
        mv.addObject("attach", pdssrv.readPdsAttach(bno));


        return "pds/view";
    }
}
