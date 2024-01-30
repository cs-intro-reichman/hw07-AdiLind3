
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
		if (word1.charAt(0) == word2.charAt(0))  //if the chars are not the same so we need to substitution, so we add 1.
		{
			cost = 0;
		} else {
			cost = 1;
		}
		int deleteCost = levenshtein(tail(word1), word2) + 1; //add 1 to count if we need to delete one char
		int insertCost = levenshtein(word1, tail(word2)) + 1; // add 1 to count if we need to add char
		int substituteCost = levenshtein(tail(word1), tail(word2)) + cost; // add 1 if we need to subtituting 
	
		return Math.min(Math.min(deleteCost, insertCost), substituteCost); // return the minimum of those
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
		String bestresult = dictionary[0]; //if we find word in dictionary that fulfill the condition wewill return this string
		int tempdis = levenshtein(word, bestresult);
		for(int k=1; k< dictionary.length; k++) //start from 1 because we did the step of '0' before the loop
		{
			if(tempdis >= levenshtein(word, dictionary[k])) //if we find a new word that have smaller dis than we have before
			{
				tempdis = levenshtein(word, dictionary[k]); //save the new MinDis value
				bestresult = dictionary[k]; //save the word that apply that
			}
			
		}

		if ( tempdis > threshold) //that means that we dont find a word that fulfill the condition than return the original
		{
			return word;
		}
		return bestresult;
	}

}
