package codegym.controller;

import codegym.model.Branch;
import codegym.model.Staff;
import codegym.service.BranchService;
import codegym.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class StaffController {
    @Autowired
    BranchService branchService;

    @Autowired
    StaffService staffService;

    @GetMapping("/staffs")
    public ModelAndView show() {
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("staffList", staffService.fillAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("staff", new Staff());
        modelAndView.addObject("branchList", branchService.fillAll());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute(value = "staff") Staff staff, @RequestParam long idBranch) {
        Branch branch = new Branch();
        branch.setId(idBranch);
        staff.setBranch(branch);
        staffService.save(staff);
        return "redirect:staffs";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam long id) {
        staffService.delete(id);
        return "redirect:/staffs";
    }

    @GetMapping("/edit")
    public ModelAndView showEdit(@RequestParam long id) {
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("staff", staffService.finById(id));
        modelAndView.addObject("branchList", branchService.fillAll());
        return modelAndView;
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute(value = "staff") Staff staff,@RequestParam long idBranch) {
        Branch branch = new Branch();
        branch.setId(idBranch);
        staff.setBranch(branch);
        staffService.save(staff);
        return "redirect:/staffs";
    }

    @GetMapping("/detail")
    public ModelAndView showDetail(@RequestParam long id) {
        ModelAndView modelAndView = new ModelAndView("/detail");
        modelAndView.addObject("staff", staffService.finById(id));
        return modelAndView;
    }

    @GetMapping("/sort")
    public ModelAndView sort() {
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("staffList", staffService.sort());
        return modelAndView;
    }


}
