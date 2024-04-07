
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class GreatCircle {
    public static void main(String[] args) {
        double r = 6371.0;
        double x1 = Double.parseDouble(args[0]);
        double y1 = Double.parseDouble(args[1]);
        double x2 = Double.parseDouble(args[2]);
        double y2 = Double.parseDouble(args[3]);
        x1 = Math.toRadians(x1);
        y1 = Math.toRadians(y1);
        x2 = Math.toRadians(x2);
        y2 = Math.toRadians(y2);
        double p1 = Math.sin((x2-x1)/2);
        double p2 = Math.sin((y2-y1)/2);
        double p3 = Math.sqrt(p1*p1+Math.cos(x1)*Math.cos(x2)*p2*p2);
        double dis = Math.asin(p3)*2*r;
        System.out.println(dis+" Kilometers");
    }
}