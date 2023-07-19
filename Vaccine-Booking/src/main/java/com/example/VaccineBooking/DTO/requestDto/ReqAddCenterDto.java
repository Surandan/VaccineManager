package com.example.VaccineBooking.DTO.requestDto;

import com.example.VaccineBooking.Enum.CenterType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReqAddCenterDto {
    String name;
    CenterType type;
    String address;
}
