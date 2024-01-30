
public class SpellChecker {


	public static void main(String[] args) {
		String word = args[0];
		int threshold = Integer.parseInt(args[1]);
		String[] dictionary = readDictionary("dictionary.txt");
		String correction = spellChecker(word, threshold, dictionary);
		System.out.println(correction);
	}

	public static String tail(String str) {
		// Your code goes here
		return str.substring(1);
	}

	public static int levenshtein(String word1, String word2) {
		// Your code goes here
		if(word1.length() == 0)
		{
			return word2.length();
		}
		if(word2.length() == 0)
		{
			return word1.length();
		}
		word1 = word1.toLowerCase();
		word2 = word2.toLowerCase();
		int cost;
		if (word1.charAt(0) == word2.charAt(0)) {
			cost = 0;
		} else {
			cost = 1;
		}
		int deleteCost = levenshtein(tail(word1), word2) + 1;
		int insertCost = levenshtein(word1, tail(word2)) + 1;
		int substituteCost = levenshtein(tail(word1), tail(word2)) + cost;
	
		return Math.min(Math.min(deleteCost, insertCost), substituteCost);
	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];

		In in = new In(fileName);

		// Your code here
		for( int i = 0 ; i < 3000 ; i++)
		{
			dictionary[i] = in.readLine();
		}


		return dictionary;
	}

	public static String spellChecker(String word, int threshold, String[] dictionary) {
		// Your code goes here

		return null;
	}

}
