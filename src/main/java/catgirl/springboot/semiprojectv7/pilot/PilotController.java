package catgirl.springboot.semiprojectv7.pilot;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriUtils;
import sun.security.x509.RFC822Name;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
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
            String fmt = "yyyyMMddHHmmss";
            SimpleDateFormat sdf = new SimpleDateFormat(fmt);
            uuid = sdf.format(new Date());
            m.addAttribute("uuid", uuid);

            // 겹치지 않는 파일명 작성을 위해 유니크한 값 생성3
            uuid = LocalDate.now() + "" + LocalDateTime.now();
            //  C:\Java\bootUpload\cat2023-05-242023-05-24T12:02:51.086.jpg
            uuid = uuid.replace("-","")
                    .replace(":","").replace(".", "");
            m.addAttribute("uuid", uuid);

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

    @GetMapping("/showimg")
    @ResponseBody // view 없이 본문 출력
    public Resource showimg() throws MalformedURLException {
    String fname = "C:/Java/bootUpload/" + "cat.jpg";

    return new UrlResource("file:"+ fname);
    }




}
