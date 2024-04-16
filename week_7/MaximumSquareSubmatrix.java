public class MaximumSquareSubmatrix {
    // Returns the size of the largest contiguous square submatrix
    // of a[][] containing only 1s.
    public static int size(int[][] a) {
        int len = a.length;
        int max = 0;
        int[][] m = new int[len][len];
        for(int i = 0; i < len; i++) {
            m[i][0] = a[i][0];
        }
        for(int i = 0; i < len; i++) {
            m[0][i] = a[0][i];
        }
        for(int i = 1; i < len; i++) {
            for(int j = 1; j < len; j++) {
                if(a[i][j] == 1) {
                    m[i][j] = Math.min(m[i][j-1], (Math.min(m[i-1][j], m[i-1][j-1]))) + 1;
                } else m[i][j] = 0;
                if (m[i][j] > max) max = m[i][j];
            }
        }
        return max;
    }

    // Reads an n-by-n matrix of 0s and 1s from standard input
    // and prints the size of the largest contiguous square submatrix
    // containing only 1s.
    public static void main(String[] args) {
        int n = StdIn.readInt();
        int[][] a = new int[n][n];
        while(!StdIn.isEmpty()) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    a[i][j] = StdIn.readInt();
                }
            }
        }
        System.out.println(size(a));
    }
}
