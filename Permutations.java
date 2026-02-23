/*
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]
 

Constraints:

1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.

*/

import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        
        backtrack(nums, result, new ArrayList<>(), used);
        return result;
    }
    
    private void backtrack(int[] nums, List<List<Integer>> result, 
                           List<Integer> current, boolean[] used) {
        
        // Base case
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;  // skip used elements
            
            // Choose
            used[i] = true;
            current.add(nums[i]);
            
            // Explore
            backtrack(nums, result, current, used);
            
            // Backtrack
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}
