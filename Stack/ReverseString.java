import java.util.Stack;
public class ReverseString {
    public static String reverseString(String str){
        Stack <Character> s=new Stack<>();
        String rev="";
        for(int i=0;i<str.length();i++){
            char a=str.charAt(i);
            s.push(a);
        }
        while(!s.isEmpty()){
            char top=s.pop();
            rev=rev+top;
        }
        return rev;
    }
    public static void main(String args[]){
        String str="ABC";
        System.out.println(reverseString(str));
    }
    
}
