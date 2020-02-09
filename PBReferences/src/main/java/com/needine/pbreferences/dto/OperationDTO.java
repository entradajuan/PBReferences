package com.needine.pbreferences.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.needine.pbreferences.domain.Reference;

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
public class OperationDTO implements Serializable{

	private LocalDateTime created;
	private Double amount;
	private String originAccount;
	private String destinyAccount;
	private String finished;
	
	
}
