package com.procedures.web;

import com.procedures.model.DoctorModel;
import com.procedures.model.PatientModel;
import com.procedures.model.RoomModel;
import com.procedures.service.DoctorService;
import com.procedures.service.PatientService;
import com.procedures.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class WebController {

    private final DoctorService doctorService;

    private final PatientService patientService;

    private final RoomService roomService;

    @Autowired
    public WebController(DoctorService doctorService, PatientService patientService, RoomService roomService) {
        this.doctorService = doctorService;
        this.patientService = patientService;
        this.roomService = roomService;
    }

    @RequestMapping("add/procedure")
    public String procedures(Model model) {
        List<DoctorModel> doctors = doctorService.getAll();
        List<PatientModel> patients = patientService.getAll();
        List<RoomModel> rooms = roomService.getAll();
        model.addAttribute("doctors", doctors);
        model.addAttribute("patients", patients);
        model.addAttribute("rooms", rooms);
        return "addProcedures";
    }

    @RequestMapping(value = "/add/doctor", method = RequestMethod.POST)
    public String addDoctor(@RequestBody DoctorModel doctor, Model model) {
        doctorService.addDoctor(doctor);
        List<DoctorModel> doctors = doctorService.getAll();
        model.addAttribute("doctors", doctors);
        return "procedures";
    }
}
