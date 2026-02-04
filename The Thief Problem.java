/*
You are given an integer array arr[] of items. The elements of arr represent value of items. You are also given an integer k. Now, a thief wants to commit a burglary but he can only pick k items from the given items. Help him so that he gets the maximum total value out of this theft.

Example 1:

Input: arr[] = [3, 7, 2, 5, 12, 30], k = 3
Output: 49
Explanation: The thief should pick the bolded items:
3 7 2 5 12 30. So, the sum of these is 49.
Input:  arr[] = [8, 10, 2, 50, 80, 20], k = 4
Output: 160
Explanation: The thief should pick the bolded items:
8 10 2 50 80 20. So, the sum of these is 160.
Constraints:
1 ≤ arr.length, K ≤ 105
1 ≤ arr[i] ≤ 1000

*/

import java.util.Arrays;

class Solution {
    public static int getMaxVal(int arr[], int k) {
        Arrays.sort(arr);

        int sum = 0;

        for (int i = arr.length - 1; i >= arr.length - k; i--) {
            sum += arr[i];
        }

        return sum;
    }
}
