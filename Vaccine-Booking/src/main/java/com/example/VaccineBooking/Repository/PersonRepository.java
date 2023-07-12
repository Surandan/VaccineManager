package com.example.VaccineBooking.Repository;

import com.example.VaccineBooking.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Integer> {

}
