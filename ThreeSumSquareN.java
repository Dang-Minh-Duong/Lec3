import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class ThreeSumSquareN {
    public static void main(String[] args) {
        In in = new In("D:\\Code\\Java project\\Java DSA\\2Kints.txt");
        int [] a = in.readAllInts();
        Arrays.sort(a);
        find(a, 0);
    }
    static void find(int [] a, int sum) {
        for (int i = 0;i<a.length-2;i++) {
            int r = a.length - 1;
            int l = i + 1;
            while(r > l) {
                if (a[i] + a[r] + a[l] == sum) {
                    StdOut.print(a[i] + " " + a[l] +" "+ a[r]);
                }
                else if (a[i]+a[r]+a[l] > 0) r--;
                else l ++;
            }
        }
    }
}
