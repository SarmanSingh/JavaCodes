public class MaxSubSum{

    public static int kadanes(int numbers[]){
        int currSum=0;
        int maxSum=Integer.MIN_VALUE;
        for(int i=0;i<numbers.length;i++){
            currSum += numbers[i];
            if(currSum<0){
                currSum=0;
            }
            maxSum=Math.max(currSum,maxSum);
        }
        return maxSum;
    }
    public static int prefixSum(int numbers[]){
        int currSum=0;
        int maxSum=Integer.MIN_VALUE;
        int prefix[]=new int[numbers.length];
        prefix[0]=numbers[0];
        for(int i=1;i<prefix.length;i++){
            prefix[i]=prefix[i-1]+numbers[i];
        }

        for(int i=0;i<prefix.length;i++){
            currSum=0;
            for(int j=i;j<prefix.length;j++){
                currSum=i==0?prefix[j]:prefix[j]-prefix[i-1];
                if(maxSum<currSum){
                    maxSum=currSum;
                }
            }
        }
        return maxSum;
    }

    public static int printSubArraySum(int numbers[]){
        int currSum=0;
        int maxSum=Integer.MIN_VALUE;
        for(int i=0;i<numbers.length;i++){
            for(int j=i;j<numbers.length;j++){
                currSum=0;
                for(int k=i;k<=j;k++){
                    currSum += numbers[k];
                }
                if(currSum>maxSum){
                    maxSum=currSum;
                }
            }
        }
        return maxSum;
    }
    public static void main(String [] args){
        int numbers[]={1,4,3,5,7,3};
        int a=kadanes(numbers);
        System.out.println(a);
    }
}