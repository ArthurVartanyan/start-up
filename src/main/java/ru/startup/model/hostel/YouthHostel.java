package ru.startup.model.hostel;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "youth_hostel", schema = "public")
public class YouthHostel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 40)
    private String name;

    @Lob
    @Column(name = "about", nullable = false)
    private String about;

    @Column(name = "phone", nullable = false, length = 12)
    private String phone;

    @Column(name = "email", nullable = false, length = 30)
    private String email;

    @Lob
    @Column(name = "price", nullable = false)
    private String price;

    @Column(name = "deleted", nullable = false)
    private Boolean deleted = false;
}