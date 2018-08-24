package com.procedures.web;

import com.procedures.model.DoctorDto;
import com.procedures.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HelloController {

    private final DoctorService doctorService;

    @Autowired
    public HelloController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @RequestMapping("/procedures")
    public String procedures(Model model) {
        List<DoctorDto> doctors = doctorService.getAll();
        model.addAttribute("doctors", doctors);
        return "procedures";
    }

    @RequestMapping("/manage/doctors")
    public String addDoctor(Model model) {
        List<DoctorDto> doctors = doctorService.getAll();
        model.addAttribute("doctors", doctors);
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
