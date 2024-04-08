//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class DiscreteDistribution {
    public static void main(String[] args) {
        int argsLen = args.length;
        int len = argsLen - 1;
        String [] arr = new String[argsLen];
        int [] s = new int[len];
        System.arraycopy(args, 0, arr, 0, argsLen);
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                s[i] = Integer.parseInt(arr[i+1]);
            } else {
                s[i] = Integer.parseInt(arr[i+1]) + s[i-1];
            }
        }
        for (int i = 0; i < Integer.parseInt(arr[0]); i++) {
            double guess = Math.random() * s[len-1];
            for(int j = 0; j < len; j++) {
                if(guess < s[j]) {
                    System.out.print(j+1 + " ");
                    break;
                }
            }
        }
    }
}