import java.util.Arrays;

public class CountEqualPairs {
    public static int countEqualPairs(int[] nums) {
        // Sắp xếp mảng theo thứ tự tăng dần (NlogN)
        Arrays.sort(nums);

        int count = 0; // Số cặp số giá trị bằng nhau
        int currentCount = 1; // Số lượng số giống nhau hiện tại

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                // Nếu phần tử hiện tại giống với phần tử trước đó
                currentCount++;
            } else {
                // Nếu không giống, thêm số cặp mới với số lượng hiện tại
                count += (currentCount * (currentCount - 1)) / 2;
                currentCount = 1; // Đặt lại số lượng hiện tại về 1
            }
        }

        // Xử lý trường hợp cuối cùng nếu có số giống nhau
        count += (currentCount * (currentCount - 1)) / 2;

        return count;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 2, 3, 1, 1}; // 1 1 1 2 2 3 3
        int result = countEqualPairs(nums);
        System.out.println("Số cặp số có giá trị bằng nhau: " + result);
    }
}
