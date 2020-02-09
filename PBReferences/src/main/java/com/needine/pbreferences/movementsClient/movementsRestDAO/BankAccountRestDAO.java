package com.needine.pbreferences.movementsClient.movementsRestDAO;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.needine.pbreferences.movementsClient.BankAccountRestDAODeserializer;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@JsonDeserialize(using = BankAccountRestDAODeserializer.class)
public class BankAccountRestDAO {
	
	private static final long serialVersionUID = 1L;

	private final String id;
	private final Integer activated;
	
	

}
