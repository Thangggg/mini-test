package codegym.repository;

import codegym.model.Branch;
import org.springframework.data.repository.CrudRepository;

public interface BranchRepository extends CrudRepository<Branch, Long> {
}
