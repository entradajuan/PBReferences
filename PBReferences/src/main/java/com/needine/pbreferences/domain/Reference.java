package com.needine.pbreferences.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
public class Reference {
	
	@Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    
    private final String name;
    private final String country;
    
    

    // Empty constructor for JSON/JPA
    public Reference() {
        this("", "");
    }


}
