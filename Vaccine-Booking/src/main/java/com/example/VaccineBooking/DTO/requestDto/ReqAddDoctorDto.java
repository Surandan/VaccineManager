package com.example.VaccineBooking.DTO.requestDto;

import com.example.VaccineBooking.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReqAddDoctorDto {
    String name;
    int age;
    Gender gender;
    String email;
    int centerId;
}
