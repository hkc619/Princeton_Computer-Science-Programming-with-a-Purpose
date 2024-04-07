public class Checkerboard {
    public static void main (String[] args) {
        int n = Integer.parseInt(args[0]);
        StdDraw.setScale(0, n);
        for (double i = 0.5; i <= n; i += 2) {
            for (double j = 0.5; j <= n; j += 2) {
                StdDraw.setPenColor(StdDraw.BLUE);
                StdDraw.filledSquare(i, j, 0.5);
                StdDraw.filledSquare(i + 1, j + 1, 0.5);
                StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                StdDraw.filledSquare(i + 1, j, 0.5);
                StdDraw.filledSquare(i, j + 1, 0.5);
            }
        }
    }
}
