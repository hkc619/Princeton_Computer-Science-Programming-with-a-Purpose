public class ActivationFunction {
    public static double heaviside(double x) {
        if (x > 0) return 1;
        if (x < 0) return 0;
        else return (double) 1 / 2;
    }

    // Returns the sigmoid function of x.
    public static double sigmoid(double x) {
        double e = Math.E;
        return (double) 1 / (1 + Math.pow(e, -x));
    }

    // Returns the hyperbolic tangent of x.
    public static double tanh(double x) {
        double e = Math.E;
        return (Math.pow(e, x) - Math.pow(e, -x)) / (Math.pow(e, x) + Math.pow(e, -x));
    }

    // Returns the softsign function of x.
    public static double softsign(double x) {
        return x / (1 + Math.abs(x));
    }

    // Returns the square nonlinearity function of x.
    public static double sqnl(double x) {
        if (x <= -2) {
            return -1;
        } else if (x < 0) {
            return x + (x * x) / 4;
        } else if (x < 2) {
            return x - (x * x) / 4;
        } else {
            return 1;
        }
    }

    // Takes a double command-line argument x and prints each activation
    // function, evaluated, in the format (and order) given below.
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        System.out.println("heaviside(" + x +") = " + heaviside(x));
        System.out.println("  sigmoid(" + x +") = " + sigmoid(x));
        System.out.println("     tanh(" + x +") = " + tanh(x));
        System.out.println(" softsign(" + x +") = " + softsign(x));
        System.out.println("     sqnl(" + x +") = " + sqnl(x));
    }
}
