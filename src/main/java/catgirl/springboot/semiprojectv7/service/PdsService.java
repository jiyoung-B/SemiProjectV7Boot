package catgirl.springboot.semiprojectv7.service;

import catgirl.springboot.semiprojectv7.model.Pds;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface PdsService {
//    int newPds(Pds pds);
    Map<String, Object> newPds(Pds pds);

    //boolean newPdsAttach(MultipartFile attach, int pno);
    boolean newPdsAttach(MultipartFile attach, Map<String, Object> pinfo);
}
