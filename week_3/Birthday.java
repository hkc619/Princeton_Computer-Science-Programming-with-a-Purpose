//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Birthday {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trails = Integer.parseInt(args[1]);
        double fraction = 0.0;
        int t = 1;
        int count = 0;
        while (fraction <= 0.5) {
            for (int i = 0; i < trails; i++) {
                double prob = Math.random();
                if (prob<((double)t - 1)/n){
                    count++;
                }
            }
            fraction += (double)count / trails;
            System.out.print(t + "\t" + count + "\t" + fraction);
            System.out.println();
            t++;
            count = 0;

        }
    }
}