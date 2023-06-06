package lab5;

/**
 * This class is used to remove specified substring from the StringBuilder text.
 * 
 * @version		1.0 06 Jun 2023
 * @author		Artem Saveliev
 * @see lab5.Text
 * 		lab5.Sentence
 * 		lab5.Word
 * 		lab5.Letter
 * 		lab5.Punctuation
 */
public class Lab5 {
	
	public static void removeOfSubstring(StringBuilder text, Letter start, Letter end) {
		Text origText = new Text(text);
		Text redactedText = new Text(new StringBuilder(origText.getTextString()));
		boolean isRedacted = false;	//У випадку якщо текст не відповідає умовам, вивести повідомлення про відсутність змін
		int indexStart = -1;	//Місце першого появлення першої заданої літери
		int indexEnd = -1;	//Місце останнього появлення другої заданої літери
		for (int i = 0; i < redactedText.getSentencesNum(); i++){
			indexStart = new StringBuilder(redactedText.getSentenceString(i)).indexOf(start.getLetterAsString());	//Пошук першого появлення першої заданої літери
			indexEnd = new StringBuilder(redactedText.getSentenceString(i)).lastIndexOf(end.getLetterAsString());	//Пошук останнього появлення другої заданої літери
			if (indexStart < indexEnd && indexStart != -1){
				redactedText.setSentence(i, new StringBuilder(redactedText.getSentenceString(i)).delete(indexStart, indexEnd+1));	//Видалення відповідної підстроки
				isRedacted = true;
			}
		}
		if (isRedacted){
			System.out.println("\nПочатковий текст:\n\""+origText.getTextString()+"\"");
			System.out.println("\nШукані літери: \'"+start.getLetter()+"\', \'"+end.getLetter()+"\'");
			System.out.println("\nВідредагований текст:\n\""+redactedText.getTextString()+"\"");
		} else {
			System.out.println("\nТекст не відповідає умовам; текст залишен без змін:\n\""+origText.getTextString()+"\"");
		}
	}
	
	public static void main(){
		StringBuilder text = new StringBuilder("В залежності від C17 визначити дію з рядком.\n Мій варіант: "
												+"З кожного речення заданого тексту видалити підрядок найбільшої довжини,"
												+" що починається та закінчується заданими літерами.");
		Letter s = new Letter('д');
		Letter e = new Letter('і');
		removeOfSubstring(text, s, e);
	}
}