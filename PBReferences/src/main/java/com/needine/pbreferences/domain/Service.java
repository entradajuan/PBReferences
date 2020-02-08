package com.needine.pbreferences.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
public class Service {

	@Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    private final String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "reference_id", referencedColumnName = "id", nullable = false)
    private Reference reference;

    @OneToMany(mappedBy="service", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BankAccount> bankAccounts = new ArrayList<>();
   
    
    // Empty constructor for JSON/JPA
    public Service() {
        this("");
    }
    
}
