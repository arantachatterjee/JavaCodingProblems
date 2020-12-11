import java.util.*;

class FindAllTreePaths {
    public static List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        // TODO: Write your code here
        List<Integer> curPath = new ArrayList<>();
        findPath(root, sum, curPath, allPaths);
        return allPaths;
    }

    public static void findPath(TreeNode root, int sum, List<Integer> curPath, List<List<Integer>> allPaths) {
        if (root == null)
            return;

        curPath.add(root.val);

        if (root.val == sum && root.left == null && root.right == null)
            allPaths.add(new ArrayList<>(curPath));
        else {
            findPath(root.left, sum - root.val, curPath, allPaths);
            findPath(root.right, sum - root.val, curPath, allPaths);
        }

        curPath.remove(curPath.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        List<List<Integer>> result = FindAllTreePaths.findPaths(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }
}
