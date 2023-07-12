package com.example.VaccineBooking.Service;

import com.example.VaccineBooking.DTO.requestDto.ReqAddPersonDto;
import com.example.VaccineBooking.DTO.responseDto.ResAddPersonDto;
import com.example.VaccineBooking.Model.Person;
import com.example.VaccineBooking.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;


    public ResAddPersonDto addPerson(ReqAddPersonDto personDto) {

        Person person = new Person();

        person.setAge(personDto.getAge());
        person.setName(personDto.getName());
        person.setEmail(personDto.getEmail());
        person.setGender(personDto.getGender());
        person.setDose1Taken(false);
        person.setDose2Taken(false);
        person.setCertificate(null);

        personRepository.save(person);

        ResAddPersonDto resAddPersonDto = new ResAddPersonDto(person.getName() + " your profile has been created!");

        return resAddPersonDto;

    }
}
