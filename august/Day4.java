public class Day4 {
    public boolean isPowerOfFour(int num) {

        /**
        * Idea is to check 3 conditions:
        * 1. Number is greater than 0 (corner case)
        * 2. num & num-1, if num is power of 2 then this value will be 0
        * 3. mask indicates the set bits for various powers of 4
        *    num&mask will NOT be zero if it is a power of 4
        */
        int mask=1431655765; //1010101010101010101010101010101
        return (num>0 && ( (num & (num-1))==0 && ( (num&mask) !=0)));
        
        // Solution2
        // if(num==0) return false;
        // while(num!=1) if(num%4==0)num=num>>2; else return false;
        // return true;
        
        
        // Solution 3
        // if(num==1) return true;
        // if(num<4) return false;        
        // while(num!=1) {
        //     if(num%4==0) num=num/4;
        //     else return false;
        // }
        // return true;
    }
}