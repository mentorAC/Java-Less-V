public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(3);
        list.add(5);
        list.add(8);
        list.addFront(2);
        list.Print();
        System.out.println();
        list.removeFront();
        list.Print();
        System.out.println();
        list.removeBack();
        list.Print();
        System.out.println();
        list.Find(5);
        int result= list.Find(5);
        System.out.println(result);
        System.out.println(list.Contains(3));





    }
}
 class Node{
    public int data;
    Node next;
    Node(int value){
        data = value;
    }
}
class LinkedList {
    public Node head;
    public int size;

    public void add(int value) {
        if (head == null) {
            head = new Node(value);
            size++;
            return;
        }
        Node karetka = head;
        while (karetka.next != null) {

            karetka = karetka.next;
        }
        karetka.next = new Node(value);
        size++;
    }

    public void Print() {
        Node karetka = head;
        while (karetka != null) {
            System.out.print(karetka.data + " -> ");

            karetka = karetka.next;

        }
    }

    public void addFront(int value) {
        Node front = new Node(value);
        front.next = head;
        head = front;

    }

    public void removeFront() {
        if (head == null) {
            return;
        }
        head = head.next;

    }

    public void removeBack() {
        Node karetka = head;
        if (karetka == null || karetka.next == null) {
            return;
        }
        while (karetka.next.next != null) {

            karetka = karetka.next;
        }

        karetka.next = null;
    }

    public int Find(int value) {
        Node karetka = head;
        int counter = 0;
        while (karetka.next != null) {
            counter++;
            karetka = karetka.next;
            if (karetka.data == value) {
                return counter;
            }
        }
        return -1;


    }

    public boolean Contains(int value) {
        Node karetka = head;
        while (karetka != null) {
            if (karetka.data == value) {
                return true;
            }
            karetka = karetka.next;
        }
        return false;
    }
}
