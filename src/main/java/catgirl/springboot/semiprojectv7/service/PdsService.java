package catgirl.springboot.semiprojectv7.service;

import catgirl.springboot.semiprojectv7.model.Pds;
import catgirl.springboot.semiprojectv7.model.PdsAttach;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface PdsService {
//    int newPds(Pds pds);
    Map<String, Object> newPds(Pds pds);

    //boolean newPdsAttach(MultipartFile attach, int pno);
    boolean newPdsAttach(MultipartFile attach, Map<String, Object> pinfo);

    Map<String, Object> readPds(Integer cpg);

    Pds readOnePds(int pno);

    PdsAttach readOnePdsAttach(int pno);

    HttpHeaders getHeader(String fname, String uuid);

    UrlResource getResource(String fname, String uuid);
}
