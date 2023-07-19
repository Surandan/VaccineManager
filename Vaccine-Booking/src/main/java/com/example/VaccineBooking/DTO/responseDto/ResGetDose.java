package com.example.VaccineBooking.DTO.responseDto;

import com.example.VaccineBooking.Enum.DoseType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ResGetDose {

    String doseId;
    DoseType doseType;
    Date vaccinationDate;
    String personName;
}
