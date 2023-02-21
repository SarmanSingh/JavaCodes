public class LinkedList {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data=data;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data){
        Node newNode=new Node(data);
        //Step 1 -Create new Node
        if(head==null){
            head=tail=newNode;
            size++;
            return;
        }
        // Step 2- Store the address of head in New node
        newNode.next=head;
        //step-3 - Make newNode as the head 
        head=newNode;
        size++;
    }

    public void addLast(int data){
        //Step 1 Create a new NOde
        Node newNode=new Node(data);
        if(head==null){
            head=tail=newNode;
            size++;
            return;
        }
        //Step 2 Point tail to newNode
        tail.next=newNode;

        //Step 3 Make newNode as your tail
        tail=newNode;
        size++;

    }
    public void print(){
        if(head==null){
            System.out.println("LL is Empty");
            return;
        }
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public void addMiddle(int data,int idx){
        if(idx==0){
            addFirst(data);
            return;
        }
        int i=0;
        Node temp=head;
        while(i<idx-1){
            temp=temp.next;
            i++;
        }
        Node newNode=new Node(data);
        newNode.next=temp.next;
        temp.next=newNode;
        size++;
    }
    public int removeFirst(){
        if(size==0){
            System.out.println("LL is Empty");
            return Integer.MIN_VALUE;
        }
        else if(size==1){
            int val=head.data;
            head=tail=null;
            size=0;
            return val;
        }
        int val=head.data;
        head=head.next;
        size--;
        return val;
    }
    public int removeLast(){
        if(size==0){
            return Integer.MIN_VALUE;
        }
        else if(size==1){
            int val=tail.data;
            head=tail=null;
            size=0;
            return val;
        }
        Node temp=head;
        for(int i=0;i<size-2;i++){
            temp=temp.next;
        }
        int val=tail.data;
        temp.next=null;
        tail=temp;
        size--;
        return val;

    }
    public int iterativeSearch(int key){
        int i=0;
        Node temp=head;
        while(temp!=null){
            if(temp.data==key){
                return i;
            }
            temp=temp.next;
            i++;
        }
        return Integer.MIN_VALUE;
    }
    public int helper(Node head,int key){
        if(head==null){
            return -1;
        }
        if(head.data==key){
            return 0;
        }
        int idx=helper(head.next,key);
        if(idx==-1){
            return -1;
        }
        return idx+1;
    }
    public int recursiveSearch(int key){
        return helper(head,key);
    }
    public void reverse(){
        Node prev=null;
        Node curr=tail=head;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
    }

    //Question Problem-1-Delteting Nth node from end
    public void deleteFromEnd(int n){
        //calculating size
        int sz=0;
        Node temp=head;
        while(temp!=null){
            temp=temp.next;
            sz++;
        }
        if(n==sz){
            head=head.next;
            return;
        }
        //For size=n
        int i=1;
        int iToFind=sz-n;
        Node prev=head;
        while(i<iToFind){
            prev=prev.next;
            i++;
        }
        prev.next=prev.next.next;
        return;
        
    }
    //Question 2-Checking if a LL is Palindrome

    //Finding mid usinf fast slow pointers or turtle hare approach
    public Node findMid(Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;  //Slow is the midNOde

    }
    public boolean checkPalindrome(){
        if(head==null || head.next==null){
            return true;
        }
        //Find Mid
        Node midNode=findMid(head);
        
        //Reverse second half
        Node prev=null;
        Node curr=midNode;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        Node right=prev; //Right half ka head
        Node left=head;


        //Check First half & Second half
        while(right!=null){
            if(left.data!=right.data){
                return false;
            }
            left=left.next;
            right=right.next;
        }
        return true;
    }

    //Question Find Cycle in A linked List using Floyd's Cycle Finding Algorithm
    public static boolean isCycle(){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
            
        }
        return false;
    }

    //Question Remove Cycle in a LL
    public static void removeCycle(){
        //detect cyle
        Node slow=head;
        Node fast=head;
        boolean flag=false;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                flag=true;
                break;
            }
        }
        if(flag==false){
            return;
        }

        //Finding meeting Point
        slow=head;
        Node prev=null; //last node
        while(slow!=fast){
            prev=fast;
            slow=slow.next;
            fast=fast.next;
        } 
        //Remove cycle
        prev.next=null;
    }
    public static void main(String args[]){
        LinkedList ll=new LinkedList(); 
        System.out.println(ll.iterativeSearch(5)); 
        head=new Node(1);
        Node temp=new Node(2);
        head.next=temp;
        head.next.next=new Node(3);
        head.next.next.next=temp;
        System.out.println(isCycle());
        removeCycle();
        System.out.println(isCycle());


  
    }
}