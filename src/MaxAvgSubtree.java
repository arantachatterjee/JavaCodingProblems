import java.util.*;

public class MaxAvgSubtree {

    double maxAvg = 0;
    // Map holds root values
    List<Integer> descendents = new LinkedList<>();

    public double maximumAverageSubtree(TreeNode root) {
        DFS (root.right, root);
        DFS (root.left, root);
        return maxAvg;
    }

    public void DFS (TreeNode subTreeRoot, TreeNode root) {

        // Return if root has been reached
        if (subTreeRoot == null || root == null) return;
        else {
            DFS(subTreeRoot.left, root);
            DFS(subTreeRoot.right, root);
        }

        descendents.add(subTreeRoot.val);

        if (subTreeRoot.right == null && subTreeRoot.left == null) { // Leaf node
            if (maxAvg < subTreeRoot.val) maxAvg = subTreeRoot.val; // Update max average value
        } else { // Non-leaf nodes
            double count = descendents.size(); // Get Average
            double avg = 0.0;
            for (Integer val : descendents) {
                avg += (double)val;
            }
            avg = avg/count;
            if (maxAvg < avg) maxAvg = avg;

            if(subTreeRoot == root)
                return;
        }
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}