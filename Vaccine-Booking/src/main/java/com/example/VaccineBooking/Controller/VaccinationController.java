package com.example.VaccineBooking.Controller;

import com.example.VaccineBooking.DTO.requestDto.ReqAddCenterDto;
import com.example.VaccineBooking.DTO.responseDto.AddCenterDto;
import com.example.VaccineBooking.Service.VaccinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/center")
@RestController
public class VaccinationController {
    @Autowired
    VaccinationService vaccinationService;
    @PostMapping("/addVaccinationCenter")
    public ResponseEntity addVaccinationCenter(@RequestBody ReqAddCenterDto reqAddCenterDto) {
        AddCenterDto addCenterDto = vaccinationService.addVaccinationCenter(reqAddCenterDto);
        return new ResponseEntity<>(addCenterDto, HttpStatus.CREATED);
    }
}
