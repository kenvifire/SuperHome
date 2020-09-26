package hello;

import java.util.Arrays;

public class CountSquares1277 {
    public int countSquares(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        System.out.println(row);
        System.out.println(col);

        int[][] pre_matrix = new int[row][col];
        int ans = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                pre_matrix[i][j] = matrix[i][j];
                if(matrix[i][j] == 1) ans++;
            }
        }
        System.out.println(ans);
//        for(int i = 0; i< row;i++){
//            System.out.println(Arrays.toString(pre_matrix[i]));
//        }
        for(int i = 0; i < row; i++){
            for(int j = 1; j < col; j++){
                pre_matrix[i][j] += pre_matrix[i][j-1];
            }
        }
        for(int i = 0; i < col; i++){
            for(int j = 1; j < row; j++){
                pre_matrix[j][i] += pre_matrix[j-1][i];
            }
        }
        for(int i = 0; i< row;i++){
            System.out.println(Arrays.toString(pre_matrix[i]));
        }
        for(int i = 0; i < row-1; i++) {
            for (int j = 0; j < col-1; j++) {
                if(matrix[i][j] == 0) continue;
                for(int k = 1; k < Math.min(row,col); k++){
                    if(isSquares(pre_matrix,i,j,k)) {
                        System.out.println(String.format("x = %d,y = %d , k = %d", i,j,k));
                        ans++;
                    }
                }
            }
        }
        return ans;

    }
    //    判断已x,y 为左上角，边长为k,是不是全1正方形
    public boolean isSquares(int[][] matrix,int i,int j,int K){
        int row = matrix.length;
        int col = matrix[0].length;
        int i_max = i + K < row ? i + K : row -1;
        int j_max = j + K < col ? j + K : col -1;
        int sum=0;
        if(i == 0 && j == 0){
            sum= matrix[i_max][j_max];
        }else if(i == 0 && j != 0){
            sum= matrix[i_max][j_max] - matrix[i_max][j-1] ;
        }else if(i != 0 && j == 0)
        {
            sum= matrix[i_max][j_max] - matrix[i-1][j_max];
        }else if(i != 0 && j !=0){
            sum = matrix[i_max][j_max] - matrix[i-1][j_max] - matrix[i_max][j-1] + matrix[i - 1][j-1];
        }
        if(sum == (K+1)*(K+1)){
            return true;
        }else{
            return false;
        }

    }
}
