package com.needine.pbreferences.movementsClient;

import java.util.List;

import com.needine.pbreferences.movementsClient.movementsRestDAO.BankAccountRestDAO;

public interface MovementsClient {
	
	String getHost();
	//List<Object[]> getAllAccounts();
	BankAccountRestDAO getOneAccount(String AccountId);
	
}
