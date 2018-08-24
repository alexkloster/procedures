package com.procedures.web;

import com.procedures.model.DoctorModel;
import com.procedures.model.DoctorShortModel;
import com.procedures.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class WebController {

    private final DoctorService doctorService;

    @Autowired
    public WebController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @RequestMapping("/procedures")
    public String procedures(Model model) {
        List<DoctorModel> doctors = doctorService.getAll();
        model.addAttribute("doctors", doctors);
        return "procedures";
    }

    @RequestMapping("/add/doctor")
    public String addDoctor(@RequestBody DoctorShortModel name, Model model) {
        System.out.println(name);
        return "procedures";
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/hello")
    public String sayHello(@RequestParam("name") String name, Model model) {
        String n = doctorService.getDoctor("Alex").getName();
        model.addAttribute("name", n);
        return "hello";
    }
}
