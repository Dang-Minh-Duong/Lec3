import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class SherlockAndArray {
    public static void main(String[] args) {
        int n = StdIn.readInt();
        int [] array = new int[100];
        String [] resultArray = new String[n];
        for (int i = 0;i<n;i++) {
            int m = StdIn.readInt();
            for (int j =0;j<m;j++) {
                array[j] = StdIn.readInt();
            }
            resultArray[i] = result(array);
        }
        for (String result: resultArray) {
            StdOut.println(result);
        }
    }
    public static String result(int [] a) {
        int rightSum = 0, leftSum = 0;
        for (int x : a ) {
            rightSum += x;
        }
        for (int x : a) {
            rightSum -= x;
            if (rightSum == leftSum) {
                return "YES";
            }
            leftSum += x;
        }
        return "NO";
    }
}
