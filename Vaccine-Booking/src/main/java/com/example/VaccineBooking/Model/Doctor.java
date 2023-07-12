package com.example.VaccineBooking.Model;

import com.example.VaccineBooking.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    int age;

    @Enumerated(EnumType.STRING)
    Gender gender;

    @Column(unique = true,nullable = false)
    String email;

    boolean isDose1Taken;

    boolean isDose2Taken;
}
