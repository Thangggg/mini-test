package codegym.service;

import codegym.model.Staff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStaffService {
    public Page<Staff> fillAll(Pageable pageable);

    public List<Staff> fillAll();

    public void save(Staff staff);

    public void delete(long id);

    public Staff finById(long id);

    public List<Staff> findAllByNameContains(String name);

    public Page<Staff> findAllOrOrderByName(Pageable pageable);

}
