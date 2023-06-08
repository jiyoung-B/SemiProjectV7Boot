package catgirl.springboot.semiprojectv7.dao;

import catgirl.springboot.semiprojectv7.model.GalAttach;
import catgirl.springboot.semiprojectv7.model.Gallery;
import catgirl.springboot.semiprojectv7.repository.GalleryRepository;
import catgirl.springboot.semiprojectv7.repository.GalleryaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("galdao")
public class GalleryDAOImpl implements GalleryDAO{
    // 생성자를 이용한 스프링 빈 주입
    private final GalleryRepository galleryRepository;
    private final GalleryaRepository galleryaRepository;

    @Autowired
    public GalleryDAOImpl(GalleryRepository galleryRepository, GalleryaRepository galleryaRepository) {
        this.galleryRepository = galleryRepository;
        this.galleryaRepository = galleryaRepository;
    }

    @Override
    public int insertGal(Gallery gallery) {

        return Math.toIntExact(galleryRepository.save(gallery).getGno());
    }

    @Override
    public int insertGalAttach(GalAttach ga) {

        return Math.toIntExact(galleryaRepository.save(ga).getGano());
    }
}
