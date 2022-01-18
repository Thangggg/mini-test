package codegym.service;

import codegym.model.Branch;
import codegym.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BranchService implements IBranchService{
    @Autowired
    BranchRepository branchRepository;

    @Override
    public List<Branch> fillAll() {
        return (List<Branch>) branchRepository.findAll();
    }
}
