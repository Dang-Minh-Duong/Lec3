import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;


public class Ex8 {
    public static void main(String[] args) {
        In in = new In("D:\\Code\\Java project\\Java DSA\\array.txt");
        int[] a = in.readAllInts();
        Arrays.sort(a);
        StdOut.print(count(a));
    }

    public static int count(int [] a) {
        int count = 0;
        int currentCount = 1;
        for (int i = 1;i<a.length;i++) {
            if (a[i] == a[i-1]) {
                currentCount ++;
            }
            else {
                count += (currentCount*(currentCount-1)) / 2;
                currentCount = 1;
            }
        }
        count += (currentCount*(currentCount-1)) / 2;
        return count;
    }

}
