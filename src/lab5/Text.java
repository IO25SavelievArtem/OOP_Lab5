package lab5;
 
import java.util.ArrayList;

/**
 * This class describe data about object Text.
 * 
 * @version		1.0 06 Jun 2023
 * @author		Artem Saveliev
 */
public class Text {
	
    /**
	 * Arraylist of objects of class Sentence that contains sentences of the text.
	 */
	private ArrayList<Sentence> sentences;
	
	/**
	 * @param a
	 *			this variable is divided in Sentence objects and then assigned in field "sentences".
	 */
	public Text(StringBuilder a){
		sentences = new ArrayList<Sentence>();
		Character ch;	//Ініціалізація змінної, у яку будуть записуватись значення символів тексту
		int lastEnd = 0;	//Місце останнього кінця речення
		sentences.add(new Sentence(new StringBuilder(a.substring(0))));
		for (int i = 0; i < a.length()-1; i++){
			ch = a.charAt(i);
			if (new Punctuation(ch).isSentenceEnd()){
				sentences.set(sentences.size()-1, new Sentence(new StringBuilder(this.getSentenceString(sentences.size()-1)).delete(i+1-lastEnd, a.length())));	//Скорочення минулої строки до цього символу
				sentences.add(new Sentence(new StringBuilder(a.substring(i+1))));	//Додавання залишку тексту у массив
				lastEnd = i;
			}
		}
	}
	
	/**
	 * @return concatenated values of Sentence objects from field "sentences".
	 */
	public String getTextString(){
		String text = new String("");
		for (int i = 0; i < this.getSentencesNum(); i++){
			text = text + this.getSentenceString(i);
		}
		return text;
	}
	
	/**
	 * @return value of field "sentences".
	 */
	public ArrayList<Sentence> getSentences(){
		return sentences;
	}
	
	/**
	 * @return number of objects in field "sentences".
	 */
	public int getSentencesNum(){
		return sentences.size();
	}
	
	/**
	 * @param num
	 *			number of Sentence object in arraylist "sentences".
	 * @return Sentence object from field "sentences".
	 */
	public String getSentenceString(int num){
		return sentences.get(num).getSentenceString();
	}
	
	/**
	 * @param num
	 *			number of Sentence object in arraylist "sentences".
	 * @param newSentence
	 *			is assigned to num object of array "sentences".
	 */
	public void setSentence(int num, StringBuilder newSentence){
		this.sentences.set(num, new Sentence(newSentence));
	}
	
	/**
	 * @param num
	 *			number of Sentence object in arraylist "sentences".
	 * @param newSentence
	 *			is assigned to num object of array "sentences".
	 */
	public void setSentence(int num, Sentence newSentence){
		this.sentences.set(num, newSentence);
	}
}