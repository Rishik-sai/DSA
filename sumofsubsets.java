import java.util.*;

public class sumofsubsets {

    static void generateSubsetSums(int index, int currentSum, List<Integer> arr, List<Integer> result) {
        if (index == arr.size()) {
            result.add(currentSum);
            return;
        }
        generateSubsetSums(index + 1, currentSum + arr.get(index), arr, result);
        generateSubsetSums(index + 1, currentSum, arr, result);
    }

    static List<Integer> subsetSums(List<Integer> arr) {
        List<Integer> result = new ArrayList<>();
        generateSubsetSums(0, 0, arr, result);
        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(3, 1, 2);
        List<Integer> ans = subsetSums(arr);

        System.out.println("The sum of each subset is:");
        for (int sum : ans) {
            System.out.print(sum + " ");
        }
    }
}
