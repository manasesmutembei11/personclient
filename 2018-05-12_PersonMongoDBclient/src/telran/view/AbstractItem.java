package telran.view;

public abstract class AbstractItem implements Item {
	protected InputOutput inOut;
	
	public AbstractItem(InputOutput inOut) {
		this.inOut = inOut;
	}


}
