package testprac;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.*;
import java.util.*;
import java.io.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;



public class GrammerSkillsTest {

    @Test
    public void arrayListTest() {

        ArrayList<Integer> givenList = new ArrayList<>(Arrays.asList(3, 6,7,2, 1));
        givenList.sort(Collections.reverseOrder());
        System.out.println(givenList); // [7, 6, 3, 2, 1]


        int[] answer = {1,2,3,4,5};
        int[] answer1 = {1,4,1,4,5};

        Arrays.sort(answer1);
        for (int item:answer) {
            System.out.print(item);
            System.out.print(" ");
        }
        System.out.println(" ");

        Collections.reverse(Arrays.asList(answer1));


        List<Integer> arr = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        List<Integer> answerToListInt = Arrays.stream(answer).boxed().toList();

        Assertions.assertThat(arr).isEqualTo(answerToListInt);
    }

    @Test
    public void splitTest() {
        int value = 123;
        while (value != 0) {
            System.out.println(value % 10);
            value /= 10;

        }
        String str = "CADB";

        str = Stream.of(str.split(""))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining());
        System.out.println(str);
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
    @Test
    void sub_listTest(){
        int[] answer = {1,2,3};
        List<Integer> arr = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        List<Integer> subList = arr.subList(2,arr.size());
        List<Integer> answerToListInt = new ArrayList<>(Arrays.stream(answer).boxed().collect(Collectors.toList()));
        assertArrayEquals(answer,answerToListInt.stream().mapToInt(i->i).toArray());

    }

    private void readList(List anyList) {
        anyList.stream().forEach(System.out::println);
    }

    @Test
    public void list_handle_Test() {
        int[] items = {1, 2, 3, 4, 5, 6};

        ArrayList<Integer> arrList = new ArrayList<>();

        for (int item : items) {
            arrList.add(item);
        }

        for (int i = 0; i < items.length; i++) {
            arrList.add(items[i]);
        }

        // given
        String[] answer = arrList.stream()
                .map(Object::toString)
                .toArray(String[]::new);

        Assertions.assertThat(arrList.size()).isEqualTo(answer.length);

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
    public void dijkstra() {
        int[][] graphGiven = {
                {0, 1, 1, 0, 0},
                {1, 0, 0, 1, 1},
                {1, 0, 0, 1, 0},
                {0, 1, 1, 0, 1},
                {0, 1, 0, 1, 0}
        };
        List<List<Node>> graph = new ArrayList<>();
        int n = graphGiven.length;
        for(int i = 0 ; i<n ; i++){
           List<Node> neighbors = new ArrayList<>();
           for(int j = 0 ; j < n ; j++){
               if(graphGiven[i][j] == 1){
                   neighbors.add(new Node(j,1));
               }
           }
           graph.add(neighbors);
        }


        int src = 0;
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

        int [] expect = {0,1,1,2,2};

        assertArrayEquals(expect,dist);
        Assertions.assertThat(expect).isEqualTo(dist);
    }

    @Test
    public void integer_class_method_Test() {
        int number = 9 ;
        int numberSec = 30 ;
        String showBinary = Integer.toBinaryString(number);

        String showSecondBinary = Integer.toBinaryString(number|numberSec);
        System.out.println("show Second Binary:"+showSecondBinary);

        String showBinaryFormated = String.format("%8s",showBinary).replace(" ","0");
        System.out.println(showBinaryFormated);
        String showString   = Integer.toString(number);
        System.out.println(showString);
        int showInt = Integer.parseInt(showString);
        System.out.println(showInt);
        assertEquals(showInt, number);
        Assertions.assertThat(showInt).isEqualTo(number);
    }
    @Test
    public void readerReadTest() throws IOException {
        // Set up a BufferedReader with some input data
//        String inputData = "Hello, World!\nHow are you?\n";
//        BufferedReader br = new BufferedReader(new StringReader(inputData));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

    }
    @Test
    public void devide_test() {
        int num = 2 ;
        int leftE = num % 2 ;
        num = 3 ;
        int leftO = num % 2 ;

        int expectEven = 0;
        int expectOdd = 1;

        Assertions.assertThat(leftE).isEqualTo(expectEven);
        Assertions.assertThat(leftO).isEqualTo(expectOdd);
    }
    @Test
    public void multiple_n_test(){
        int num = 97;
        int n = 2 ;
        if (num % n == 0) {
            System.out.println("b");
        }
    }
}






















