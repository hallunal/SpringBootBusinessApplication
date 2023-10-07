package com.turkcell.spring.entities.concretes;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private short employeeId;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "title")
    private String title;

    @Column(name = "title_of_courtesy")
    private String titleOfCourtesy;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "hire_date")
    private LocalDate hireDate;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "region")
    private String region;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "country")
    private String Country;

    @Column(name = "home_phone")
    private String homePhone;

    @Column(name = "extension")
    private String extension;

    @Column(name = "photo")
    private byte [] photo;

    /*@Column(name = "notes")
    private String notes;*/

    /*@Column(name = "reports_to")
    private short reports_to;*/

    @Column(name = "photo_path")
    private String photoPath;

    @OneToMany(mappedBy = "employee")
    private List<Order> orders;

    @OneToMany(mappedBy = "employee")
    private List<EmployeeTerritory> EmployeeTerritories;

}
