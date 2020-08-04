class Day3 {

    /**
    * Idea:
    *   Make a new string add only,
    *   numbers [0-9]
    *   characters[a-zA-Z]
    *   Traverse from front and back, keep comparing the characters until the middle point
    *   if a single mismatch it isnt palindrome else it is.
    *
    */
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        
        for(char c: s.toCharArray()) {
            if(c-'0'>=0 && c-'0'<=9)  sb.append(c);
            if(c-'A'>=0 && c-'A'<=25) sb.append((char)((int)c+32));
            if(c-'a'>=0 && c-'a'<=25) sb.append(c);
        }
        
        String str=sb.toString();
        int i=0, j=str.length()-1;
        while(i<=j){
            if(!(str.charAt(i++)==str.charAt(j--))) return false;
        }
        return true;
    }
}