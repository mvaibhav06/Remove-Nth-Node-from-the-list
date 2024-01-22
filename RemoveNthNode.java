import java.util.LinkedList;

public class RemoveNthNode {

    static class Node{
        private int data;
        private Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    static class LinkedList{
        Node head;
        Node tail;

        void append(int val){
            Node temp = new Node(val);
            if (head == null){
                head = temp;
                tail = temp;
            }else {
                tail.next = temp;
                tail = temp;
            }
        }

        void printList(){
            Node temp = head;
            while (temp != null){
                System.out.print(temp.data);
                if (temp.next != null){
                    System.out.print(" -> ");
                }
                temp = temp.next;
            }
        }
    }

    public static void removeNthNode(LinkedList list, int n){
        Node slow = list.head;
        Node fast = list.head;

        for (int i=0; i<=n; i++){
            fast = fast.next;
        }

        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next.next = fast;
    }

    public static void main(String[] args) {
        LinkedList mylist = new LinkedList();
        mylist.append(1);
//        mylist.append(2);
//        mylist.append(3);
//        mylist.append(4);
//        mylist.append(5);

        mylist.printList();

        removeNthNode(mylist,1);
        System.out.println();
        mylist.printList();
    }
}
