
public class sort012array {
    public static void  sortArray(int [] arr, int n) {
         int low = 0, mid = 0, high = n - 1; 
        while (mid <= high) {
            switch (arr[mid]) {
                case 0 -> {
                    int temp0 = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp0;
                    low++;
                    mid++;
                }
                case 1 -> {
                    mid++;
                }
                case 2 -> {
                    int temp2 = arr[mid];
                    arr[mid] = arr[high];
                    arr[high] = temp2;
                    high--;
                }
            }
        }
    }

    public static void main(String args[]) {
        int n = 6;
        int [] a={0,1,2,0,1,2};
        sortArray(a, n);
        System.out.println("After sorting:");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
