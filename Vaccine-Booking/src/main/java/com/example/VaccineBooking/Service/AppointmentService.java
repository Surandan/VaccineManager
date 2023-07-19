package com.example.VaccineBooking.Service;

import com.example.VaccineBooking.DTO.requestDto.ReqAppointDto;
import com.example.VaccineBooking.DTO.responseDto.AddCenterDto;
import com.example.VaccineBooking.DTO.responseDto.ResAppDto;
import com.example.VaccineBooking.Exeptions.DoctorNotFound;
import com.example.VaccineBooking.Exeptions.PersonNotFoundExp;
import com.example.VaccineBooking.Model.Appointment;
import com.example.VaccineBooking.Model.Doctor;
import com.example.VaccineBooking.Model.Person;
import com.example.VaccineBooking.Model.VaccinationCenter;
import com.example.VaccineBooking.Repository.AppointmentRepo;
import com.example.VaccineBooking.Repository.DoctorRepository;
import com.example.VaccineBooking.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AppointmentService {
    @Autowired
    AppointmentRepo appointmentRepo;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    JavaMailSender javaMailSender;

    public ResAppDto bookAnAppointment(ReqAppointDto reqAppointDto) {

        Optional<Person> optionalPerson = personRepository.findById(reqAppointDto.getPersonId());
        if(!optionalPerson.isPresent()) throw new PersonNotFoundExp("Invalid !");
        Optional<Doctor> optionalDoctor = doctorRepository.findById(reqAppointDto.getDoctorId());
        if (optionalDoctor.isEmpty()) throw new DoctorNotFound("Invalid doctorId!");

        Person person = optionalPerson.get();
        Doctor doctor = optionalDoctor.get();

        Appointment appointment = new Appointment();
        appointment.setAppointmentId(String.valueOf(UUID.randomUUID()));
        appointment.setPerson(person);
        appointment.setDoctor(doctor);
        appointment.setCenterType(doctor.getVaccinationCenter().getCenterType());

        Appointment savedApp = appointmentRepo.save(appointment);
        doctor.getAppointments().add(savedApp);
        person.getAppointments().add(savedApp);

        Doctor savedDoctor = doctorRepository.save(doctor);
        Person savedPerson = personRepository.save(person);

        VaccinationCenter center = doctor.getVaccinationCenter();
        AddCenterDto addCenterDto = new AddCenterDto();
        addCenterDto.setCenterType(center.getCenterType());
        addCenterDto.setName(center.getCenterName());
        addCenterDto.setAddress(center.getAddress());

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        String text ="Congrats!! "+savedPerson.getName()+" Your appointment has been booked with Doctor "+
                savedDoctor.getName() + ". Your vaccination center name is: " + center.getCenterName() + " Please reach at this address "+
                center.getAddress() + " at this time: " + savedApp.getAppointmentDate()+" Dhanyawad!!!";
        simpleMailMessage.setSubject("Congrats! Appointment has been fixed.");
        simpleMailMessage.setText(text);
        simpleMailMessage.setFrom("vaccinebookingsystem@gmail.com");
        simpleMailMessage.setTo(savedPerson.getEmail());

        javaMailSender.send(simpleMailMessage);

        ResAppDto resAppDto = new ResAppDto(savedApp.getPerson().getName(),savedApp.getDoctor().getName(),savedApp.getAppointmentId(), addCenterDto);
        return resAppDto;
    }
}
