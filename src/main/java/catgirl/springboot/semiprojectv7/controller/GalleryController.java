package catgirl.springboot.semiprojectv7.controller;

import catgirl.springboot.semiprojectv7.model.Gallery;
import catgirl.springboot.semiprojectv7.model.Pds;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/gallery")
public class GalleryController {

    @GetMapping("/list")
    public String list(){
        return "gallery/list";
    }

    @GetMapping("/write")
    public String write(Model m){
        m.addAttribute("gallery", new Gallery());
        return "gallery/write";
    }

    @PostMapping("/write") // 전송된 데이터 처리
    public String writeok(Gallery gallery,
                          List<MultipartFile> attachs) throws IOException {
        String viewPage = "error";

//        Map<String, Object> pinfo = pdssrv.newPds(pds);
//
//        if(!attach.isEmpty())   // 첨부파일이 존재한다면
//            pdssrv.newPdsAttach(attach, pinfo);
//
//        viewPage = "redirect:/pds/list";

        return viewPage;
    }


}
