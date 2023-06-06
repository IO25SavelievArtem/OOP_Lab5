package lab5;

/**
 * This class describe data about object Word.
 * 
 * @version		1.0 06 Jun 2023
 * @author		Artem Saveliev
 */
public class Word {

	/**
	 * An array of objects of class Letter, of which the word.
	 */
	private Letter[] letters;
	
	/**
	 * @param a
	 * 			this variable is divided into letters and then assigned to the field "letters".
	 */
	public Word(String a){
		this.letters = new Letter[a.length()];
		for (int i = 0; i < a.length(); i++) {
			this.letters[i] = new Letter(a.charAt(i));
		}
	}
	
	/**
	 * @return string representation of word.
	 */
	public String getWordString(){
		String word = new String("");
		for (int i = 0; i < this.letters.length; i++) {
			word = word + this.letters[i].getLetterAsString();
		}
		return word;
	}
	
	/**
	 * @param word
	 * 			this variable is divided into letters and then assigned to the field "letters".
	 */
	public void setWord(String word){
		this.letters = new Letter[word.length()];
		for (int i = 0; i < word.length(); i++) {
			letters[i] = new Letter(word.charAt(i));
		}
		
	}
	
	/**
	 * @param letters
	 * 			this array is assigned to the field "letters".
	 */
	public void setWord(Letter[] letters){
		this.letters = letters;
	}
	
	/**
	 * @return field "letters".
	 */
	public Letter[] getLetters(){
		return this.letters;
	}
	
	/**
	 * @param num
	 * 			num of letter that is assigned.
	 * @param letter
	 * 			Letter object that is assigned.
	 */
	public void setLetter(int num, Letter letter){
		this.letters[num] = letter;
	}
}