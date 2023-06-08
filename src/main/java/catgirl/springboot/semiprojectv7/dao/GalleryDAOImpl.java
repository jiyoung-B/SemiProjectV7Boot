package catgirl.springboot.semiprojectv7.dao;

import catgirl.springboot.semiprojectv7.model.GalAttach;
import catgirl.springboot.semiprojectv7.model.Gallery;
import org.springframework.stereotype.Repository;

@Repository("galdao")
public class GalleryDAOImpl implements GalleryDAO{

    @Override
    public int insertGal(Gallery gallery) {
        return 0;
    }

    @Override
    public int insertGalAttach(GalAttach ga) {

        return 0;
    }
}
