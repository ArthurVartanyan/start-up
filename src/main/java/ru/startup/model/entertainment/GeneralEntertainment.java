package ru.startup.model.entertainment;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "general_entertainment", schema = "public")
@Inheritance(strategy = InheritanceType.JOINED)
public class GeneralEntertainment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "shift_name")
    private String shiftName;

    @Column(name = "start_at")
    private LocalDateTime startAt;

    @Column(name = "end_at")
    private LocalDateTime endAt;

    @Column(name = "entertainment_type")
    @Enumerated(EnumType.STRING)
    private EntertainmentType entertainmentType;

    @Column(name = "price")
    private String price;

    @Column(name = "deleted")
    @ColumnDefault("false")
    private Boolean deleted;

    @Column(name = "name")
    private String name;
}
