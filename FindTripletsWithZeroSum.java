import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class FindTripletsWithZeroSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng phần tử trong mảng: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        ArrayList<ArrayList<Integer>> result = findTripletsWithZeroSum(arr);

        if (result.isEmpty()) {
            System.out.println("Không tìm thấy bộ 3 số nguyên có tổng bằng 0.");
        } else {
            System.out.println("Các bộ 3 số nguyên có tổng bằng 0:");
            for (ArrayList<Integer> triplet : result) {
                System.out.println(triplet);
            }
        }

        scanner.close();
    }

    public static ArrayList<ArrayList<Integer>> findTripletsWithZeroSum(int[] arr) {
        ArrayList<ArrayList<Integer>> triplets = new ArrayList<>();
        Arrays.sort(arr); // Sắp xếp mảng để tối ưu việc tìm kiếm

        for (int i = 0; i < arr.length - 2; i++) {
            if (i == 0 || (i > 0 && arr[i] != arr[i - 1])) {
                int left = i + 1;
                int right = arr.length - 1;
                int target = -arr[i];

                while (left < right) {
                    if (arr[left] + arr[right] == target) {
                        ArrayList<Integer> triplet = new ArrayList<>();
                        triplet.add(arr[i]);
                        triplet.add(arr[left]);
                        triplet.add(arr[right]);
                        triplets.add(triplet);

                        // Bỏ qua các phần tử trùng lặp
                        while (left < right && arr[left] == arr[left + 1]) left++;
                        while (left < right && arr[right] == arr[right - 1]) right--;

                        left++;
                        right--;
                    } else if (arr[left] + arr[right] < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return triplets;
    }
}
