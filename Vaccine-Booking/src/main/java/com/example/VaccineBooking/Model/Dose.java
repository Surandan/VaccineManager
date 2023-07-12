package com.example.VaccineBooking.Model;

import com.example.VaccineBooking.Enum.DoseType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Dose {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String doseId;

    @Enumerated(value = EnumType.STRING)
    DoseType doseType;
    @CreationTimestamp
    Date vaccinationDate;

    @ManyToOne     // many : current class(Dose here) One : Person
    @JoinColumn    // introduces foreign key in dose i.e. primary key in person
    Person person;
}
