//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class RandomWalker {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        System.out.println("(0, 0)");
        int i = 0, j = 0, step = 0;
        while (Math.abs(i) + Math.abs(j) < n) {
            if (Math.random() > 0.75) {
                j++;
                step++;
            } else if (Math.random() > 0.5) {
                i++;
                step++;
            } else if (Math.random() > 0.25) {
                j--;
                step++;
            } else {
                i--;
                step++;
            }
            System.out.println("("+i+", "+j+")");

        }
        System.out.println("steps = "+step);
    }
}