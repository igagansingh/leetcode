class Q268 {
    public int missingNumber(int[] nums) {
        // O(n) Time Complextiy
        // O(1) Space Complexity
        //
        // Idea: 
        // XOR of the number with itself is 0
        // We iterate through array and at each iteration XOR the (index+1) value and the current element
        // In the end only the number which was missing will be there
        
        int xor=0;
        for(int i=0; i<nums.length; i++) {
            xor=xor^nums[i]^(i+1);
        }
        return xor;
        
        // O(n) Time Complextiy
        // O(1) Space Complexity
        //
        // Idea:
        // We know sum of first 'n' numbers is n(n+1)/2, expected sum
        // We take the sum of all the elements in the array, actual sum
        // Subtract the actual sum from expected sum, remaining value would be the missing number
        //
        // Drawback: 
        // Could result in overflow
        //
        // int n=nums.length;
        // int expected= (n*(n+1)) / 2;
        // int actual=0;
        // for(int nu: nums) actual+=nu;
        // return expected-actual;
    }
}