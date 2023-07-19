package com.example.VaccineBooking.DTO.responseDto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.mail.javamail.JavaMailSender;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ResAppDto {

    String personName;
    String doctorName;
    String AppointmentId;


    AddCenterDto addCenterDto;
}
