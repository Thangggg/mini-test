package codegym.service;

import codegym.model.Staff;
import codegym.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class StaffService implements IStaffService{
    @Autowired
    StaffRepository repository;

    @Override
    public List<Staff> fillAll() {
        return (List<Staff>) repository.findAll();
    }

    @Override
    public void save(Staff staff) {
        repository.save(staff);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

    @Override
    public Staff finById(long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Staff> sort(){
        List<Staff> list = fillAll();
        list.sort(Comparator.comparing(Staff::getAge));
        return list;
    }
}
