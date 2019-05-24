import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("Longest Common Subsequence");
		System.out.println("--------------------------");		
		
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the first string");
			String firstString = scanner.next();
			System.out.println("Enter the second string");
			String secondString = scanner.next();
			System.out.println("The longest common subsequence is "+findLongestCommonSubsequence(firstString, secondString));
			
		}catch(Exception exception) {
			System.out.println("Thrown exception is "+exception.getMessage());
		}
		
	}
	
	private static int findLongestCommonSubsequence(String firstString, String secondString) {
		int[][] longestCommonSubsequence = new int[firstString.length()+1][secondString.length()+1];
		
		for(int firstStringIndex = 0; firstStringIndex <= firstString.length(); firstStringIndex++) {
			for(int secondStringIndex = 0; secondStringIndex <= secondString.length(); secondStringIndex++) {
				if(firstStringIndex == 0 || secondStringIndex == 0) {
					longestCommonSubsequence[firstStringIndex][secondStringIndex] = 0;
				}
				else if(firstString.charAt(firstStringIndex-1) == secondString.charAt(secondStringIndex-1)){
					longestCommonSubsequence[firstStringIndex][secondStringIndex] = 1 + longestCommonSubsequence[firstStringIndex-1][secondStringIndex-1];
				}else {
					longestCommonSubsequence[firstStringIndex][secondStringIndex] = Math.max(longestCommonSubsequence[firstStringIndex-1][secondStringIndex],
							longestCommonSubsequence[firstStringIndex][secondStringIndex-1]);
				}
			}
		}
		return longestCommonSubsequence[firstString.length()][secondString.length()];
	}
}
