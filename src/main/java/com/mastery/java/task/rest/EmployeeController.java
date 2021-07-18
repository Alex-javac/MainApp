package com.mastery.java.task.rest;

import com.mastery.java.task.dto.Employee;

import com.mastery.java.task.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmployeeController {

    private final EmployeeService es;

    public EmployeeController(EmployeeService es) {
        this.es = es;

    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("empJSP", new Employee());
        modelAndView.setViewName("index");
        return modelAndView;
    }
    @RequestMapping(value = "/check_all", method = RequestMethod.GET)
    public ModelAndView checkAll(@ModelAttribute("empJSP")Employee employee) {
        ModelAndView modelAndView = new ModelAndView();
        List<Employee> employees = es.getAllEmployees();
        modelAndView.setViewName("page2");
        modelAndView.addObject("empJSP", employees);
        return modelAndView;
    }
    @RequestMapping(value = "/check_id", method = RequestMethod.POST)
    public ModelAndView checkId(@ModelAttribute("empJSP")Employee employee) {
        ModelAndView modelAndView = new ModelAndView();
       employee = es.getEmployeeById(employee.getEmployeeId());
       modelAndView.setViewName("checkEmployee");
        modelAndView.addObject("empJSP", employee);
        return modelAndView;
    }
    @RequestMapping(value = "/check_gender", method = RequestMethod.POST)
    public ModelAndView checkGender(@ModelAttribute("empJSP")Employee employee) {
        ModelAndView modelAndView = new ModelAndView();
        List<Employee> employees = es.getEmployeesByGender(employee.getGender());
        modelAndView.setViewName("page2");
        modelAndView.addObject("empJSP", employees);
        return modelAndView;
    }

    @RequestMapping(value = "/check_last_name", method = RequestMethod.POST)
    public ModelAndView checkLastName(@ModelAttribute("empJSP")Employee employee) {
        ModelAndView modelAndView = new ModelAndView();
        List<Employee> employees = es.getEmployeesByLastName(employee.getLastName());
        modelAndView.setViewName("page2");
        modelAndView.addObject("empJSP", employees);
        return modelAndView;
    }

    @RequestMapping(value = "/check_job_title", method = RequestMethod.POST)
    public ModelAndView check(@ModelAttribute("empJSP")Employee employee) {
        ModelAndView modelAndView = new ModelAndView();
        List<Employee> employees = es.getEmployeesByJobTitle(employee.getJobTitle());
        modelAndView.setViewName("page2");
        modelAndView.addObject("empJSP", employees);
        return modelAndView;
    }

    @RequestMapping(value = "/check_department", method = RequestMethod.POST)
    public ModelAndView checkDepartment(@ModelAttribute("empJSP")Employee employee) {
        ModelAndView modelAndView = new ModelAndView();
        List<Employee> employees = es.getEmployeesByDepartment(employee.getDepartment());
        modelAndView.setViewName("page2");
        modelAndView.addObject("empJSP", employees);
        return modelAndView;
    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("empJSP", new Employee());
        modelAndView.setViewName("addEmployee");
        return modelAndView;
    }

    @RequestMapping(value = "/check-employee", method = RequestMethod.POST)
    public ModelAndView checkUserPost(@ModelAttribute("empJSP") Employee employee) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(employee);
        if(es.addEmployee(employee)){
            modelAndView.setViewName("checkEmployee");
        }else {
            modelAndView.setViewName("index");
        }
        modelAndView.addObject("empJSP", employee);
        return modelAndView;
    }
    @RequestMapping(value = "/delete_byID", method = RequestMethod.POST)
    public ModelAndView delete(@ModelAttribute("empJSP")Employee employee) {
        ModelAndView modelAndView = new ModelAndView();
        employee = es.getEmployeeById(employee.getEmployeeId());
        es.deleteEmployee(employee.getEmployeeId());
        modelAndView.setViewName("delete");
        modelAndView.addObject("empJSP", employee);
        return modelAndView;
    }
}
