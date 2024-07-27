/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
public class Main
{
	public static int countMin(String str)
	{
		// code here
		int n = str.length();
		int matrix[][] = new int[n][n];

		//Strings of length 1 are palindrome
		for(int i=0; i<n; i++) {
			matrix[i][i] = 1;
		}

		// Build the table
		for (int cl = 2; cl <= n; cl++) {
			for (int i = 0; i < n - cl + 1; i++) {
				int j = i + cl - 1;
				if (str.charAt(i) == str.charAt(j) && cl == 2) {
					matrix[i][j] = 2;
				} else if (str.charAt(i) == str.charAt(j)) {
					matrix[i][j] = matrix[i + 1][j - 1] + 2;
				} else {
					matrix[i][j] = Math.max(matrix[i][j - 1], matrix[i + 1][j]);
				}
			}
		}

		int lcs = matrix[0][n-1];
		return n-lcs;

	}
	
}