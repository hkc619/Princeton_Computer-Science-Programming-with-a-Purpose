public class Ramanujan {
    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n) {
        int count = 0;
        int stat = 0;
        for(long i = 1; i < Math.cbrt(n); i++) {
            double b = Math.cbrt(n - i * i * i);
            if(b == Math.floor(b)) {
                if(count == 0) {
                    stat = (int)b;
                    count ++;
                }else if(i != stat) count ++;
                if(count == 2) return true;
            }
        }
        return false;
    }

    // Takes a long integer command-line arguments n and prints true if
    // n is a Ramanujan number, and false otherwise.
    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        System.out.println(isRamanujan(n));
    }
}
