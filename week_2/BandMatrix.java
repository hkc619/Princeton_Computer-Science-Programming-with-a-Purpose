// TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class BandMatrix {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int w = Integer.parseInt(args[1]);
        for (int i = 0; i < n; i++) {
            String res = "";
            for (int j = 0; j < n; j++) {
               if (w >= Math.abs(i - j)) {
                   res += "*";
               }else {
                   res += "0";
               }
                if (j < n-1) {
                    res+= "  ";
                }
            }
            System.out.println(res);
        }

    }
}