package telran.items;

import telran.view.*;

public class Start_Menu extends Menu {

	public Start_Menu() {
		this.add(new AddPerson()) 
			.add(new RemovePerson())
			.add(new GetPerson ())
			.add(new UpdateName ())
			.add(new ExitItem());
	}

	@Override
	public String displayName() {
		return "____________MENU____________";
	}
	
	

}
