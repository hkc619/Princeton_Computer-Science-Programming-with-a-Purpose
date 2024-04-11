public class AudioCollage {
    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
        double[] b = new double [a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i] * alpha;
        }
        return b;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {
        double[] b = new double [a.length];
        for (int i = 0; i < a.length; i++) {
            b[a.length -1 - i] = a[i];
        }
        return b;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {
        double[] c = new double [a.length + b.length];
        System.arraycopy(a, 0, c, 0, a.length);
        System.arraycopy(b, 0, c, a.length, b.length);
        return c;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {
        int len;

        if (a.length > b.length) {
            len = a.length;
        } else {
            len = b.length;;
        }
        double[] aa = new double [len];
        double[] bb = new double [len];
        double[] c = new double [len];
        System.arraycopy(a, 0, aa, 0, a.length);
        System.arraycopy(b, 0, bb, 0, b.length);
        for (int i = 0; i < len; i++) {
            c[i] = aa[i] + bb[i];
        }
        return c;
    }

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha) {
        double sample = (double) a.length / alpha;
        int samp = (int) sample;
        double[] b = new double[samp];
        for (int i = 0; i < samp; i++) {
            b[i] = a[i * (int) alpha];
        }
        return b;
    }

    // Creates an audio collage and plays it on standard audio.
    // See below for the requirements.
    public static void main(String[] args) {
        double[] sample1 = StdAudio.read("cow.wav");
        double[] sample2 = StdAudio.read("silence.wav");
        double[] sample3 = StdAudio.read("piano.wav");
        double[] sample4 = StdAudio.read("harp.wav");
        double[] sample5 = StdAudio.read("chimes.wav");
        double[] edit1 = amplify(sample1, 0.5);
        double[] edit2 = reverse(sample3);
        double[] edit3 = merge(edit1, sample4);
        double[] edit4 = changeSpeed(sample5, 1.2);
        double[] edit5 = mix(edit2, edit4);
        double[] edit6 = merge(edit3, edit5);
        double[] edit7 = merge(edit6, sample2);
        StdAudio.play(edit7);
    }
}
