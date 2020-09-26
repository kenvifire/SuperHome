package hello;

import java.util.Arrays;
import java.util.Collections;

public class NumSquares279 {
    int ans = Integer.MAX_VALUE;
    public int numSquares(int n) {
        int max_square_index = (int) Math.sqrt(n) + 1;
        int[] squr = new int[max_square_index];
        for(int i = 0; i < max_square_index; i++){
            squr[i] = (i+1)*(i+1);
        }
        Integer[] nsqur = Arrays.stream(squr).boxed().toArray(Integer[]::new);
        Arrays.sort(nsqur, Collections.reverseOrder());
//        System.out.println(Arrays.toString(squr));
        dfsSquares(nsqur,0,0,n);
        return ans == Integer.MAX_VALUE ? -1 : ans;

    }
    public void dfsSquares(Integer[] squr,int c_index,int count,int n) {
        int len = squr.length;
        if(n == 0){
            ans = Math.min(count,ans);
            return;
        }
        if(c_index >= len) return;
        for(int k = n/squr[c_index]; k >= 0 && k + count < ans; k--){
            dfsSquares(squr,c_index+1,count+k,n-squr[c_index]*k);
        }
    }
}
