package telran.items;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import telran.persons.dto.*;
import telran.view.InputOutput;

public class GetPerson  extends PersonAbstractItem {

	@Override
	public String displayName() {
		return "Get person";
	}

	@Override
	public void action(InputOutput inOut) {
		Integer id = inOut.getInteger("Enter ID");
		
		HttpEntity<Integer> requestEntity = new HttpEntity<>(headers);
		ResponseEntity<Person> person = 
				restTemplate.exchange(url + PersonsApiConstants.GET_PERSON + "?" + "id=" + id,
				HttpMethod.GET, requestEntity, Person.class);
		
		if (person.getBody()==null) {
			inOut.displayLine("Data not available in the database");
		}else {
			inputOutput.displayLine(person.getBody());
		}
	}

	
}
