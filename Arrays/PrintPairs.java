public class PrintPairs{
    public static void printP(int numbers[]){
        for(int i=0;i<numbers.length;i++){
            for(int j=i+1;j<numbers.length;j++){
                System.out.print("("+numbers[i]+","+numbers[j]+")");
            }
            System.out.println();

        }
    }
    public static void main(String [] args){
        int numbers[]={1,4,5,3,4,5};
        printP(numbers);

    }
}