package telran.items;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;

import telran.persons.dto.Person;
import telran.persons.dto.PersonsApiConstants;
import telran.view.InputOutput;

public class UpdateName  extends PersonAbstractItem{

	@Override
	public String displayName() {
		return "Update name";
	}

	@Override
	public void action(InputOutput inOut) {
		Integer id = inOut.getInteger("Enter ID");
		String name = inOut.getString("Enter new name");
		HttpEntity <Person> requestEntity = new HttpEntity<>(new Person (id, name, null), headers);
		Boolean flag = restTemplate.exchange(url+PersonsApiConstants.UPDATE_NAME, HttpMethod.POST, requestEntity, Boolean.class).getBody();
		if (flag) {
			inOut.displayLine("Person's name changed successfully");
		}else {
			inOut.displayLine("The name of the person hasn't been changed");
		}
	}

}
