import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class BinaryTree implements Iterable<Integer> {
    static class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
            left = right = null;
        }
    }

    private Node root;

    public BinaryTree(Node root) {
        this.root = root;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            // stackは、ノードを格納するためのデータ構造で、FILO(First In Last Out)の構造を持つ
            Stack<Node> stack = new Stack<>();


            // push all left nodes of root
            {
                pushLeft2Stack(root);
            }

            // 与えられたノードの左側のノードをすべてスタックに積む
            // 右側のノードは積まない
            private void pushLeft2Stack(Node node) {
                
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }

            @Override
            public boolean hasNext() {
                return !stack.isEmpty();
            }

            @Override
            public Integer next(){
                if(!hasNext()){
                    throw new NoSuchElementException();
                }
                Node node = stack.pop();
                //いま取り出したnodeより右側のノードをスタックに積むので、
                //次に取り出すノードは、nodeよりも必ず大きい値になる
                pushLeft2Stack(node.right);
                return node.value;
            }
 
        };
    }

}
