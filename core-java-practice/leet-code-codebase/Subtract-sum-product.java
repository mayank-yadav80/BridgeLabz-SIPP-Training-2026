class Solution {
    public int subtractProductAndSum(int n) {
        int pro=1;
        int sum=0;
        int x=n;
        while(x>0){
            int digit=x%10;
            pro*=digit;
            sum+=digit;
            x/=10;
        }
        
            return pro-sum;
    }
}