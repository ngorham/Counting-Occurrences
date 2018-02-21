/**
 * Counting Occurrences using Merge Sort
 * CountOccurrences.java
 * Purpose: Counts the number of occurrences of an integer in a given array
 * 
 * @author Neil Gorham
 * @version 1.0.0 02/19/2018
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;

public class CountOccurrences{
	//Private variables
	private int[] arrA;
	private HashMap<Integer, Integer> counts;
	//Public Methods
	//Main Constructor
	public CountOccurrences(){}

	public CountOccurrences(int[] arrA){
		this.arrA = arrA;
		this.counts = new HashMap<>();
	}

	//Main process
	public static void main(String[] args){
		int[] arrA = {8,9,7,6,8,1,1,3,2,8,4,5,0,10};
		CountOccurrences co = new CountOccurrences(arrA);
		co.run();
	}
	//Private Methods
	private void run(){
		System.out.println("Count Occurrences using Merge Sort");
		System.out.println("Before Sort: ");
		printArray(arrA);
		mergeSort(arrA);
		System.out.println("After Sort: ");
		printArray(arrA);
		System.out.println("Number of Occurrences: ");
		numOfOccurrences(arrA, counts);
		printCounts(counts);
	}
	//Merge Sort utility
	private void mergeSort(int[] arrA){
		if(arrA == null || arrA.length <= 0){ return; }
		if(arrA.length == 1){ return; }
		int mid = arrA.length / 2;
		int[] left = new int[mid]; //left subarray
		int[] right = new int[arrA.length - mid]; //right subarray
		//populate left and right with array elements
		for(int i = 0; i < mid; i++){
			left[i] = arrA[i];
		}
		for(int i = mid; i < arrA.length; i++){
			right[i - mid] = arrA[i];
		}
		mergeSort(left);
		mergeSort(right);
		//Merge left and right subarrays
		int i = 0, j = 0, k = 0;
		while(i < left.length && j < right.length){
			if(left[i] < right[j]){
				arrA[k] = left[i];
				i++;
			} else {
				arrA[k] = right[j];
				j++;
			}
			k++;
		}
		//Copy remaining elements
		while(i < left.length){
			arrA[k] = left[i];
			i++;
			k++;
		}
		while(j < right.length){
			arrA[k] = right[j];
			j++;
			k++;
		}				
	}
	//Counts and stores number of occurrences
	//Pre-condition: arrA is sorted in ascending order
	private void numOfOccurrences(int[] arrA, HashMap<Integer, Integer> counts){
		for(int i = 0; i < arrA.length; i++){
			Integer key = new Integer(arrA[i]);
			Integer value;
			if(counts.containsKey(key)){
				//increment count
				int count = counts.get(key).intValue() + 1;
				value = new Integer(count);
			} else {
				//add key-value to counts
				value = new Integer(1);
			}
			counts.put(key, value);
			//System.out.println("key: " + key.intValue() + " value: " + counts.get(key).intValue());

		}
	}
	//Print array value of length n
	private void printArray(int arrA[]){
		for(int i = 0; i < arrA.length; i++){
			System.out.print(arrA[i] + " ");
		}
		System.out.println();
	}
	//Print counts
	private void printCounts(HashMap<Integer, Integer> counts){
		Set c = counts.entrySet();
		Iterator i = c.iterator();
		while(i.hasNext()){
			Map.Entry me = (Map.Entry)i.next();
			System.out.println(me.getKey() + " appears " + me.getValue() + " time(s)");
		}
	}
}
