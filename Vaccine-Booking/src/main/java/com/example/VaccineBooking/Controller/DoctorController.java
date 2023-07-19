package com.example.VaccineBooking.Controller;

import com.example.VaccineBooking.DTO.requestDto.ReqAddDoctorDto;
import com.example.VaccineBooking.DTO.responseDto.ResAddDoctorDto;
import com.example.VaccineBooking.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/doctor")
@RestController
public class DoctorController {
    @Autowired
    DoctorService doctorService;

    @PostMapping("/add")
    public ResponseEntity addDoctor(@RequestBody ReqAddDoctorDto reqAddDoctorDto) {
        try{
            ResAddDoctorDto resAddDoctorDto = doctorService.addDoctor(reqAddDoctorDto);
            return  new ResponseEntity<>(resAddDoctorDto,HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
    @GetMapping("/get_by_age_greater_than")
    public List<String> getByAgeGreaterThan(@RequestParam("age") int age){
        List<String> doctors = doctorService.getByAgeGreaterThan(age);
        return doctors;
    }

    @GetMapping("/get_by_center")
    public List<String> getByCenter(@RequestParam("centerId") int centerId){
        List<String> doctors = doctorService.getByCenter(centerId);
        return doctors;
    }
}
