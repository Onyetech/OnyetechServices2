package com.onyetech.onyetech.entity;

import com.onyetech.onyetech.enums.serviceType;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table
public class MyServices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotNull
    private String serviceName;

    @NotNull
    private String image;

    @NotNull
    private String description;

    @NotNull
    private Long price;

    @NotNull
    private Timestamp dateCreated;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = ServicesCart.class)
    private ServicesCart servicesCart;

    @Enumerated(EnumType.STRING)
    private serviceType serviceType;
}
