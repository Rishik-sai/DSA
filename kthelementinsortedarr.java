import java.util.*;

public class kthelementinsortedarr {

    public static int kthElement(ArrayList<Integer> a, ArrayList<Integer> b, int k) {
        int m = a.size(), n = b.size();

        // Ensure 'a' is the smaller array for binary search efficiency
        if (m > n) return kthElement(b, a, k);

        int low = Math.max(0, k - n);
        int high = Math.min(k, m);

        while (low <= high) {
            int cutA = (low + high) / 2;
            int cutB = k - cutA;
            int leftA = (cutA == 0) ? Integer.MIN_VALUE : a.get(cutA - 1);
            int leftB = (cutB == 0) ? Integer.MIN_VALUE : b.get(cutB - 1);
            int rightA = (cutA == m) ? Integer.MAX_VALUE : a.get(cutA);
            int rightB = (cutB == n) ? Integer.MAX_VALUE : b.get(cutB);

            if (leftA <= rightB && leftB <= rightA)
                return Math.max(leftA, leftB);
            else if (leftA > rightB)
                high = cutA - 1;
            else
                low = cutA + 1;
        }
        return -1; // unreachable if k is valid
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(2, 3, 6, 7, 9));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(1, 4, 8, 10));

        int k = 5;
        System.out.println("The " + k + "-th element of the two sorted arrays is: "+ kthElement(a, b, k));
    }
}
