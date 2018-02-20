/**
 * Counting Occurrences using Merge Sort
 * CountOccurrences.java
 * Purpose: Counts the number of occurrences of an integer in a given array
 * 
 * @author Neil Gorham
 * @version 1.0.0 02/19/2018
 */

public class CountOccurrences{
	//Private variables
	private int[] arrA;
	//Public Methods
	//Main Constructor
	public CountOccurrences(){}

	public CountOccurrences(int[] arrA){
		this.arrA = arrA;
	}

	//Main process
	public static void main(String[] args){
		int[] arrA = {1,0,3,6,2,1,0,4};
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
	//Counts number of occurrences
	//Pre-condition: arrA is sorted in ascending order
	private void numOfOccurrences(int[] arrA){

	}
	//Print array value of length n
	private void printArray(int arrA[]){
		for(int i = 0; i < arrA.length; i++){
			System.out.print(arrA[i] + " ");
		}
		System.out.println();
	}
}
