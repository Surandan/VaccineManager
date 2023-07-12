package com.example.VaccineBooking.Repository;

import com.example.VaccineBooking.Model.Dose;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoseRepository extends JpaRepository<Dose,Integer> {

}
