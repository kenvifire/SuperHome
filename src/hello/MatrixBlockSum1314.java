package hello;

import java.util.Arrays;

public class MatrixBlockSum1314 {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int col = mat[0].length;
        int row = mat.length;
        int[][] matrix = new int[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                matrix[i][j] = mat[i][j];
            }
        }
        for(int i = 0; i < row; i++){
            for(int j = 1; j < col; j++){
                matrix[i][j] += matrix[i][j-1];
            }
        }
        for(int i = 0; i < col; i++){
            for(int j = 1; j < row; j++){
                matrix[j][i] += matrix[j-1][i];
            }
        }
        for(int i = 0; i< 3;i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                int i_max = i + K < row ? i + K : row -1;
                int j_max = j + K < col ? j + K : col -1;
                int i_min = i - K >= 0 ? i - K : 0;
                int j_min = j - K >= 0 ? j - K : 0;
                if(i_min == 0 && j_min == 0)
                {
                    mat[i][j] = matrix[i_max][j_max];
                }else if(i_min == 0 && j_min != 0){
                    mat[i][j] = matrix[i_max][j_max] - matrix[i_max][j_min-1];
                }else if(i_min != 0 && j_min == 0){
                    mat[i][j] = matrix[i_max][j_max] - matrix[i_min-1][j_max];
                }else if(i_min != 0 && j_min != 0){
                    mat[i][j] = matrix[i_max][j_max] - matrix[i_min-1][j_max] - matrix[i_max][j_min-1] + matrix[i_min - 1][j_min-1];
                }


            }
        }
        return mat;

    }
}
