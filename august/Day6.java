class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> answer = new ArrayList<>();

        /** Idea:
        * Time Complexity: O(n)
        * Space Complexity: O(n)
        * Have an extra array and store the count of element
        *
        */
        int counter[] = new int[nums.length+1];
        for(int i=0; i<nums.length; i++) {
            counter[nums[i]]++;
            if(counter[nums[i]]>1) answer.add(nums[i]);
        }
        
        /** Idea:
        * Time Complexity: O(n)
        * Space Complexity: O(1)
        * For every number invert the (number-1) position element to its negative value.
        * When we encounter a number whose value is negative, we add (index+1) to the list.
        *
        */
        // for(int i=0; i<nums.length; i++) {
            // int index=Math.abs(nums[i]);
            // if(nums[index-1]<0) answer.add(index);
            // else nums[index-1]=-nums[index-1];
        // }
        return answer;
    }
}