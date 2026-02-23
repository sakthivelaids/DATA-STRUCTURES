class node{
    int data;
    node left;
    node right;
    node (int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
class tree {
    node root;
    void insert (int data) {
        node newnode = new node(data);
        if(root == null) {
            root = newnode;
            return;
        }
        node []que = new node[100];
        int front = 0,rear = 0;
        que[rear++] = root;

        while(front < rear) {
            node temp = que[front++];
            if(temp.left == null) {
                temp.left = newnode;
                return;
            }else {
                que[rear++] = temp.left;
            }
            if(temp.right == null) {
                temp.right = newnode;
                return;
            }else{
                que[rear++] = temp.right;
            }
        }
    }
    //left,root,right;
    void Inorder(node root) {
        if(root == null) return ;
        Inorder(root.left);
        System.out.print(root.data + " ");
        Inorder(root.right);
    }
    //root,left,right;
    void PostOrder(node root) {
        if(root == null) return;
        System.out.print(root.data+ " ");
        PostOrder(root.left);
        PostOrder(root.right);
    }
    //left,right,root;
    void PreOrder(node root) {
        if(root == null) return;
        PreOrder(root.left);
        PreOrder(root.right);
        System.out.print(root.data+" ");
    }
}
public class BinaryTree {
    public static void main(String[] args) {
        tree tree1 = new tree();
        tree1.insert(10);
        tree1.insert(20);
        tree1.insert(30);
        tree1.insert(40);
        tree1.insert(50);
        tree1.insert(60);
        tree1.insert(70);

        tree1.Inorder(tree1.root);
        System.out.println();
        tree1.PostOrder(tree1.root);
        System.out.println();
        tree1.PreOrder(tree1.root);
    }
}
