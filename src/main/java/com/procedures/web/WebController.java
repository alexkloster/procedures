package com.procedures.web;

import com.procedures.model.DoctorModel;
import com.procedures.model.PatientModel;
import com.procedures.model.RoomModel;
import com.procedures.model.StudyModel;
import com.procedures.service.DoctorService;
import com.procedures.service.PatientService;
import com.procedures.service.RoomService;
import com.procedures.service.StudyService;
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

    private final StudyService studyService;

    @Autowired
    public WebController(DoctorService doctorService, PatientService patientService, RoomService roomService, StudyService studyService) {
        this.doctorService = doctorService;
        this.patientService = patientService;
        this.roomService = roomService;
        this.studyService = studyService;
    }

    @RequestMapping("/save/procedure")
    public void saveProcedure(@RequestBody StudyModel study){
        studyService.saveStudy(study);
    }

    @GetMapping("/edit/{id}/procedure")
    @ResponseBody
    public StudyModel editProcedure(@PathVariable("id") Long id, Model model){
        return studyService.getById(id);
    }



    @RequestMapping("/add/procedure")
    public String addProcedure(Model model) {
        List<DoctorModel> doctors = doctorService.getAll();
        List<PatientModel> patients = patientService.getAll();
        List<RoomModel> rooms = roomService.getAll();
        model.addAttribute("doctors", doctors);
        model.addAttribute("patients", patients);
        model.addAttribute("rooms", rooms);
        return "addProcedures";
    }

    @RequestMapping("/procedures")
    public String procedures(Model model){
        List<StudyModel> studies = studyService.getAll();
        model.addAttribute("studies", studies);
        return "procedures";
    }
    @RequestMapping(value = "/add/doctor", method = RequestMethod.POST)
    public String addDoctor(@RequestBody DoctorModel doctor, Model model) {
        doctorService.addDoctor(doctor);
        return addProcedure(model);
    }

    @RequestMapping(value = "/add/patient", method = RequestMethod.POST)
    public String addPatient(@RequestBody PatientModel patient, Model model) {
        patientService.addPatient(patient);
        return addProcedure(model);
    }

    @RequestMapping(value = "/add/room", method = RequestMethod.POST)
    public String addRoom(@RequestBody RoomModel room, Model model) {
        roomService.addRoom(room);
        return addProcedure(model);
    }
}
