package catgirl.springboot.semiprojectv7.repository;

import catgirl.springboot.semiprojectv7.model.GalAttach;
import catgirl.springboot.semiprojectv7.model.Gallery;
import catgirl.springboot.semiprojectv7.model.PdsAttach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface GalleryaRepository extends JpaRepository<GalAttach, Long> {
    //PdsAttach findByPno(int pno);

//    @Modifying
//    @Transactional
//    @Query("update Gallery set fdown = fdown + 1 where gno = :gno")
//    void countViewById(@Param("gno") long gno);

    // 특정 컬럼만 가져오고 싶다면 그걸 담는 List가 필요한데 하나 담는데 그릇 변수(?) 만들기 뭐해서?
    // native로 작성하면 편해 그러려면 소문자로, 테이블 이름과 똑같이.
    // 파일확장자만 따로 조회해서 리스트에 저장 - native query 사용
//    @Query(value = "select ftype from pdsattach", nativeQuery = true)
//    List<String> findByFtypes();
}
