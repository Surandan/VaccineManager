package com.example.VaccineBooking.Service;

import com.example.VaccineBooking.DTO.requestDto.ReqAddDoctorDto;
import com.example.VaccineBooking.DTO.responseDto.AddCenterDto;
import com.example.VaccineBooking.DTO.responseDto.ResAddDoctorDto;
import com.example.VaccineBooking.Exeptions.CenterNotFoundExeption;
import com.example.VaccineBooking.Model.Doctor;
import com.example.VaccineBooking.Model.VaccinationCenter;
import com.example.VaccineBooking.Repository.DoctorRepository;
import com.example.VaccineBooking.Repository.VaccinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    VaccinationRepository vaccinationRepository;

    public ResAddDoctorDto addDoctor(ReqAddDoctorDto reqAddDoctorDto) throws Exception {

        Optional<VaccinationCenter> optionalVaccinationCenter = vaccinationRepository.findById(reqAddDoctorDto.getCenterId());
        if(optionalVaccinationCenter.isEmpty()) throw new CenterNotFoundExeption("Invalid centerId");

        VaccinationCenter vaccinationCenter = optionalVaccinationCenter.get();

        Doctor doctor = new Doctor();

        doctor.setAge(reqAddDoctorDto.getAge());
        doctor.setName(reqAddDoctorDto.getName());
        doctor.setGender(reqAddDoctorDto.getGender());
        doctor.setEmail(reqAddDoctorDto.getEmail());
        doctor.setVaccinationCenter(vaccinationCenter);

        vaccinationCenter.getDoctors().add(doctor);
        VaccinationCenter savedCenter = vaccinationRepository.save(vaccinationCenter);

        AddCenterDto addCenterDto = new AddCenterDto();
        addCenterDto.setName(vaccinationCenter.getCenterName());
        addCenterDto.setAddress(vaccinationCenter.getAddress());
        addCenterDto.setCenterType(vaccinationCenter.getCenterType());

        ResAddDoctorDto resAddDoctorDto = new ResAddDoctorDto();
        resAddDoctorDto.setAge(doctor.getAge());
        resAddDoctorDto.setName(doctor.getName());
        resAddDoctorDto.setAddCenterDto(addCenterDto);

        return resAddDoctorDto;
    }

    public List<String> getByAgeGreaterThan(int age) {
        List<String> doctors = new ArrayList<>();
        doctors.addAll(doctorRepository.getByAgeGreaterThan(age));
        return doctors;
    }

    public List<String> getByCenter(int centerId) {
        return doctorRepository.getByCenter(centerId);
    }
}
