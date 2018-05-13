package telran.view;

public interface Item  {
	
	String displayName ();
	
	void action (InputOutput inOut);
	
	default boolean isExit () {
		return false;
	}
}
