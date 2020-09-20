package hello;

import java.util.Arrays;

public class findLengthOfLCIS674 {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        int[] dp = new int[n];
        for(int i = 0; i < n; i++){
            dp[i] = 1;
        }
        for(int i = 1; i < n; i++){
            if(nums[i] > nums[i-1]){
                dp[i] = dp[i-1] + 1;
            }else{
                dp[i] = 1;
            }
        }
        return Arrays.stream(dp).max().getAsInt();


    }
    public static void main(String[] args) {
        int[] nums = {1,3,5,4,2,3,4,5};
        findLengthOfLCIS674 find = new findLengthOfLCIS674();
        int res = find.findLengthOfLCIS(nums);
        System.out.println(res);

    }
}
