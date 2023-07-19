package com.example.VaccineBooking.DTO.requestDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReqAppointDto {
    int personId;
    int doctorId;
}
