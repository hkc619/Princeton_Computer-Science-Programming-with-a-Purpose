//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class GeneralizedHarmonic {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int r = Integer.parseInt(args[1]);
        double res = 0.0;
        for (int i = 1; i <= n; i++) {
            res += 1/Math.pow(i, r);
        }
        System.out.println(res);
    }
}