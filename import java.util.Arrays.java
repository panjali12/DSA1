import java.util.Arrays;

public class ArrayRotation {
    public static void rotateArrayToRight(int[] arr, int rotationCount) {
        if (arr == null || arr.length == 0 || rotationCount <= 0) {
            return;
        }

        int n = arr.length;
        rotationCount = rotationCount % n; // To handle rotation counts greater than the array length

        // Rotate the array to the right by reversing the subarrays
        reverseArray(arr, 0, n - rotationCount - 1);
        reverseArray(arr, n - rotationCount, n - 1);
        reverseArray(arr, 0, n - 1);
    }

    private static void reverseArray(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] inputArray = {1, 2, 3, 4, 5};
        int rotationCount = 2;
        rotateArrayToRight(inputArray, rotationCount);
        System.out.println(Arrays.toString(inputArray)); // Output: [4, 5, 1, 2, 3]
    }
}
