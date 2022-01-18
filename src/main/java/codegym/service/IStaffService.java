package codegym.service;

import codegym.model.Staff;

import java.util.List;

public interface IStaffService {
    public List<Staff> fillAll();

    public void save(Staff staff);

    public void delete(long id);

    public Staff finById(long id);

    public List<Staff> sort();

}
