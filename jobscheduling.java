import java.util.Arrays;

public class jobscheduling {
    static class Job {
        int id, deadline, profit;

        Job(int id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }
    static int[] jobScheduling(Job[] jobs) {
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);
        int maxd = 0;
        for (Job job : jobs) {
            maxd = Math.max(maxd, job.deadline);
        }
        int[] slot = new int[maxd + 1];
        Arrays.fill(slot, -1);

        int jobsDone = 0, totalProfit = 0;
        for (Job job : jobs) {
            for (int time = job.deadline; time > 0; time--) {
                if (slot[time] == -1) {
                    slot[time] = job.id;
                    jobsDone++;
                    totalProfit += job.profit;
                    break;
                }
            }
        }

        return new int[]{jobsDone, totalProfit};
    }

    public static void main(String[] args) {
        Job[] jobs = {
            new Job(1, 4, 20),
            new Job(2, 1, 10),
            new Job(3, 2, 40),
            new Job(4, 2, 30)
        };

        int[] result = jobScheduling(jobs);
        System.out.println("Jobs Done: " + result[0] + ", Total Profit: " + result[1]);
    }
}
