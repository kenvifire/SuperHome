package hello;

import java.util.Arrays;
import java.util.Collections;

public class CoinChange322 {
    int res = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        Integer[] ncoins = Arrays.stream(coins).boxed().toArray(Integer[]::new);
        Arrays.sort(ncoins, Collections.reverseOrder());
        dfsChange(ncoins,0,0,amount);
        return res == Integer.MAX_VALUE ? -1 : res;


    }
    public void dfsChange(Integer[] coins, int c_index,int count,int amount) {
        int n = coins.length;
        if(amount == 0){
            res = Math.min(count,res);
            return;
        }
        if(c_index >= n) return ;
        for(int k = amount/coins[c_index] ; k >= 0 && k+count < res; k--){
            dfsChange(coins,c_index+1,count+k,amount-coins[c_index]*k);
        }

    }

}
//DP
//public class CoinChange322 {
//    public int coinChange(int[] coins, int amount) {
//        int n = coins.length;
//        int[] dp = new int[amount+1];
//        Arrays.fill(dp,amount+1);
//        dp[0] = 0;
//        for(int i = 1; i <= amount; i++){
//            for(int j = 0; j < n;j++){
//                if(i >= coins[j]) {
//                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
//                }
//            }
//        }
////        System.out.println(Arrays.toString(dp));
//        return dp[amount] > amount ? -1 : dp[amount];
//    }
//
//}
