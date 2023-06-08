package catgirl.springboot.semiprojectv7.dao;

import catgirl.springboot.semiprojectv7.model.GalAttach;
import catgirl.springboot.semiprojectv7.model.Gallery;

public interface GalleryDAO {
    int insertGal(Gallery gallery);

    int insertGalAttach(GalAttach ga);
}
