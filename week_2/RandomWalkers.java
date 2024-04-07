//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class RandomWalkers {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        long wholesteps = 0;
        for(int t = 0; t < trials; t++) {
            int i = 0, j = 0, step = 0;
            while(Math.abs(i) + Math.abs(j) < n) {
                if(Math.random() > 0.75) {
                    j--;
                } else if (Math.random()>0.5) {
                    j++;
                } else if (Math.random()>0.25) {
                    i--;
                } else {
                    i++;
                }
                step++;
            }
            wholesteps += step;
        }
        System.out.println("average number of steps = " + (double)wholesteps/(double)trials);
    }
}