import java.util.ArrayList;
public class Classroom {
//Two pointer Approach
    public static int storeWater2(ArrayList<Integer> height){
        int maxWater1=0;
        int lp=0;
        int rp=height.size()-1;
        while(lp<rp){
            int ht=Math.min(height.get(lp),height.get(rp));
            int width=rp-lp;
            int currWater=ht*width;
            maxWater1=Math.max(currWater,maxWater1);
            if(height.get(lp)<height.get(rp)){
                lp++;
            }
            else{
                rp--;
            }
        }
        return maxWater1;
    }

    public static int storWater(ArrayList<Integer> height){
        int maxWater=0;
        //brute force
        for(int i=0;i<height.size();i++){
            for(int j =i+1;j<height.size();j++){
                int ht=Math.min(height.get(i),height.get(j));
                int width=j-i;
                int currArea=ht*width;
                maxWater=Math.max(maxWater,currArea);
            }
        }
        return maxWater;
    }
    public static void main(String args[]){
        ArrayList<Integer> height=new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(6);
        height.add(3);
        height.add(7);
        System.out.println(storeWater2(height));

    }
    
}
