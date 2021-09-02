package com.devracoon.jpa.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@RequiredArgsConstructor
public class Contents {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "content_id", columnDefinition = "VARCHAR(255)")
    private String contentId;

    @Column(name = "display_position_code", columnDefinition = "VARCHAR(255)")
    private String displayPositonCode;

    @Column(name = "start_display_time", columnDefinition = "VARCHAR(255)")
    private String startDisplayTime;
}
