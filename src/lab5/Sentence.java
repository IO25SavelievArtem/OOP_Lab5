package lab5;

import java.util.ArrayList;

/**
 * This class is used to describe data about object Sentence.
 * 
 * @version		1.0 06 Jun 2023
 * @author		Artem Saveliev
 */
public class Sentence {
	/**
	 * Arraylist of objects of class Word that contains words of the sentence.
	 */
	private ArrayList<Word> words;
	
	/**
	 * Arraylist of objects of class Punctuation that contains punctuation of the sentence.
	 */
	private ArrayList<Punctuation> puncts;
	
	/**
	 * Arraylist that contains order of words and punctuation in sentence.
	 */
	private ArrayList<Integer> order;
	
	/**
	 * @param a
	 *			this variable is divided into Word and Punctuation objects and then assigned to the fields "words", "puncts".
	 */
	public Sentence(StringBuilder a){
		order = new ArrayList<Integer>();
		words = new ArrayList<Word>();
		puncts = new ArrayList<Punctuation>();
		int lastProcessed = -1;
		Character ch;
		for (int i = 0; i < a.length(); i++){
			if (i > lastProcessed-1){
				ch = a.charAt(i);
				if (Character.isLetterOrDigit(ch)){
					for (int j = i; j < a.length(); j++) {
						if (Character.isLetterOrDigit(a.charAt(j))) {
							lastProcessed = j+1;
						} else {
							break;
						}
					}
					words.add(new Word(a.substring(i, lastProcessed)));
					order.add(0);
				} else {
					puncts.add(new Punctuation(ch));
					order.add(1);
				}
			}
		}
	}
	
	/**
	 * @return concatenation that forms sentence.
	 */
	public String getSentenceString(){
		String sentence = new String("");
		int wordNum = 0;
		int punctNum = 0;
		for (int i = 0; i < this.order.size(); i++){
			if (order.get(i) == 1){
				sentence = sentence + this.getPunctString(punctNum);
				punctNum += 1;
			} else {
				sentence = sentence + this.getWordString(wordNum);
				wordNum += 1;
			}
		}
		return sentence;
	}
	
	/**
	 * @return field "words".
	 */
	public ArrayList<Word> getWords(){
		return new ArrayList<Word>(this.words);
	}
	
	/**
	 * @param num
	 * 			number of the word in "words" field.
	 * @return word
	 * 			Word object's string representation.
	 */
	public String getWordString(int num){
		return this.words.get(num).getWordString();
	}
	
	/**
	 * @param num
	 * 			number in "words" field of the word that is assigned.
	 * @param word
	 * 			Word object that is assigned.
	 */
	public void setWord(int num, Word word){
		this.words.set(num, word);
	}
	
	/**
	 * @return field "p".
	 */
	public ArrayList<Punctuation> getPuncts(){
		return new ArrayList<Punctuation>(this.puncts);
	}
	
	/**
	 * @param num
	 * 			number in "punct" field of the punctuation symbol that is assigned.
	 * @return word
	 * 			Punctuation object's string representation.
	 */
	public String getPunctString(int num){
		return this.puncts.get(num).getPunctuationString();
	}
	
	/**
	 * @param num
	 * 			number in "punct" field of the punctuation symbol that is assigned.
	 * @param punct
	 * 			Punctuation object that is assigned.
	 */
	public void setPunct(int num, Punctuation punct){
		this.puncts.set(num, punct);
	}
}