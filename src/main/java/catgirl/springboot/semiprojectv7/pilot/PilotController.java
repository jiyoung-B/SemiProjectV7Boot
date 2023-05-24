package catgirl.springboot.semiprojectv7.pilot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/pilot")
public class PilotController {

    @GetMapping("/write")
    public String write() {
        return "pilot/write";
    }

    @PostMapping("/write") // 전송된 데이터 처리
    public String writeok(String title, String content,
                          MultipartFile attach, Model m) throws IOException {

        // 일반 폼 요소 처리
        m.addAttribute("title", title);
        m.addAttribute("content", content);

        // 멀티파트 폼 요소 처리
        if (attach.isEmpty())
            m.addAttribute("attach", "첨부파일이 없어요!!");
        else{
            String fnmae = attach.getOriginalFilename();

            // 업로드한 파일이름 알아내기
            m.addAttribute("filename", fnmae);
            // 업로드한 파일종류 알아내기
            m.addAttribute("filetype", attach.getContentType());
            // 업로드한 파일크기 알아내기
            m.addAttribute("filesize", attach.getSize()/1024);

            // 겹치지 않는 파일명 작성을 위해 유니크한 값 생성1
            // 파일이름 + uuid + 확장자
            // abc.jpg -> abc f9e3a0ba-cd0f-4031-bee2-900173d9d04a.jpg
            String uuid = UUID.randomUUID().toString().replace("-",""); // uuid에서 "-" 제거하고 string으로 반환

            m.addAttribute("uuid", uuid);

            // 파일이름과 확장자 분리하기
            String fileName = fnmae.split("[.]")[0];
            String fileExt = fnmae.split("[.]")[1];


            // 겹치지 않는 파일명 작성을 위해 유니크한 값 생성2

            // 업로드한 파일 저장하기
            attach.transferTo(new File("C:/Java/bootUpload/"
                   + fileName + uuid + "." + fileExt));
        }

        return "pilot/list";
    }
    @GetMapping("/list")
    public String list() {
        return "pilot/list";
    }



}
