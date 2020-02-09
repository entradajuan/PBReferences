package com.needine.pbreferences.movementsClient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.needine.pbreferences.movementsClient.movementsRestDAO.BankAccountRestDAO;
import com.needine.pbreferences.service.ServiceServiceImpl;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class MovementsClientImpl implements MovementsClient{

    private final RestTemplate restTemplate;
    private final String movementsHost;

    @Autowired
    public MovementsClientImpl(final RestTemplate restTemplate,
                                                 @Value("${movementsHost}") final String movementsHost) {
        this.restTemplate = restTemplate;
        this.movementsHost = movementsHost;
    }

    public String getHost() {
    	return this.movementsHost;
    }

/*	@Override
	public List<Object[]> getAllAccounts() {
		 return restTemplate.getForObject(
				 movementsHost + "/getAll", MultiplicationResultAttempt.class);
	}
*/
	@Override
	public BankAccountRestDAO getOneAccount(String AccountId) {
		BankAccountRestDAO response = null;
		try {
			response = restTemplate.getForObject(
					 movementsHost + "/account/getOne/" + AccountId, BankAccountRestDAO.class);
		    log.info("response: {}", response.toString());			
		} catch (final HttpClientErrorException e) {
			log.error(e.getStatusCode().toString());
		    log.error(e.getResponseBodyAsString());
		}
		return response;
	}

    /*
    @HystrixCommand(fallbackMethod = "defaultResult")
    @Override
    public MultiplicationResultAttempt retrieveMultiplicationResultAttemptbyId(final Long multiplicationResultAttemptId) {
        return restTemplate.getForObject(
                multiplicationHost + "/results/" + multiplicationResultAttemptId,
                MultiplicationResultAttempt.class);
    }

    private MultiplicationResultAttempt defaultResult(final Long multiplicationResultAttemptId) {
        return new MultiplicationResultAttempt("fakeAlias",
                10, 10, 100, true);
    }*/
    
}
