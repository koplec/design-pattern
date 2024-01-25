public class Main {
    public static void main(String[] args) {
        // Create a binary tree
        BinaryTree.Node root = new BinaryTree.Node(4);
        root.left = new BinaryTree.Node(2);
        root.left.left = new BinaryTree.Node(1);
        root.left.right = new BinaryTree.Node(3);
        root.right = new BinaryTree.Node(6);
        root.right.left = new BinaryTree.Node(5);
        root.right.right = new BinaryTree.Node(7);

        BinaryTree tree = new BinaryTree(root);
        //stackには、4,2,1が積まれている
        //最初に、最後に入っている1が取り出される
        //1の右側には、何もないので、次に取り出されるのは2
        //2の右側には、3があるので、3がIteratorの中でstackに積まれて、すぐにpopされる

        //BinaryTreeのことをしらなくても、適切なiteratorを実装することで、順番に値が取り出せる
        for(Integer value: tree){
            System.out.println(value);
        }
    }
}
