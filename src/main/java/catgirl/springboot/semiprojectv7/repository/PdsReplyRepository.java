package catgirl.springboot.semiprojectv7.repository;

import catgirl.springboot.semiprojectv7.model.PdsReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PdsReplyRepository extends JpaRepository<PdsReply, Long> {

    //@Query("from PdsReply where pno = :pno order by refno asc")
    List<PdsReply> findByPnoOrderByRefnoAscRegdateAsc(int pno);
}
