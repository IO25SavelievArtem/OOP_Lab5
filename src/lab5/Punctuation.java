package lab5;

/**
 * This class describe data about object Punctuation.
 * 
 * @version		1.0 06 Jun 2023
 * @author		Artem Saveliev
 */
public class Punctuation {
	/**
	 * Field "p" which houses the meaning of the symbol.
	 */
	private char p;
	
	/**
	 * @param a
	 * 			this variable is assigned to the field "p".
	 */
	public Punctuation(char a){
		p = a;
	}
	
	/**
	 * @return value of fields "p".
	 */
	public char getPunctuation(){
		return this.p;
	}
	
	/**
	 * @return value of fields "p".
	 */
	public String getPunctuationString(){
		return Character.toString(this.p);
	}
	
	/**
	 * @param p
	 * 			is assigned to the field "p".
	 */
	public void setPunctuation(char p){
		this.p = p;
	}
	
	/**
	 * @return whether symbol is sentence's end.
	 */
	public boolean isSentenceEnd(){
		return (p == '.' || p == '!' || p == '?');
	}
}