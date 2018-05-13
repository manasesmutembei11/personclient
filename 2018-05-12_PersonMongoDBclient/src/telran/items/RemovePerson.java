package telran.items;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;

import telran.persons.dto.PersonsApiConstants;
import telran.view.InputOutput;

public class RemovePerson  extends PersonAbstractItem {

	@Override
	public String displayName() {
		return "Remove person";
	}

	@Override
	public void action(InputOutput inOut) {
	Integer id = inOut.getInteger("Enter ID");
	
	HttpEntity <Integer> requestEntity = new HttpEntity<>(id, headers);
		Boolean flag = restTemplate.exchange(url+PersonsApiConstants.REMOVE_PERSON, HttpMethod.POST, requestEntity, Boolean.class).getBody();
		
		if (flag) {
			inOut.displayLine("Person successfully removed");
		}else {
			inOut.displayLine("Person hasn't been removed");
		}
	}

}
