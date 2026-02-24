import java.util.Scanner;

class node {
    int data;
    node right;
    node left;
    node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
    

public class BinarySearchTree {
    node root = null;
    node temp = null;
    void insert(int data) {
        node newnode =new node(data);
        if(root == null) {
            root = newnode;
            return;
        }else{
            temp = root;
            while(true) {
                if(temp.data > newnode.data) {
                    if(temp.left == null) {
                        temp.left = newnode;
                        break;
                    }else{
                        temp = temp.left;
                    }
                }else{
                    if(temp.right == null) {
                        temp.right = newnode;
                        break;
                    }else{
                        temp = temp.right;
                    }
                }
            }
        }
    }
    void Inorder(node root) {
        if(root == null) return;
        Inorder(root.left);
        System.out.print(root.data+ " ");
        Inorder(root.right);
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BinarySearchTree bt = new BinarySearchTree();
        while(true) {
            int data = scan.nextInt();
            if(data == -1) break;
            bt.insert(data);
        }
        bt.Inorder(bt.root);
    }
}
