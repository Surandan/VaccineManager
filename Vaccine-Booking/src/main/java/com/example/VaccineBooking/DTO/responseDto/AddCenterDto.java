package com.example.VaccineBooking.DTO.responseDto;

import com.example.VaccineBooking.Enum.CenterType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddCenterDto {
    String name;
    String address;
    CenterType centerType;
}
