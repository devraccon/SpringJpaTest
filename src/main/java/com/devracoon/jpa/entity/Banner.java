package com.devracoon.jpa.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@RequiredArgsConstructor
public class Banner {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "banner_id", columnDefinition = "VARCHAR(255)")
    private String bannerId;

    @ManyToOne( targetEntity = Contents.class , fetch = FetchType.LAZY)
    private Contents content;
}
