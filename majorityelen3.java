import java.util.*;
public class majorityelen3 {
    static List<Integer> majorityElementBy3(int[] arr, int n) {
        int count1 = 0, count2 = 0;
        int candidate1 = -1, candidate2 = -1;

        // Step 1: Find candidates
        for (int num : arr) {
            if (num == candidate1) count1++;
            else if (num == candidate2) count2++;
            else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Step 2: Verify
        count1 = 0;
        count2 = 0;
        for (int num : arr) {
            if (num == candidate1) count1++;
            else if (num == candidate2) count2++;
        }

        List<Integer> result = new ArrayList<>();
        if (count1 > n / 3) result.add(candidate1);
        if (count2 > n / 3) result.add(candidate2);
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 1, 2, 2};
        System.out.println(majorityElementBy3(arr, arr.length)); 
    }
}
