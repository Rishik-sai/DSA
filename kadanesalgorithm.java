public class kadanesalgorithm { 
    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4};
        int n = arr.length;
        long maxi = Long.MIN_VALUE;
        long sum = 0;
        int start = 0, end = 0, tempStart = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (sum > maxi) {
                maxi = sum;
                start = tempStart; 
                end = i;          
            }

            if (sum < 0) {
                sum = 0;
                tempStart = i + 1;
            }
        }

        System.out.println("The maximum subarray sum is: " + maxi);
        System.out.print("The subarray is: ");
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
