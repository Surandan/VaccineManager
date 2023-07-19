package com.example.VaccineBooking.Controller;

import com.example.VaccineBooking.DTO.requestDto.ReqAppointDto;
import com.example.VaccineBooking.DTO.responseDto.ResAppDto;
import com.example.VaccineBooking.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/appointment")
@RestController
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;

    @PostMapping("/book")
    public ResponseEntity bookAnAppointment(@RequestBody ReqAppointDto reqAppointDto) {
        try {
            ResAppDto resAppDto = appointmentService.bookAnAppointment(reqAppointDto);
            return new ResponseEntity<>(resAppDto, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return  new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }
}
