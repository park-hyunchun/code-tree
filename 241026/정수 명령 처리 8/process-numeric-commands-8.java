import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    static Node head = null;
    static Node tail = null;
    static int size = 0;

    static class Node {
        Node prev;
        int data;
        Node next;

        public Node (Node prev, int data, Node next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int num;
            switch(command) {
                case "push_front":
                    num = Integer.parseInt(st.nextToken());
                    pushFront(num);
                    break;
                case "push_back":
                    num = Integer.parseInt(st.nextToken());
                    pushBack(num);
                    break;
                case "pop_front":
                    popFront();
                    break;
                case "pop_back":
                    popBack();
                    break;
                case "size":
                    System.out.println(size);
                    break;
                case "empty":
                    System.out.println(size == 0 ? 1 : 0);
                    break;
                case "front":
                    front();
                    break;
                case "back":
                    back();
                    break; 
            }

        }
        
    }

    private static void pushFront(int num) {
        Node node = new Node(null, num, head);
        if (head != null) {            
        	head.prev = node;
        }
        
        head = node;
        size++;
        
        if (head.next == null) {
        	tail = head;
        }
    }

    private static void pushBack(int num) {
        Node node = new Node(tail, num, null);
        if (size == 0) {
            pushFront(num);
            return;
        }
        tail.next = node;
        node.prev = tail;
        tail = node;
        size++;
    }

    private static void popFront() {
        Node result = head;
        if (result.next != null) {        	
        	result.next.prev = null;
        }
        head = result.next;
        size--;
        if (size == 0) {
        	tail = null;
        }
        System.out.println(result.data);
    }

    private static void popBack() {
        Node result = tail;
        if (result.prev != null) {        	
        	result.prev.next = null;
        }
        tail = result.prev;
        size--;
        if (size == 0) {
        	head = null;
        }
        System.out.println(result.data);
    }

    private static void front() {
        System.out.println(head.data);
    }

    private static void back() {
        System.out.println(tail.data);
    }
}