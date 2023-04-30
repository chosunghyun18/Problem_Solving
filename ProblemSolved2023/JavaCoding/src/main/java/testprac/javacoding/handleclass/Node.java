package testprac.javacoding.handleclass;


import lombok.Getter;

@Getter
public class Node {

    private static final int KOR_CODE = 1245;
    private static final String NODE_SPECIAL_MESSAGE = "이건 노드야";
    private final int node;
    private final int cost;
//    private final int CODE // 객체 마다 다른 값을 가지므로 상수 가 아님
    public Node(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

}
