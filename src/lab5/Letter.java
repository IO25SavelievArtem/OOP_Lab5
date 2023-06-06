package lab5;

/**
 * This class describe data about object Letter.
 * 
 * @version		1.0 06 Jun 2023
 * @author		Artem Saveliev
 */
public class Letter {
	/**
	 * Field "letter" which houses the meaning of the letter.
	 */
	private char letter;
	
	/**
	 * @param a
	 * 			this variable is assigned to the field "letter".
	 */
	public Letter(char a){
		this.letter = a;
	}
	
	/**
	 * @return value of fields "letter".
	 */
	public char getLetter(){
		return this.letter;
	}
	
	/**
	 * @return value of fields "letter" as string.
	 */
	public String getLetterAsString(){
		return Character.toString(this.letter);
	}
	
	/**
	 * @param letter
	 * 			is assigned to the field "letter".
	 */
	public void setLetter(char letter){
		this.letter = letter;
	}
}