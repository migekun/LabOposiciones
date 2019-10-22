package es.navas.oposiciones.autoevaluacion;

public class Codility {
	/**
	Your team is analysing a flight of a plane. Your task is to find the longest period of turbulence.
	The height of the plane above the ground is measured once every second of the flight. 
	The measurement on K-th second is recorded as an integer A[K].
	Security regulations decree that a period of time is considered to be turbulence 
	if changes in measured heights alternate: for example, if the plane went up, then down, then up and so on.
	More precisely, period (P, Q) is considered to be a turbulence if:
	A[P] > A[P+1] < A[P+2] > ..., and so on, up to A[Q], or
	A[P] < A[P+1] > A[P+2] < ..., and so on, up to A[Q].
	
	Note that, for this definition, if P = Q then the period is also considered to be turbulence.
	Write a function:
	
		class Solution { public int solution(int[] A); }

	that, given an array A consisting of N integers representing height measurements during the flight, 
	returns the size of the longest period of turbulence in A.
	Examples:
	1. Given array A = [9, 4, 2, 10, 7, 8, 8, 1, 9] the function should return 5, because period (1, 5) is considered
	to be turbulence (A[1] > A[2] < A[3] > A[4] < A[5]). 
	Note that period (1, 6) is not turbulence, because A[5] = A[6].
		
	2. Given array A = [4, 8, 12, 16] the function should return 2. 
	Any two consecutive elements of A form a turbulence period.
	3. Given array A = [100] the function should return 1.
	4. Given N = 100,000 and A = [50, 150, 50, 150, ..., 50, 150] ([50, 150] repeating 50,000 times) 
	the function should return 100,000, as the whole array A is a turbulence period.
	Write an efficient algorithm for the following assumptions:
	N is an integer within the range [1..100,000];
	each element of array A is an integer within the range [1..1,000,000,000].
	
	 public int solution(int[] A) {
        // write your code in Java SE 8
    }
    
    https://www.geeksforgeeks.org/array-data-structure/
    
	*/
	
	public int solution(int[] A) throws IllegalArgumentException {
		 
		if (A.length < 1 || A.length > 100000) {
            throw new IllegalArgumentException("Array fuera de ranto: [1..100000]");
        }

        for (int i = 0; i < A.length-1; i++) {
            if (A[i] < 1 || A[i]> 1000000000)
                throw new IllegalArgumentException("Valor contenido en el array fuera de ranto: [1..1000000000]");
        }

        Boolean greater = false;
        Boolean lower = false;
        int initIndex = 0;
        int endIndex = 1;
        int rango = endIndex - initIndex;
        for (int i = 0; i < A.length-1; i++) {

            if (A[i] < A[i+1]) {//es at1 menor que at2
                System.out.println("A[i] < A[i+1]: " + A[i] +  " < " + A[i+1]);
                if (lower || !greater) {
                    initIndex = i;
                }
                lower = true;
                greater = false;
                endIndex++;
            } else if(A[i] > A[i+1]) {
                System.out.println("A[i] > A[i+1]: " + A[i] +  " > " + A[i+1]);
                if (greater || !lower) {
                    initIndex = i;
                }
                greater = true;
                lower = false;
                endIndex++;
            } else {
                greater = false;
                lower = false;
                initIndex = i;
            }

            if (rango < endIndex - initIndex) rango = (endIndex - initIndex);
            System.out.println("rango: " + rango + " initIndex: " + initIndex + " endIndex: " + endIndex);
        }
        System.out.println("Rango: " + rango);
        return rango;
	}
	
	/******************************************************/
	/**
	 * 
	Integer V lies strictly between integers U and W if U < V < W or if U > V > W.
	A non-empty array A consisting of N integers is given. A pair of indices (P, Q), where 0 ≤ P < Q < N, is
	said to have adjacent values if no value in the array lies strictly between values A[P] and A[Q].
	For example, in array A such that:
	  A[0] = 0
	  A[1] = 3
	  A[2] = 3
	  A[3] = 7
	  A[4] = 5
	  A[5] = 3
	  A[6] = 11
	  A[7] = 1
	the following pairs of indices have adjacent values:
	  (0, 7),   (1, 2),   (1, 4),
	  (1, 5),   (1, 7),   (2, 4),
	  (2, 5),   (2, 7),   (3, 4),
	  (3, 6),   (4, 5),   (5, 7).
	For example, indices 4 and 5 have adjacent values because there is no value in array A that lies strictly 
	between A[4] = 5 and A[5] = 3; the only such value could be the number 4, and it is not present in the array.
	Given two indices P and Q, their distance is defined as abs(A[P] − A[Q]), where abs(X) = X for X ≥ 0, 
	and abs(X) = −X for X < 0. For example, the distance between indices 4 and 5 is 2 because (A[4] − A[5]) = (5 − 3) = 2.
	Write a function:
	
		class Solution { public int solution(int[] A); }
		
	that, given a non-empty array A consisting of N integers, returns the minimum distance between indices of this 
	array that have adjacent values. The function should return −1 if the minimum distance is greater than 100,000,000. 
	The function should return −2 if no adjacent indices exist.
	For example, given array A such that:
	  A[0] =  0
	  A[1] =  3
	  A[2] =  3
	  A[3] =  7
	  A[4] =  5
	  A[5] =  3
	  A[6] = 11
	  A[7] =  1
	the function should return 0 because:
	indices 1 and 2 are adjacent, because the array does not contain any value that lies strictly 
	between A[1] = 3 and A[2] = 3;
	the distance between these indices is (A[1] − A[2]) = (3 − 3) = 0;
	no other pair of adjacent indices that has smaller distance exists.
	
	Write an efficient algorithm for the following assumptions:
	N is an integer within the range [1..40,000];
	each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
	

	 */
	
	
}
