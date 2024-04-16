public class RevesPuzzle {
    private static void hanoi(int n, int k, String a, String b, String c) {
        if (n == 0) return;
        else {
            hanoi(n-1, k, a, c, b);
            System.out.println("Move disc " + (n+k) + " from " + a + " to " + c);
            hanoi(n-1, k, b, a, c);
        }
    }

    public static void reves(int n, String a, String b, String c, String d) {
        int k = (int) Math.round(n + 1 - Math.sqrt(2 * n + 1));
        if (k == 0) System.out.println("Move disc " + 1 + " from " + a + " to " + d);
        else {
            reves(k, a, d, c, b);
            hanoi(n - k, k, a, c, d);
            reves(k, b, a, c, d);
        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        reves(n, "A", "B", "C", "D");
    }
}
