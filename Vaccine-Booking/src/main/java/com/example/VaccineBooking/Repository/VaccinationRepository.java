package com.example.VaccineBooking.Repository;

import com.example.VaccineBooking.Model.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccinationRepository extends JpaRepository<VaccinationCenter,Integer> {
}
