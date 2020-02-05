package com.needine.pbreferences.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Entity
public class Service {

	@Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    private final String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "reference_id", referencedColumnName = "id", nullable = false)
    private Reference reference;

    // Empty constructor for JSON/JPA
    public Service() {
        this("");
    }
    
}
