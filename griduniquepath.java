public class griduniquepath {
    public static void main(String[] args) {
        int m = 2;
        int n = 3;
        System.out.println(uniquePaths(m, n));
    }

    static int uniquePaths(int m, int n) {
        int N = m + n - 2;   // total steps
        int r = Math.min(m - 1, n - 1); // choose smaller to reduce computation
        long res = 1;        // use long to avoid overflow for big grids
        for (int i = 0; i < r; i++) {
            res = res * (N - i) / (i + 1);
        }
        return (int) res;
    }
}
