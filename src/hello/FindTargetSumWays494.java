package hello;

public class FindTargetSumWays494 {
    int count = 0;
    public int findTargetSumWays(int[] nums, int S) {
        int n = nums.length;
        if(n==0) return 0;
        dfsfindTarget(nums,0,0,S);
        System.out.println(count);
        return count;


    }
    public void dfsfindTarget(int[] nums, int c_index,int sum,int S){
        int n = nums.length;
        if(c_index == n){
            if(sum == S){
                count++;
            }
        }else{
            dfsfindTarget(nums,c_index+1,sum+nums[c_index],S);
            dfsfindTarget(nums,c_index+1,sum-nums[c_index],S);
        }
    }
}
