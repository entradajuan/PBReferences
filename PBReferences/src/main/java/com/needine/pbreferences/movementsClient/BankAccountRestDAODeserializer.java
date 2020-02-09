package com.needine.pbreferences.movementsClient;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.needine.pbreferences.movementsClient.movementsRestDAO.BankAccountRestDAO;



/**
 * Deserializes an BankAccount from get call 

 */
public class BankAccountRestDAODeserializer extends JsonDeserializer<BankAccountRestDAO>{

	@Override
	public BankAccountRestDAO deserialize(JsonParser jsonParser, DeserializationContext arg1)
			throws IOException, JsonProcessingException {

		ObjectCodec oc = jsonParser.getCodec();
        JsonNode node = oc.readTree(jsonParser);
        return new BankAccountRestDAO(node.get("id").asText(),
                node.get("activated").asInt());
	}

}
