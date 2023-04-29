package testprac;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.*;
import java.util.*;
import java.io.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;



public class GrammerSkillsTest {
    @Test
    public void arrayTest() {
        int [] arr1 ;
        int [] arr2 = new int[5]; // [0,0,0,0]
        int [] arr3 = new int[10];
        Arrays.fill(arr3,10); // [10,10,10,,,]
        float[] arr4 = new float[10];
        System.out.println(arr4[3]);

    }
    @Test
    void arrayListHandleTest() {
//        Array.push    -> ArrayList.add(Object o); // Append the list
//        Array.pop     -> ArrayList.remove(int index); // Remove list[index]
//        Array.shift   -> ArrayList.remove(0); // Remove first element
//        Array.unshift -> ArrayList.add(int index, Object o); // Prepend the list
    }

    @Test
    public void arrayToArrayListTest() {

        ArrayList<Integer> givenList = new ArrayList<>(Arrays.asList(3, 6,7,2, 1));
        Collections.sort(givenList);
        System.out.println(givenList);
        givenList.sort(Collections.reverseOrder());
        System.out.println(givenList); // [7, 6, 3, 2, 1]



        int[] answer1 = {1,4,1,4,5};
        Arrays.sort(answer1);
        Collections.reverse(Arrays.asList(answer1));

        int[] answer = {1,2,3,4,5};
        List<Integer> arr = new ArrayList<>(Arrays.stream(answer).boxed().collect(Collectors.toList()));
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

        List<Integer> arrList = new ArrayList<>(Arrays.stream(items).boxed().collect(Collectors.toList()));

        int[] intAnswer = arrList.stream().mapToInt(Integer::intValue).toArray();

        // given
        String[] stringAnswer = arrList.stream()
                .map(Object::toString)
                .toArray(String[]::new);


        Assertions.assertThat(arrList.size()).isEqualTo(intAnswer.length);

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
    @Test
    public void set_test(){
        // Set can't have a same value
        Set<String> set = new HashSet<>();
        Set<String> setEx1 = new TreeSet<>();
        Set<String> setEx2 = new LinkedHashSet<>();

        set.add("1");
        set.add("2");
        set.add("6");
        set.add("3");
        System.out.println(set);

        Iterator<String> it = set.iterator(); // 검색을 위한 반복자 생성
        while(it.hasNext()){
            System.out.println(it.next());
        }
        set.remove("1");
        System.out.println(set);
        it = set.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }

    @Test
    void hashSet_test(){
        Map<String, Integer> hm = new HashMap<String, Integer>();

        // put 메서드 이용 key와 value 추가
        hm.put("A", 90);
        hm.put("B", 80);
        hm.put("C", 80);
        hm.put("D", 60);

        // size 메서드 이용 저장된 객체 수 출력
        System.out.println("저장된 객체 수 : " + hm.size());

        // get 메서드로 특정 key에 해당하는 값 출력
        System.out.println("D의 값 : " + hm.get("D"));

        // 동일한 key로 추가(기존 내용 삭제)
        hm.put("C", 70);
        System.out.println("-------------------");

        // keySet 메서드 이용 저장된 모든 key 값을 Set 컬렉션에 저장
        Set<String> keys = hm.keySet();

        // 반복자 생성
        Iterator<String> it = keys.iterator();
        while (it.hasNext()) {
            String key = it.next(); // Set의 key 값을 하나씩 key에 대입
            int value = hm.get(key); // 해당 key에 해당하는 value 대입 / 오토 언박싱
            System.out.println(key + " : " + value);
        }
    }
    @Test
    void string_replace_kako_test(){
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}" ;
        String preString = s.substring(2,s.length()-2);
        preString = preString.replace("{","");

        List<String> preList = new ArrayList(Arrays.asList(preString.split("},")));
        List<List<Integer>> preIntList = new ArrayList();
        for(String item :preList){
            List<Integer> innerList = new ArrayList();
            for(String is : item.split(",")){
                innerList.add(Integer.parseInt(is));
            }
            preIntList.add(innerList);
        }


        preIntList.sort(Comparator.comparingInt(List::size));


        List<Integer> ansList = new ArrayList();
        for(List<Integer> iteml: preIntList){
            for(Integer item: iteml){
                if(!ansList.contains(item)){
                    ansList.add(item);
                }
            }
        }

        int [] answer = new int [ansList.size()];

        for(int i = 0 ; i < ansList.size();i++){
            answer[i] = ansList.get(i);
        }

    }
    @Test
    void string_replace_kako_test2(){
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}" ;
        List<List<Integer>> intList = Arrays.stream(s.substring(2, s.length() - 2).split("\\},\\{"))
                .map(str -> Arrays.stream(str.split(",")).map(Integer::parseInt).collect(Collectors.toList()))
                .sorted(Comparator.comparingInt(List::size))
                .collect(Collectors.toList());
        System.out.println(intList);
        List<Integer> ansList = intList.stream()
                .flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(ansList);
        int [] answer = ansList.stream().mapToInt(Integer::intValue).toArray();

        for (int i =0 ;i<answer.length ; i++) {
            System.out.println(answer[i]);
        }
    }
    @Test
    void fail_ratio_problem_test() {
        int[] answer = new int[5];

//        System.out.println(answer[-1]);

        for (int i = 0; i < 5; i++) {

            System.out.println(i);
        }


    }
    @Test
    void test_coding_turn(){
            int[][] image = new int[10][10] ;

                int n = image.length;

                int[][] imageRight = new int[n][n];
                int[][] imageDown = new int[n][n];
                int[][] imageCross = new int[n][n];

                for (int i =0 ; i<n;i++){
                    for (int j =0 ; j < n;j++){
                        imageRight[i][n-1-j]=image[i][j];
                        imageDown[n-1-i][j]=image[i][j];
                        imageCross[n-1-i][n-1-j] =image[i][j];
                    }
                }

                int[][] answer = new int[2*n][2*n];


                for(int i = 0;i<n;i++){
                    for (int j =0 ; j < n;j++){
                        answer[i][j] = image[i][j];
                    }
                }

                for(int i = n;i<2*n;i++){
                    for (int j =0 ; j < n;j++){
                        answer[i][j] = imageDown[i-n][j];
                    }
                }

                for(int i = 0;i<n;i++){
                    for (int j =n ; j < 2*n;j++){
                        answer[i][j] = imageRight[i][j-n];
                    }
                }

                for(int i = n;i<2*n;i++){
                    for (int j =n ; j < 2*n;j++)
                    {
                        answer[i][j] = imageCross[i-n][j-n];
                    }
                }
    }

}






















