/**
 * Counting Occurrences using Merge Sort
 * countOccurrences.js
 * Purpose: Counts the number of occurrences of integers in a given array
 * 
 * @author Neil Gorham
 * @version 1.0.0 02/19/2018
 */

//Count Occurrences Constructor
//arrA: array of nonnegative integer values
function CountOccurrences(arrA){
	//Private variables
	var counts = []; //array of key value pairs
	var arrayA = arrA; //mergeSort array
	//Private Methods
	//Main process
	run = function(){
		console.log("Before Sort: " + arrayA);
		print("input");
		mergeSort(arrayA);
		console.log("After Sort: " + arrayA);
		print("output");
		numOfOccurrences(arrayA);
		console.log(counts);
		printCounts();
        print3();
	}
	//Merge Sort utility
	mergeSort = function(arrA){
		//Merge Sort recursive
		if(typeof arrA === 'undefined' || arrA.length <= 0) return;
		if(arrA.length == 1) return;
		//middle index of array
		var mid = Math.floor(arrA.length / 2); //convert to integer
		var left = new Array(mid); //left subarray
		var right = new Array(arrA.length - mid); //right subarray
		//populate left and right with array elements
		for(var i = 0; i < mid; i++){
			left[i] = arrA[i];
		}
		for(var i = mid; i < arrA.length; i++){
			right[i - mid] = arrA[i];
		}
		mergeSort(left);
		mergeSort(right);
		//Merge left and right subarrays
		var i = 0, j = 0, k = 0;
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
	numOfOccurrences = function(arrA){
		if(typeof arrA === 'undefined' || arrA.length <= 0) return;
		var count;
		if(arrA.length == 1){
			count = {key: arrA[0], value: 1};
			counts.push(count); 
		}
		var max = arrA[0], cur = 0, cc = 0;
		for(var i = 0; i < arrA.length; i++){
			cur = arrA[i];
			if(cur == max){ cc++; }
			if(cur > max){
				count = {key: max, value: cc};
				counts.push(count);
				max = cur;
				cc = 1;
			}
			if(cur == arrA[arrA.length - 1]){
				count = {key: max, value: cc};
				counts.push(count);
			}
		}
	}
	//Prints array of values
	print = function(timeOfSort){
		document.getElementById(timeOfSort).innerHTML = arrayA;
	}
	//Prints the counts array to HTML
	printCounts = function(){
		var text = "";
		for(var i = 0; i < counts.length; i++){
			text += counts[i].key + " appears " + counts[i].value + " time(s)<br >";
		}
		document.getElementById("counts").innerHTML = text;
	}
    //Prints the first count of value of 3
    print3 = function(){
        var text = "";
        for(var i = 0; i < counts.length; i++){
            if(counts[i].value == 3){
                text += counts[i].key + " appears " + counts[i].value + " time(s)<br >"
            }
        }
        if(text == ""){
            text = "none";
        }
        document.getElementById("count3").innerHTML = text;
    }
	//Main Process called
	run();
	return {
		//Public Methods
	};
}
