package flippy;

import java.util.Arrays;

public class WarmUp {
	
	/**
	 * Counts how many cards are hearts
	 * 
	 * @param cards an array of cards
	 * @return the number of cards that are hearts
	 */
	public static int countHearts(Card[] cards ){
		int count = 0;
		for(Card card : cards){
			if(card.getSuit().equals("hearts")){
				count++;
			}
		}
		return count;
	}
	
	/**
	 * Add the elements of two arrays of the same length.  The function assumes that 
	 * the arrays are of the same length
	 * 
	 * @param array1
	 * @param array2
	 * @return a new array that is the element-wise sum of the input arrays 
	 */
	public static double[] addArraysSameLength(double[] array1, double[] array2){
		double[] sumOf1and2 = new double[array1.length];
		for (int i =0; i<array1.length; i++){
			for(double item1:array1){
				for(double item2:array2){
					sumOf1and2[i] = item1+item2;
				}
			}
		}
		return sumOf1and2;
	}
	
		
	// TODO: write the reverseArray method, including method header and JavaDoc comments
	/**
	 * reverse the order of items in an given array of Strings
	 * 
	 * @param array1
	 * @return no return, mutate the input array instead
	 */

	 public static void reverseArray(String[] array){
		int lengthArray = array.length;
		for(int i = 0; i < lengthArray / 2; i++){
			String original = array[i];
			array[i] = array[lengthArray - 1 - i];
			array[lengthArray - 1 - i] = original;
		}
	 }
	public static void main(String[] args){
		String[] words = {"I", "love", "my", "CS", "classes", "!"};
		
		System.out.println("Before: " + Arrays.toString(words));
		reverseArray(words);
		System.out.println("After: " + Arrays.toString(words));
	}
}
