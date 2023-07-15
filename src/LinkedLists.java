public class LinkedLists {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static void insert(LinkedLists lists, int data) {
        Node new_node = new Node(data);
        if (lists.head == null) {
            lists.head = new_node;
        } else {
            Node last = lists.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_node;
        }
    }

    public static void printList(LinkedLists lists) {
        Node currentNode = lists.head;
        if (currentNode == null) {
            System.out.println("Empty linked list");
        } else {
            while (currentNode != null) {
                System.out.print(currentNode.data + " ");
                currentNode = currentNode.next;
            }
        }
        System.out.println();
    }

    public static void delete(LinkedLists lists, int deleteValue) {
        Node currentNode = lists.head;
        Node previousNode = lists.head;
        if (currentNode == null) {
            System.out.println("Empty linked list");
        } else {
            if (currentNode.data == deleteValue) {
                lists.head = currentNode.next;
                return;
            }
            while (currentNode != null) {
                if (currentNode.data == deleteValue) {
                    previousNode.next = currentNode.next;
                    break;
                } else {
                    previousNode = currentNode;
                    currentNode = currentNode.next;
                }
            }
        }
    }

    public static void main(String[] args) {
        LinkedLists lists = new LinkedLists();
        insert(lists, 2);
        insert(lists, 3);
        insert(lists, 5);
        insert(lists, 1);
        printList(lists);
        delete(lists, 2);
        printList(lists);
        delete(lists, 1);
        printList(lists);
        delete(lists, 3);
        printList(lists);
        delete(lists, 5);
        printList(lists);
    }
}
