public class ReverseArr{
    public static void reverseArray(int numbers[]){
        int start=0, last=numbers.length-1;
        while(start<last){
            int temp=numbers[last];
            numbers[last]=numbers[start];
            numbers[start]=temp;
            start++;
            last--;
        }

    }
    public static void main(String [] args){
        int numbers[]={1,4,5,3,6,8};
        reverseArray(numbers);
        for(int i=0;i<numbers.length;i++){
            System.out.print(numbers[i]+" ");
        }

    }
}