package catgirl.springboot.semiprojectv7.repository;

import catgirl.springboot.semiprojectv7.model.Board;
import catgirl.springboot.semiprojectv7.model.Zipcode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    // 메서드 쿼리 : find엔티티명All, find엔티티명By컬럼명



}
