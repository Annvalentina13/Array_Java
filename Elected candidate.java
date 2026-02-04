/*
Given an array of names arr[] of candidates in an election. A candidate name in array represents a vote casted to the candidate. You need to find the candidate with maximum votes recieved in the election.

Examples:

Input: arr[] = ["Shrikant", "Sushma", "Rajnath", "Sushma"]
Output: Sushma
Explanation: Here Sushma has 2 votes and Rajnath has 1 vote.
Input: arr[] = ["Atal", "Shashtri", "Atal"]
Output: Atal
Explanation: Here Atal has max votes of 2.
Constraints:
1 <= arr.size() <= 104

*/

import java.util.Arrays;

class Solution {
    public static String electionWinner(String arr[]) {
        Arrays.sort(arr);

        String winner = arr[0];
        int maxVotes = 1;

        int currVotes = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i].equals(arr[i - 1])) {
                currVotes++;
            } else {
                if (currVotes > maxVotes) {
                    maxVotes = currVotes;
                    winner = arr[i - 1];
                }
                currVotes = 1;
            }
        }

        // Check for the last candidate
        if (currVotes > maxVotes) {
            winner = arr[arr.length - 1];
        }

        return winner;
    }
}
