package catgirl.springboot.semiprojectv7.utils;

import catgirl.springboot.semiprojectv7.model.GalAttach;
import catgirl.springboot.semiprojectv7.model.PdsAttach;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component("galUtils")
public class GalleryUtils {
    // 이미지 파일 저장 위치
    @Value("${saveImgDir}")
    private String saveImgDir;

    public String makeUUID(){
        String uuid = LocalDateTime.now() + "" + LocalTime.now();
        uuid = uuid.replace("-", "")
                .replace(":", "")
                .replace(".", "");
        return uuid;

    };

    public GalAttach processUpload(List<MultipartFile> attachs, Map<String, Object> ginfo) {
            // 이미지 첨부 파일
            // 변수 여러개 하는 것 보다..... 세미콜론으로 하는게 나아

            // 이미지 첨부파일명과 사이즈는 먼저 리스트로 저장한 뒤 문자열로 변환
            // 업로드할 파일 정보 취득
            GalAttach ga = new GalAttach();
            ga.setGno((Integer) ginfo.get("gno"));
            List<String> fnames = new ArrayList<>();
            List<String> fsizes = new ArrayList<>();

            // 첨부된 파일들에 대한 반복처리
            for( MultipartFile attach : attachs){
                String fname = attach.getOriginalFilename();

             // 파일 확장자와 크기 추출
            int pos = fname.lastIndexOf(".") + 1;
            String ext = fname.substring(pos); //ftype 확장자
            String fsize = (attach.getSize() / 1024) + "";

            // 저장시 사용할 파일이름 생성
            // 시스템에 저장시 사용할 파일명 : 파일이름UUID.확장자
            String savefname = fname.substring(0, pos - 1);
            String fullname = savefname + ginfo.get("uuid") + "." + ext;
            savefname = saveImgDir + fullname;

            try {
                // 첨부파일을 파일시스템에 저장
                attach.transferTo(new File(savefname));

                // 첨부파일 정보를 리스트에 저장
                //fnames.add(fname); // 파일이름.확장자
                fnames.add(fullname); // 파일이름.확장자
                fsizes.add(fsize);
                System.out.println(
                        "에프네임, 에프사이즈 : " + fullname +','+ fsize + '.' + savefname);
            } catch (Exception ex) {
                System.out.println("업로드중 오류발생!");
                ex.printStackTrace();
            }
            } // for

        // 수집된 첨부파일 정보를 ga에 저장
        // join(구분자, 리스트변수) : 요소1;요소2;요소3
        ga.setFname(String.join(";", fnames));
        ga.setFsize(String.join(";", fsizes));
        System.out.println(ga.getFname() + " " + ga.getFsize());

            return ga;
        }

    public void makeThumbnail(GalAttach ga, Object uuid) {
    }
}
