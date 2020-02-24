class Node {
    int data;
    Node next;

    Node(int item) {
        this.data = item;
        this.next = null;
    }
}
class LinkedList {
    Node head = null;

    public void insertAtBeginning(int item) {
        Node newNode = new Node(item);

        if(head == null) {
            head = newNode;
        }
        else {
            newNode.next = head;
            head = newNode;
        }
        
    }

    public void insertAtEnd(int item) {
        Node newNode = new Node(item);
       
        if(head == null) {
            head = newNode;
        }
        else {
            Node temp = head;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void insertAtPosition(int position, int item) {
        Node newNode = new Node(item);

        if(position == 1)
            insertAtBeginning(item);
        else {
            int current = 1;
            Node temp1 = head;
            Node temp2 = head;
            while(current < position-1) {
                temp1 = temp1.next;
                temp2 = temp2.next;
                current++;
            }
            temp2 = temp2.next;
            temp1.next = newNode;
            newNode.next = temp2;
        }
    }

    public void deleteAtBeginning() {
        if(head == null) {
            System.out.println("Linked List is Empty");
        }
        else {
            head = head.next;
        }
    }

    public void deleteAtEnd() {
        if(head == null) {
            System.out.println("Linked List is Empty");
        }
        else {
            Node temp = head;
            Node previous = head;
            while(temp.next != null) {
                previous = temp;
                temp = temp.next;
            }
            previous.next = null;
        }
    }

    public void deleteAtPosition(int position) {
        if(position == 1) {
            deleteAtBeginning();
        }
        else {
            Node temp1 = head;
            Node temp2 = head;
            int current = 1;
            while(current < position-1) {
                temp1 = temp1.next;
                temp2 = temp2.next;
                current++;
            }
            temp2 = temp2.next.next;
            temp1.next = temp2;
        }
    }

    public int search(int item) {
        Node temp = head;
        int position = 1;
        while(temp != null) {
            if(temp.data == item)
                return position;
            temp = temp.next;
            position++;
        }
        return -1;
    }

    public void display() {
        Node temp = head;
        while(temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public void reverse() {
        Node previousNode, currentNode, nextNode;
        previousNode = null;
        currentNode = head;
        nextNode = head;
        while(currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        head = previousNode;
    }

    public int sizeOfList() {
        int length = 0;
        Node temp = head;
        if(head == null) {
            return length;
        }
        else {
            while(temp != null) {
                length++;
                temp = temp.next;
            }
        }
        return length;
    }
}
class SingleLinkedList {
    public static void main(String args[]) {
        LinkedList list = new LinkedList();
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);
        list.insertAtEnd(110);
        list.insertAtEnd(120);
        list.insertAtEnd(130);

        list.insertAtBeginning(50);
        list.insertAtBeginning(60);
        list.insertAtBeginning(70);

        list.insertAtPosition(3, 80);
        list.insertAtPosition(1, 90);

        list.deleteAtBeginning();
        list.deleteAtBeginning();
        
        list.deleteAtEnd();
        list.deleteAtEnd();

        list.deleteAtPosition(3);
        list.deleteAtPosition(2);

        System.out.println(list.search(20));
        System.out.println(list.search(100));
        System.out.println("-----------------------------------");

        list.display();

        list.reverse();
        System.out.println("-----------------------------------");

        list.display();
        System.out.println("Length of the List : " + list.sizeOfList());
    }
}