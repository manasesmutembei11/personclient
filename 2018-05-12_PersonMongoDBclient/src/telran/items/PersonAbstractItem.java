package telran.items;

import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import telran.view.InputOutput;
import telran.view.Item;

public abstract class PersonAbstractItem implements Item {
	protected RestTemplate restTemplate = new RestTemplate();
	static public String url;
	protected HttpHeaders headers = new HttpHeaders();
	protected InputOutput inputOutput;


}
