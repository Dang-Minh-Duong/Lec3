import edu.princeton.cs.algs4.StdArrayIO;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Random;

public class BinaryFind {
    private int[] a;
    public static void set(int[] a, int n) {
        Random rand = new Random();
        for (int i =0;i<n;i++) a[i] = rand.nextInt(100) - 50;
        Arrays.sort(a);
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
    public static void main(String[] args) {
        int n = StdIn.readInt();
        int[] a = new int[n];
        set(a, n);
        StdArrayIO.print(a);
        int num = StdIn.readInt();
        StdOut.print(find(a, num));
    }
}
