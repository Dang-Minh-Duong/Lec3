import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdArrayIO;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class ThreeSumBinary {
    public static void main(String[] args) {
        In in = new In("D:\\Code\\Java project\\Java DSA\\2Kints.txt");
        int [] a = in.readAllInts();
        Arrays.sort(a);
        int countt  = 0;
        for (int i =0;i<a.length-2;i++) for (int j=i+1;j<a.length-1;j++) {
            int k = find(a, -(a[i]+a[j]));
            if (k>j) {
                StdOut.println(a[i]+" "+a[j] + " "+a[k]);
                countt++;
            }
        }
        StdOut.print(countt);
    }
    public static int find(int[] a, int x) {
        int max = a.length - 1;
        int min = 0;
        while (max >= min){
            int tmp = (max+min)/2;
            if (a[tmp] > x) max = tmp -1;
            else if (a[tmp] < x) min = tmp +1;
            else return tmp;
        }
        return -1;
    }

}
