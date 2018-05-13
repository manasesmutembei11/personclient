package telran.controller;

import telran.items.*;
import telran.view.ConsoleInputOutput;

public class PersonClientAppl {

	public static void main(String[] args) {
		PersonAbstractItem.url =// args.length==0?"http://localhost:8080/":args[0];
				"https://personserveranngara.herokuapp.com/";
		(new Start_Menu ())
		.action(new ConsoleInputOutput());
	}

	

	
}
