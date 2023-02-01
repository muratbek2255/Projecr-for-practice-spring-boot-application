package com.example.scooter_kg.entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "scooter", schema = "scooter_kg")
public class Scooter extends RepresentationModel<Scooter> {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private Integer price;

    private Integer battery;

    private String image;

    private Integer quantity;

    private String address;
    private String qr_code;
}
