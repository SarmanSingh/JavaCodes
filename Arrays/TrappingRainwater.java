public class TrappingRainwater{
    public static int totalWater(int height[]){
        int wl=0;
        int tw=0;
        int n=height.length;
        //Left sub
        int leftArray[]=new int[n];
        leftArray[0]=height[0];
        for(int i=1;i<n;i++){
            leftArray[i]=Math.max(height[i],leftArray[i-1]);
        }

        //right array
        int rightArray[]=new int[n];
        rightArray[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--){
            rightArray[i]=Math.max(height[i],rightArray[i+1]);
        }

        for(int i=0;i<n;i++){
            wl=Math.min(leftArray[i],rightArray[i]);
            tw +=(wl-height[i]);
        }
        return tw;
    }
    public static void main(String []args){
        int height[]={1,3,5,0,2,4,5,7};
        int w=totalWater(height);
        System.out.println(w);
    }
}