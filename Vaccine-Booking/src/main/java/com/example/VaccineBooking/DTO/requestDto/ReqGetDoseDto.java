package com.example.VaccineBooking.DTO.requestDto;

import com.example.VaccineBooking.Enum.DoseType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReqGetDoseDto {
    int personId;
    DoseType doseType;
}
