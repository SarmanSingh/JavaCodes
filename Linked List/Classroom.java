import java.util.LinkedList;
public class Classroom{
    public static void main(String args[]){
        //Create LinkedList
        LinkedList<Integer> ll=new LinkedList<>(); 

        //Adding element
        ll.addLast(1);
        ll.addLast(3);
        ll.addFirst(5);
        System.out.println(ll);
        //removing element
        ll.removeFirst();
        ll.removeLast();
        System.out.println(ll);
    }
}