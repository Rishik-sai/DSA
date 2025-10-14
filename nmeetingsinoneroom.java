import java.util.*;

public class nmeetingsinoneroom {
    static void maxMeetings(int[] start, int[] end, int n) {
        int[][] meetings = new int[n][3];
        for (int i = 0; i < n; i++) {
            meetings[i][0] = end[i];      // end time
            meetings[i][1] = start[i];    // start time
            meetings[i][2] = i + 1;       // meeting index
        }
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        ArrayList<Integer> result = new ArrayList<>();
        int lastEndTime = -1;
        for (int i = 0; i < n; i++) {
            if (meetings[i][1] > lastEndTime) {
                result.add(meetings[i][2]);
                lastEndTime = meetings[i][0];
            }
        }
        System.out.println("Meetings that can be attended:");
        for (int id : result) {
            System.out.print(id + " ");
        }
    }

    public static void main(String[] args) {
        int n = 6;
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 5, 7, 9, 9};
        maxMeetings(start, end, n);
    }
}
