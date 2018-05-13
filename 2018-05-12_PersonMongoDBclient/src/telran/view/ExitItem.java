package telran.view;

public class ExitItem implements Item {


	@Override
	public String displayName() {
		return "Exit";
	}

	@Override
	public void action(InputOutput inOut) {
		inOut.displayLine("The program is completed");
	}
	
	@Override
	public boolean isExit() {
		return true;
	}

}
