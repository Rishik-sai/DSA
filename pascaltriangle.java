public class pascaltriangle {
    static int ncr(int row ,int col){
        int ans=1;
        for(int i=0;i<col;i++){
            ans=ans*(row-i);
            ans=ans/(i+1);
        }
        return ans;
        }
    public static void main(String[] args) {
        //1
        int row=4,col=3;
        System.out.println(ncr(row-1,col-1));//element at row 4 and col 3   

        //2
        int ans=1;
        for(col=1;col<=row;col++){//print all elements in row 4
            System.out.print(ans+" ");
            ans=ans*(row-col);
            ans=ans/col;
        }
        System.out.println();

        //3
        for(row=0;row<5;row++){
            ans=1;
            for(col=1;col<=row;col++){
            System.out.print(ans+" ");
            ans=ans*(row-col);
            ans=ans/col;
        }
        System.out.println();
        }
    }
}
