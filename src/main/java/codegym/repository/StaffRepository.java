package codegym.repository;

import codegym.model.Staff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface StaffRepository extends PagingAndSortingRepository<Staff, Long> {
    public List<Staff> findAllByNameContains(String name);

    @Query(nativeQuery = true, value = "select * from staff order by name")
    public Page<Staff> findAllOrOrderByName(Pageable pageable);


}
