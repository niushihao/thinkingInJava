package collection.list;

/**
 * Created by nsh on 2017/7/14 0014.
 */
public class Node {

    Node before;
    Object self;
    Node affter;

    public Node() {
    }

    public Node(Node before, Object self, Node affter) {
        this.before = before;
        this.self = self;
        this.affter = affter;
    }
}
