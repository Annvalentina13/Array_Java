/*
Given an array arr[] that contains positive and negative integers (may contain 0 as well). Find the maximum product that we can get in a subarray of arr[].

Note: It is guaranteed that the answer fits in a 32-bit integer.

Examples

Input: arr[] = [-2, 6, -3, -10, 0, 2]
Output: 180
Explanation: The subarray with maximum product is [6, -3, -10] with product = 6 * (-3) * (-10) = 180.
Input: arr[] = [-1, -3, -10, 0, 6]
Output: 30
Explanation: The subarray with maximum product is [-3, -10] with product = (-3) * (-10) = 30.
Input: arr[] = [2, 3, 4] 
Output: 24 
Explanation: For an array with all positive elements, the result is product of all elements. 
Constraints:
1 ≤ arr.size() ≤ 106
-10  ≤  arr[i]  ≤  10

*/

class Solution {
    public int maxProduct(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;

        int maxEndingHere = arr[0];
        int minEndingHere = arr[0];
        int result = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];

            // If current element is negative, swap
            if (current < 0) {
                int temp = maxEndingHere;
                maxEndingHere = minEndingHere;
                minEndingHere = temp;
            }

            maxEndingHere = Math.max(current, maxEndingHere * current);
            minEndingHere = Math.min(current, minEndingHere * current);

            result = Math.max(result, maxEndingHere);
        }

        return result;
    }
}
