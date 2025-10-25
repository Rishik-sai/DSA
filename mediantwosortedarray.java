public class mediantwosortedarray {
    // static double findMedianSortedArrays(int[] a, int[] b) {
    //     if (a.length > b.length) return findMedianSortedArrays(b, a);

    //     int n1 = a.length, n2 = b.length;
    //     int low = 0, high = n1;

    //     while (low <= high) {
    //         int cut1 = (low + high) / 2;
    //         int cut2 = (n1 + n2 + 1) / 2 - cut1;

    //         int l1 = (cut1 == 0) ? Integer.MIN_VALUE : a[cut1 - 1];
    //         int l2 = (cut2 == 0) ? Integer.MIN_VALUE : b[cut2 - 1];
    //         int r1 = (cut1 == n1) ? Integer.MAX_VALUE : a[cut1];
    //         int r2 = (cut2 == n2) ? Integer.MAX_VALUE : b[cut2];

    //         if (l1 <= r2 && l2 <= r1) {
    //             if ((n1 + n2) % 2 == 0)
    //                 return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
    //             else
    //                 return Math.max(l1, l2);
    //         }
    //         else if (l1 > r2)
    //             high = cut1 - 1;
    //         else
    //             low = cut1 + 1;
    //     }

    //     return 0.0; 
    // }
    static double findMedianSortedArrays(int a[], int b[]) {
    int n1 = a.length, n2 = b.length;
    int n = n1 + n2;
    int i = 0, j = 0, count;
    int m1 = -1, m2 = -1;
    for (count = 0; count <= n / 2; count++) {
        m2 = m1;
        if (i != n1 && (j == n2 || a[i] <= b[j])) {
            m1 = a[i];
            i++;
        } else {
            m1 = b[j];
            j++;
        }
    }

    if (n % 2 == 1)
        return m1;
    else
        return (m1 + m2) / 2.0;
}

    public static void main(String[] args) {
        int[] a = {1, 3};
        int[] b = {2};
        System.out.println("Median is: " + findMedianSortedArrays(a, b));
    }
}
