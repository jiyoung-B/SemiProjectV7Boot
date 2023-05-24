package catgirl.springboot.semiprojectv7.service;

import catgirl.springboot.semiprojectv7.model.Pds;
import org.springframework.web.multipart.MultipartFile;

public interface PdsService {
    int newPds(Pds pds);

    boolean newPdsAttach(MultipartFile attach, int pno);
}
