public class Inversions {
    // Return the number of inversions in the permutation a[].
    public static long count(int[] a) {
        int len = a.length;
        int count = 0;
        for(int i = 0; i < len; i++) {
            for(int j = i + 1; j < len; j++) {
                if(a[i] < a[j]) count++;
            }
        }
        return count;
    }

    // Return a permutation of length n with exactly k inversions.
    public static int[] generate(int n, long k) {
        int[] arr = new int[n];
        int counter = 1;
        long newk = k;
        if (k == ((long) n) * (n - 1) / 2) {
            for (int i = 0; i < n; i++) {
                arr[i] = n - i - 1;
            }
            return arr;
        }
        while (newk >= ((long) n) - counter) {
            arr[counter - 1] = n - counter;
            newk = newk - n + counter;
            counter++;
        }
        int index = n - (int) newk - 1;
        arr[index] = n - counter;
        for (int i = counter - 1; i < index; i++) {
            arr[i] = i - counter + 1;
        }
        for (int i = index + 1; i < n; i++) {
            arr[i] = i - counter;
        }
        return arr;
    }

    // Takes an integer n and a long k as command-line arguments,
    // and prints a permutation of length n with exactly k inversions.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        long k = Long.parseLong(args[1]);
        int[] arr = generate(n, k);
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
