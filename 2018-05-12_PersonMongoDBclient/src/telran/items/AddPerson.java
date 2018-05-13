package telran.items;

import java.time.LocalDate;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;

import telran.persons.dto.Person;
import telran.persons.dto.PersonsApiConstants;
import telran.view.InputOutput;

public class AddPerson extends PersonAbstractItem {

	@Override
	public String displayName() {
		return "Add new person";
	}

	@Override
	public void action(InputOutput inOut) {
		Person person = getPerson(inOut);
		HttpEntity<Person> requestEntity = new HttpEntity<Person>(person, headers);
		Boolean flag = restTemplate.exchange(url+PersonsApiConstants.ADD_PERSON, HttpMethod.POST, requestEntity, Boolean.class).getBody();
		if (flag) {
			inOut.displayLine("Person successfully added");
		}else {
			inOut.displayLine("Person hasn't been added");
		}
	}

	private Person getPerson(InputOutput inOut) {
		Integer id = inOut.getInteger("Enter ID");
		String name = inOut.getString("Enter name");
		LocalDate birthdate = inOut.getDate("Enter birthdate");
		return new Person(id, name, birthdate);
	}



}
