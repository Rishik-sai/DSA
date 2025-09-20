import java.util.*;

public class overlappingsubintervals {
    public static int[][] mergeOverlappingIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int[][] result = new int[intervals.length][2];
        int ind = 0; 
        result[0][0] = intervals[0][0];
        result[0][1] = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= result[ind][1]) {
                result[ind][1] = Math.max(result[ind][1], intervals[i][1]);
            } else {
                ind++;
                result[ind][0] = intervals[i][0];
                result[ind][1] = intervals[i][1];
            }
        }
        return Arrays.copyOf(result, ind + 1);
    }

    public static void main(String[] args) {
        int [][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int [][] ans = mergeOverlappingIntervals(intervals);

        System.out.print("The merged intervals are: ");
        System.out.println(Arrays.deepToString(ans));
    }
}
