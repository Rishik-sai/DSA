public class repeatingandmissing {
    public static void main(String[] args) {
        int [] array={3,1,3,5,2};
        int n=array.length;
        int sum=0;
        int sum1=0;
        for(int i=0;i<n;i++){
            sum+=array[i];
            sum1+=i+1;
        }
        int diff=sum-sum1;
        int sum2=0;
        int sum3=0;
        for(int i=0;i<n;i++){
            sum2+=array[i]*array[i];
            sum3+=(i+1)*(i+1);
        }
        int diff2=sum2-sum3;
        int sum4=diff2/diff;
        int repeating=(diff+sum4)/2;
        int missing=sum4-repeating;
        System.out.println("repeating number is "+repeating); 
        System.out.println("missing number is "+missing);
    }
}
