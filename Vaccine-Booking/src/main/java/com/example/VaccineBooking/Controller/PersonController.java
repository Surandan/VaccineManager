package com.example.VaccineBooking.Controller;

import com.example.VaccineBooking.DTO.requestDto.ReqAddPersonDto;
import com.example.VaccineBooking.DTO.responseDto.ResAddPersonDto;
import com.example.VaccineBooking.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    PersonService personService;

    @PostMapping("/addPerson")
    public ResponseEntity addPerson(@RequestBody ReqAddPersonDto personDto) {
        try{
            ResAddPersonDto response = personService.addPerson(personDto);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return  new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/update-email")
    public ResponseEntity updateEmail(@RequestParam("oldEmail") String oldEmail,@RequestParam("newEmail") String newEmail) {
          try {
              String response = personService.updateEmail(oldEmail,newEmail);
              return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
          }
          catch (Exception e) {
              return  new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
          }
    }
}
