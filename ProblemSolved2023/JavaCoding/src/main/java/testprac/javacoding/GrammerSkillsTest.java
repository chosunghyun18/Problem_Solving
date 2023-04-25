package testprac.javacoding;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.io.*;

public class GrammerSkillsTest {

    @Test
    public void arrayListTest() {
        ArrayList<Integer> givenList = new ArrayList<>(Arrays.asList(3, 2, 1));
        givenList.stream().forEach(System.out::println);
    }

    @Test
    public void splitTest() {
        int value = 123;
        while (value != 0) {
            System.out.println(value % 10);
            value /= 10;

        }
    }

    @Test
    public void listTest() {
        int[] items = {1, 2, 3, 4};
        ArrayList<Integer> checkList = new ArrayList<>();
        for (int item : items) {
            checkList.add(item);
        }
        readList(checkList);

        ArrayList<Integer> givenList = new ArrayList<>(Arrays.asList(1, 2, 3));
        List arrayList = new ArrayList<>(givenList);
        List linkedList = new LinkedList(givenList);

        readList(arrayList);

        System.out.println("");
        readList(linkedList);
    }

    private void readList(List anyList) {
        anyList.stream().forEach(System.out::println);
    }

    @Test
    public void list_handle_Test() {
        int[] items = {1, 2, 3, 4, 5, 6};
        ArrayList<Integer> arrlist = new ArrayList<>();
        for (int item : items) {
            arrlist.add(item);
        }
        for (int i = 0; i < items.length; i++) {
            arrlist.add(items[i]);
        }

    }

    @Test
    public void String_handle_test() {
        String numbers = "789123";
        String[] number = numbers.split("");
        for (String n : number) {
            System.out.println(n);
        }
    }

    @Test
    public void priority_queue() {
        PriorityQueue<Integer> pql = new PriorityQueue<>();
        //PriorityQueue<Integer> priorityQueueUpper = new PriorityQueue<>(Collections.reverseOrder());


        pql.offer(20);
        pql.offer(15);
        pql.offer(10); // if capa is small return false
        pql.add(15);
        pql.add(40);
        System.out.println(pql.peek()); // get
        System.out.println(pql.poll()); // get and delete
        System.out.println(pql.peek());

    }

    static class Node {
        public int node;
        public int cost;

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }
    @Test
    public int[] dijkstra() {
        List<List<Node>> graph = new ArrayList<>();
        // src ref start point node
        int src = 0;
        int n = graph.size();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE); // fill data
        dist[src] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(n, Comparator.comparingInt(node -> node.cost));
        pq.offer(new Node(src, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int u = node.node;
            int cost = node.cost;

            if (cost != dist[u]) {
                continue;
            }

            for (Node neighbor : graph.get(u)) {
                int alt = dist[u] + neighbor.cost;
                if (alt < dist[neighbor.node]) {
                    dist[neighbor.node] = alt;
                    pq.offer(new Node(neighbor.node, alt));
                }
            }
        }

        return dist;
    }

    @Test
    public void StringHandleTest() {

    }
}






















