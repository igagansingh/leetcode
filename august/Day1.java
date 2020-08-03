class Day1 {
    public boolean detectCapitalUse(String word) {
        // O(|word|)    time  complexity
        // O(1)         space complexity
        if(word.length()<1) return true;
        int cnt=0;
        
        // Checking if first word is Capital or not
        boolean firstWord= (word.charAt(0))>=65 && (word.charAt(0))<=90;
        for(char c: word.toCharArray()) {
            int ch=c;
            if(ch>=65 && ch<=90) cnt+=1;
        }

        return cnt==0 /**lowercase*/ ? true : (firstWord&&cnt==1) /**only first word is Capital*/ || cnt==word.length()/**Every character is Capital*/;
    }
}