import java.util.Scanner;

public class Main {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    public static class Pair{
        int a  = 0 ;
        int b = 0 ;
        
    }
    public static int HouseRobber(TreeNode root) {
     
       Pair ans =   HouseRobber_(root); 
       return Math.max(ans.a , ans.b);
    }
     public static Pair HouseRobber_(TreeNode root) {
       if(root == null)
       {
           return new Pair();
       }
       Pair left = HouseRobber_(root.left) ;
       Pair right = HouseRobber_(root.right) ;
       Pair myPair = new Pair();
       int without = Math.max(left.a , left.b) + Math.max(right.a , right.b);
       int with = root.val + left.b + right.b ;
       myPair.a = with ;
       myPair.b = without ;
       return myPair;
    }
    // input_Section_====================================================================

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1){
            IDX[0]++;
            return null;
        }

        TreeNode node = new TreeNode(arr[IDX[0]++]);
        node.left = createTree(arr, IDX);
        node.right = createTree(arr, IDX);

        return node;
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);
        System.out.println(HouseRobber(root));
    }

    public static void main(String[] args) {
        solve();
    }
}
