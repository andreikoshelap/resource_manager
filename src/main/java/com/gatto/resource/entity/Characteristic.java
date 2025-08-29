package com.gatto.resource.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Characteristic {
    @Id @GeneratedValue
    private Long id;

    @Column(length = 5)
    private String code;

    @Enumerated(EnumType.STRING)
    private CharacteristicType type;

    private String value;

    @ManyToOne
    private Resource resource;
}
