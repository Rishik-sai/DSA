public class majorityelement {
    public static void main(String[] args) {
        int arr[]={2,2,3,3,1,2,2};
        int n=arr.length;
        int ele=majorityele(arr,n);
        System.out.println(ele);
    }
    static int majorityele(int arr[],int n){
        int count=0;
        int candidate=arr[0];
        for(int i=0;i<n;i++){
            if(count==0){
                candidate=arr[i];
            }
            if(arr[i]==candidate){
                count++;
            }else{
                count--;
            }
        }
        int freq=0;
        for(int i=0;i<n;i++){
            if(arr[i]==candidate){
                freq++;
            }
        }
        if(freq>n/2){
            return candidate;
        }else{
            return -1;
        }
    }
}
