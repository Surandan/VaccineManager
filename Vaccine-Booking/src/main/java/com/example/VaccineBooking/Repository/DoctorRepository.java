package com.example.VaccineBooking.Repository;

import com.example.VaccineBooking.Model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {

    @Query(value = "select name from doctor where age > :age",nativeQuery = true)
    List<String>  getByAgeGreaterThan(int age);

    @Query(value = "select name from doctor where vaccination_center_id=:centerId",nativeQuery = true)
    List<String>  getByCenter(int centerId);
}
