package uebung_5_5.errors;

public class ChoiceNotInFieldException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ChoiceNotInFieldException() {
		super("Die ausgewaehlte Spalte existiert nicht.");
	}

}
