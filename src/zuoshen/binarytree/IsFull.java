package zuoshen.binarytree;

public class IsFull {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static class Info {
        public int size;
        public int height;

        public Info(int s, int h) {
            size = s;
            height = h;
        }
    }

    public static boolean isFull(Node node){
        Info info = process(node);
        int size = info.size;
        int height = info.height;

        return size == (1 << height) - 1;
    }

    public static Info process(Node x){
        if (x == null) {
            return new Info(0, 0);
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        int size = leftInfo.size + rightInfo.size + 1;
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        return new Info(size, height);
    }
}
