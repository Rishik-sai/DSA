public class searchin2Darray {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        int n=3,m=4;
        int target = 8;
        boolean ans = search(arr, target,n,m);
        System.out.println(ans);
    }
    static boolean search(int[][] matrix, int target,int n,int m) {
        int low=0,high=(n*m-1);
        while (low <=high) {
            int mid=(low+high)/2;
            int row=mid / m;
            int col=mid % m;
            if (matrix[row][col] == target) {
                return true;
            }
            else if (matrix[row][col] < target) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return false;
    }
}