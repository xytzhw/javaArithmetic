package tree.binarytree;


import java.util.Stack;

public class BinaryTree {
    /**
     * 树节点
     */
    public class TreeNode{
        private int index;//下标(标注当前节点是第几个节点)
        private String data;//树节点存储的数据
        private TreeNode leftChild;//当前节点的左孩子
        private TreeNode rightChild;//当前节点的右孩子

        public TreeNode(int index,String data){
            this.index = index;
            this.data = data;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }
    }

    private TreeNode root = null;

    /**
     * 利用构造器先生成根节点
     */
    public BinaryTree(){
        root = new TreeNode(1,"A");
    }
    /**
     * 构造简单的二叉树,结构如下
     *            A
     *       B        C
     *   D       E         F
     */
    public void createBinaryTree(){
        TreeNode nodeB = new TreeNode(2,"B");
        TreeNode nodeC = new TreeNode(3,"C");
        TreeNode nodeD = new TreeNode(4,"D");
        TreeNode nodeE = new TreeNode(5,"E");
        TreeNode nodeF = new TreeNode(6,"F");
        root.leftChild = nodeB;
        root.rightChild = nodeC;
        nodeB.leftChild = nodeD;
        nodeB.rightChild = nodeE;
        nodeC.rightChild = nodeF;
    }

    /**
     * 求树的高
     */
    public int getHeight(){
        return getHeight(root);
    }
    public int getHeight(TreeNode node){
        if(node == null){
            return 0;
        }else{
            int i = getHeight(node.leftChild);
            int j = getHeight(node.rightChild);
            return (i<j) ? j+1 : i+1;
        }
    }

    /**
     * 获取二叉树的节点数
     */
    public int getSize(){
        return getSize(root);
    }
    public int getSize(TreeNode node){
        return 1+getSize(node.leftChild)+getSize(node.rightChild);
    }

    /**
     * 前序排列（根左右）-遍历
     */
    public void preOrder(TreeNode node){
        if(node == null){
            return;
        }else{
            System.out.println("preOrder data:"+node.getData());
            preOrder(node.leftChild);
            preOrder(node.rightChild);
        }
    }

    /**
     * 前排序-非遍历
     */
    public void nonRecOrder(TreeNode node){
        if(node == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()){
            //出栈和进栈
            TreeNode n = stack.pop();
            //压入子节点
            System.out.println("nonRecOrder data:"+n.getData());
            if(n.rightChild!=null){
                stack.push(n.rightChild);
            }
            if(n.leftChild!=null){
                stack.push(n.leftChild);
            }
        }
    }
}