package 二叉运算树;

public class BinaryTree {
    public TreeNode root;
    public BinaryTree(char[] ch,int index){
        root=create(ch,index);
    }
    //添加元素
    public void add(int data){
        TreeNode newNode=new TreeNode(data);
        if(root==null){
            root=newNode;
            return;
        }
        TreeNode cur=root;
        while(true){
            if(newNode.value<cur.value){
                if(cur.left==null){
                    cur.left=newNode;
                    return;
                }else {
                    cur=cur.left;
                }
            }else{
                if(cur.right==null){
                    cur.right=newNode;
                    return;
                }else{
                    cur=cur.right;
                }
            }
        }
    }
    //将数组表示法转换为链表表示法
    public TreeNode create(char[] arr,int index){
        if(index>=arr.length){
            return null;
        }else{
            TreeNode tmpNode=new TreeNode((int)(arr[index]));
            tmpNode.left=create(arr,2*index);
            tmpNode.right=create(arr,2*index+1);
            return tmpNode;
        }
    }
    //判断表达式如何运算的方法声明
    public int condition(char ch,int n1,int n2){
        switch(ch){
            case '+': return n1+n2;
            case '-': return n1-n2;
            case '*': return n1*n2;
            case '/': return n1/n2;
            case '%': return n1%n2;
            default: return -1;
        }
    }
    //计算二叉运算树的值
    public int answer(TreeNode root){
        int first=0;
        int second=0;
        if(root.left==null&&root.right==null){
            return Character.getNumericValue((char)root.value);
        }else{
            first=answer(root.left);
            second=answer(root.right);
            return condition((char)root.value,first,second);
        }
    }
    //前序遍历
    public void inOrder(TreeNode root){
        if(root!=null){
            inOrder(root.left);
            System.out.print((char)root.value+" ");
            inOrder(root.right);
        }
    }
    //后序遍历
    public void postOrder(TreeNode root){
        if(root!=null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print((char)root.value+" ");
        }
    }
    //后序遍历
    public void preOrder(TreeNode root){
        if(root!=null){
            System.out.print((char)root.value+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
}
