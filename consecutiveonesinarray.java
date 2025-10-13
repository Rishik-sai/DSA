public class consecutiveonesinarray {
    public static void main(String[] args) {
        int arr[]={1,0,1,1,1};
        int count=0,maxcount=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==1){
                count=count+1;
            }else{
                maxcount = Math.max(maxcount, count);
                count=0;
            }
        }
        maxcount = Math.max(maxcount, count);
        System.out.println(maxcount);
    }
}
