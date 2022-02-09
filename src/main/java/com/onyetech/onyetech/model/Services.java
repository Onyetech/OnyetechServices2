package com.onyetech.onyetech.model;

import com.onyetech.onyetech.enums.serviceType;
import com.sun.istack.NotNull;
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
public class Services {

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
