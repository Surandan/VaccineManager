package com.example.VaccineBooking.Service;

import com.example.VaccineBooking.DTO.requestDto.ReqGetDoseDto;
import com.example.VaccineBooking.Enum.DoseType;
import com.example.VaccineBooking.Exeptions.DoseAlreadyTaken;
import com.example.VaccineBooking.Exeptions.PersonNotFoundExp;
import com.example.VaccineBooking.Model.Dose;
import com.example.VaccineBooking.Model.Person;
import com.example.VaccineBooking.Repository.DoseRepository;
import com.example.VaccineBooking.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DoseService {
    @Autowired
    DoseRepository doseRepository;

    @Autowired
    PersonRepository personRepository;

    public Dose getDose1(ReqGetDoseDto reqGetDoseDto) {

        Optional<Person> optionalPerson = personRepository.findById(reqGetDoseDto.getPersonId());
        if(optionalPerson.isEmpty()) throw new PersonNotFoundExp("Person Not Found");

        Person person = optionalPerson.get();
        if (person.isDose1Taken()) throw new DoseAlreadyTaken("Dose 1 already taken !");

        Dose dose = new Dose();

        dose.setDoseId(String.valueOf(UUID.randomUUID()));
        dose.setDoseType(reqGetDoseDto.getDoseType());
        dose.setPerson(person);

        person.setDose1Taken(true);
        person.getDoses().add(dose);

        Person savedPerson = personRepository.save(person); // if manyToOne written in person class for dose no need of this
        return savedPerson.getDoses().get(0);
    }
}

