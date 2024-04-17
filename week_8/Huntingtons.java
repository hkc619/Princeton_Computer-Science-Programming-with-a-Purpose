public class Huntingtons {
    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna) {
        int count = 0;
        int max = 0;
        int i = 0;
        while(i < dna.length() - 2) {
            String colon = dna.substring(i, i + 3);
            if (colon.equals("CAG")) {
                i += 3;
                count++;
                if (count > max) max = count;
            } else {
                i++;
                count = 0;
            }
        }
        return max;
    }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
    public static String removeWhitespace(String s) {
        String s1 = s.replace("\r\n", "");
        String s2 = s1.replace("\n", "");
        String s3 = s2.replace("\t", "");
        return  s3.replace(" ", "");
    }

    // Returns one of these diagnoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats) {
        if (maxRepeats > 180) return "not human";
        else if (maxRepeats > 40) return "Huntington’s";
        else if (maxRepeats > 35) return "high risk";
        else if (maxRepeats > 9) return "normal";
        else return "not human";
    }

    // Sample client (see below).
    public static void main(String[] args) {
        String file = args[0];
        In in = new In(file);
        String s = in.readAll();
        String dna = removeWhitespace(s);
        int res = maxRepeats(dna);
        System.out.println("max repeats = " + res);
        System.out.println(diagnose(res));
    }
}
