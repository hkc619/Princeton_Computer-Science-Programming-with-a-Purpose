//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ThueMorse {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        int n = Integer.parseInt(args[0]);
        boolean [] seq = new boolean [n];
        seq[0] = false;
        for(int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                seq[i] = seq[i / 2];
            } else seq[i] = !seq[i - 1];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (seq[i] == seq[j]){
                    System.out.print("+  ");
                } else {
                    System.out.print("-  ");
                }
            }
            System.out.println();
        }
    }
}