class Solution {
    public boolean isPalindrome(int x) {
        int rev = 0;
        int num =x;
        boolean a=false;
        if(x==0)return a=true;
        if(num>0){
            while(num>0){
                int last = num%10;
                rev = (rev*10)+last;
                num/=10;

            }
          if(rev==x)return a=true;
        }
        return a;
    }
}