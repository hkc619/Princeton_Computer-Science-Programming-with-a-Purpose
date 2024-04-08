//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Minesweeper {
    public static void main(String[] args) {
       int m = Integer.parseInt(args[0]);
       int n = Integer.parseInt(args[1]);
       int k = Integer.parseInt(args[2]);
       boolean [][] matrix = new boolean[m + 2][n + 2];
       int [][] minenum = new int [m + 2][n + 2];
       for (int i = 0; i < k; i++) {
           int x, y;
           int mineX = (int)Math.floor(Math.random() * m) + 1;
           int mineY = (int)Math.floor(Math.random() * n) + 1;
           matrix[mineX][mineY] = true;
       }
       for (int i = 1; i < m + 1; i++) {
           for (int j = 1; j < n + 1; j++) {
               int num = 0;
               if (matrix[i-1][j-1]) num++;
               if (matrix[i+1][j+1]) num++;
               if (matrix[i+1][j-1]) num++;
               if (matrix[i-1][j+1]) num++;
               if (matrix[i][j-1]) num++;
               if (matrix[i][j+1]) num++;
               if (matrix[i+1][j]) num++;
               if (matrix[i-1][j]) num++;
               minenum[i][j] = num;
           }
       }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n+1; j++) {
                if (matrix[i][j]) System.out.print("*  ");
                else System.out.print(minenum[i][j] + "  ");
            }
            System.out.println();
        }
    }
}