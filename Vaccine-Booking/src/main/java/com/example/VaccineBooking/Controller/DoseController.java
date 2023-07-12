package com.example.VaccineBooking.Controller;

import com.example.VaccineBooking.DTO.requestDto.ReqGetDoseDto;
import com.example.VaccineBooking.Model.Dose;
import com.example.VaccineBooking.Service.DoseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/dose")
@RestController
public class DoseController {
    @Autowired
    DoseService doseService;
   @PostMapping("/getDose1")
    public ResponseEntity getDose1(@RequestBody ReqGetDoseDto reqGetDoseDto){
        try{
            Dose dose = doseService.getDose1(reqGetDoseDto);
            return new ResponseEntity<>(dose, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
