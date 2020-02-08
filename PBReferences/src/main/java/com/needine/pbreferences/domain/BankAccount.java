package com.needine.pbreferences.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;


//@RequiredArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
public class BankAccount {

	@Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

	private final String name;
	
    @ManyToOne(/*cascade = CascadeType.PERSIST */fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private Service service;

    public BankAccount() {
    	this("");
    }
    
    public BankAccount(String name) {
    	this.name = "";
    }

	public BankAccount(Long id, String name, Service service) {
		this.id = id;
		this.name = name;
		this.service = service;
	}
	public BankAccount(String name, Service service) {
		this.name = name;
		this.service = service;
	}
    
    
    
    
    
}
