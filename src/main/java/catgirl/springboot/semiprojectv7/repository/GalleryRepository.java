package catgirl.springboot.semiprojectv7.repository;

import catgirl.springboot.semiprojectv7.model.GalAttach;
import catgirl.springboot.semiprojectv7.model.Gallery;
import catgirl.springboot.semiprojectv7.model.Pds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface GalleryRepository extends JpaRepository<Gallery, Long> {
//    @Modifying
//    @Transactional
//    @Query("update Pds set views = views + 1 where pno = :pno")
//    void countViewById(@Param("pno") long pno);

    //    @Modifying
//    @Transactional
//    @Query("update Gallery set fdown = fdown + 1 where gno = :gno")
//    void countViewById(@Param("gno") long gno);
}
