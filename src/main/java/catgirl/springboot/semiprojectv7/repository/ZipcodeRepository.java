package catgirl.springboot.semiprojectv7.repository;

import catgirl.springboot.semiprojectv7.model.Zipcode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

// public interface ZipcodeRepository extends JpaRepository<Zipcode, Long> {
public interface ZipcodeRepository extends PagingAndSortingRepository<Zipcode, Long> {

    // 메서드 쿼리 : find엔티티명All, find엔티티명By컬럼명
    @Query("from Zipcode where dong like %:dong%")
    List<Zipcode> findZipcodeByDong(@Param("dong") String dong);

    // 전체 조회 중 페이징
    Page<Zipcode> findAll(Pageable pageable);

    // 검색 중 페이징
    //@Query("select z from Zipcode z where z.dong like %:dong%")
    //@Query("from Zipcode where dong like %:dong%") // 위의 쿼리와 겹쳐서 안됨.
    Page<Zipcode> findByDongLike(@Param("dong") String dong, Pageable pageable);
    //Page<Zipcode> findByDongLike(@Param("dong") String dong, Pageable pageable);
}
