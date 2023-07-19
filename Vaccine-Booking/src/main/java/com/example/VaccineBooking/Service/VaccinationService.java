package com.example.VaccineBooking.Service;

import com.example.VaccineBooking.DTO.requestDto.ReqAddCenterDto;
import com.example.VaccineBooking.DTO.responseDto.AddCenterDto;
import com.example.VaccineBooking.Model.VaccinationCenter;
import com.example.VaccineBooking.Repository.VaccinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VaccinationService {

    @Autowired
    VaccinationRepository vaccinationRepository;
    public AddCenterDto addVaccinationCenter(ReqAddCenterDto reqAddCenterDto) {

        VaccinationCenter vaccinationCenter = new VaccinationCenter();
        vaccinationCenter.setCenterName(reqAddCenterDto.getName());
        vaccinationCenter.setCenterType(reqAddCenterDto.getType());
        vaccinationCenter.setAddress(reqAddCenterDto.getAddress());

        vaccinationRepository.save(vaccinationCenter);

        AddCenterDto addCenterDto = new AddCenterDto(vaccinationCenter.getCenterName(), vaccinationCenter.getAddress(), vaccinationCenter.getCenterType());
        return addCenterDto;
    }
}
