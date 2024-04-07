public class ShannonEntropy {
    public static void main (String[] args) {
        int m = Integer.parseInt(args[0]);
        int[] count = new int[m+1];
        double[] prob = new double[m+1];
        while (!StdIn.isEmpty()) {
            int n = StdIn.readInt();
            count[n]++;
        }
        int total = 0;
        for (int i = 0; i < m+1; i++) {
            if (count[i] > 0) {
                total += count[i];
            }
        }
        for (int i = 0; i < m+1; i++) {
            if (count[i] > 0) {
                prob[i] = (double)count[i] / total;
            }
        }
        double ans = 0;
        for (int i = 0; i < m+1; i++) {
            if(count[i] > 0) {
               ans += -prob[i] * (Math.log(prob[i]) / Math.log(2));
            }
        }
        System.out.println(ans);
    }
}
