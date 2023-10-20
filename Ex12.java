import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex12 {
    public static List<Integer> findCommonElements(int[] arr1, int[] arr2) {
        List<Integer> result = new ArrayList<>();
        int i = 0; // Vị trí hiện tại trong arr1
        int j = 0; // Vị trí hiện tại trong arr2

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr1[i] > arr2[j]) {
                j++;
            } else {
                result.add(arr1[i]);
                i++;
                j++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the length of 2 arrays: ");
        int N = scanner.nextInt();
        int[] arr1 = new int[N];
        int[] arr2 = new int[N];

        System.out.println("Enter the first array: ");
        for (int i = 0; i < N; i++) {
            arr1[i] = scanner.nextInt();
        }

        System.out.println("Enter the second array: ");
        for (int i = 0; i < N; i++) {
            arr2[i] = scanner.nextInt();
        }

        List<Integer> commonElements = findCommonElements(arr1, arr2);

        for (Integer element : commonElements) {
            System.out.println(element);
        }
    }
}
