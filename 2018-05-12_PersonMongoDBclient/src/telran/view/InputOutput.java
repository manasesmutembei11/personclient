package telran.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.function.Function;

public interface InputOutput {

	String DATE_FORMAT = "dd MM yyyy";

	String getString(String prompt);

	void display(Object obj);

	default String getString(String prompt, List<String> options) {
		String response = null;
		String initialPrompt = prompt;
		prompt += options;
		do {
			response = getString(prompt);
			prompt = "Wrong input - see options" + initialPrompt;
		} while (!options.contains(response));
		return response;
	}

	default void displayLine(Object obj) {
		display(obj.toString() + "\n");
	}

	default Integer getInteger(String prompt) {
		return getInteger(prompt, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	default Integer getInteger(String prompt, int min, int max) {
		Integer respounse = null;
		String initialPrompt = prompt;
		do {
			try {
				respounse = Integer.parseInt(getString(prompt));
				if (respounse < min || max <= respounse) {
					respounse = null;
				}
			} catch (NumberFormatException e) {
				// no operation
			}
			prompt = "Wrong input - see options" + initialPrompt;
		} while (respounse == null);
		return respounse;
	}


	default Long getLong(String prompt) {
		return getAnything(prompt,Long::parseLong);
	}
	
	default Double getDouble(String prompt) {
		return getAnything(prompt, Double::parseDouble);
	}

	default LocalDate getDate(String prompt) {
		LocalDate respounse = null;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(DATE_FORMAT);
		String initialPrompt = prompt + "(" + DATE_FORMAT + ")?> ";
		do {
			try {
				respounse = LocalDate.parse(getString(initialPrompt), dtf);
			} catch (DateTimeParseException d) {
				respounse = null;
			}
			prompt = "Wrong input - see options" + initialPrompt;
		} while (respounse == null);

		return respounse;
	}

	default <T> T getAnything(String prompt, Function<String, T> parser) {
		T respounse = null;
		String initialPrompt = prompt;
		do {
			try {
				String line = getString(prompt);
				respounse = parser.apply(line);
			} catch (Exception e) {
				displayLine("Error:" + e.getMessage());
				respounse = null;
			}
			prompt = "Wrong input - see options" + initialPrompt;
		} while (respounse == null);

		return respounse;
	}

}
