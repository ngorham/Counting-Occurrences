/**
 * Counting Occurrences using Counting Sort
 * countOccurrences2.js
 * Purpose: Counts the number of occurrences of an integer in a given array
 * 
 * @author Neil Gorham
 * @version 1.0.0 02/19/2018
 */

//Count Occurrences Constructor
//arrA: array of nonnegative integer values
function CountOccurrences2(arrA, arrB, k){
	//Private variables
	var arrayA = arrA;
	var arrayB = arrB; //output array
	var arrayC = []; //working storage
	var counts = []; //array of key value pairs
	var highVal = k; //greatest value in arrA
	//Private Methods
	//Main process
	run = function(){
		console.log("Before Sort: " + arrayA);
		printInput();
		countingSort(arrayA, arrayB, highVal);
		console.log("After Sort: " + arrayB);
		printOutput();
		console.log(counts);
		printCounts();
	}

	//Counting Sort utility
	countingSort = function(arrA, arrB, k){
		var count;
		for(var i = 0; i <= k; i++){ arrayC[i] = 0; }
		for(var j = 0; j < arrA.length; j++){ arrayC[arrA[j]] = arrayC[arrA[j]] + 1; }
		for(i = 0; i < arrayC.length; i++){
			count = {key: i, value: arrayC[i]};
			counts.push(count);
		}
		for(i = 1; i <= k; i++) {arrayC[i] = arrayC[i] + arrayC[i - 1]; }
		for(j = 0; j < arrA.length; j++){
			arrB[arrayC[arrA[j]] - 1] = arrA[j];
			arrayC[arrA[j]] = arrayC[arrA[j]] - 1;
		}
	}
	//Prints input array of values
	printInput = function(){
		document.getElementById("input").innerHTML = arrayA;
	}
	//Prints output array of values
	printOutput = function(){
		document.getElementById("output").innerHTML = arrayB;
	}
	//Prints the counts array to HTML
	printCounts = function(){
		var text = "";
		for(var i = 0; i < counts.length; i++){
			text += counts[i].key + " appears " + counts[i].value + " time(s)<br >";
		}
		document.getElementById("counts").innerHTML = text;
	}	
	//Main process called
	run();
	return {
		//Public Methods
	};
}
