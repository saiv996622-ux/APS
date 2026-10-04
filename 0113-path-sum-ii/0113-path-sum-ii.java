import java.util.*;

class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> result = new ArrayList<>();

        findPaths(root, targetSum, new ArrayList<>(), result);

        return result;
    }

    private void findPaths(
        TreeNode node,
        int target,
        List<Integer> path,
        List<List<Integer>> result
    ) {

        if (node == null)
            return;

        path.add(node.val);

        if (node.left == null &&
            node.right == null &&
            target == node.val) {

            result.add(new ArrayList<>(path));
        }

        findPaths(node.left, target - node.val, path, result);
        findPaths(node.right, target - node.val, path, result);

        path.remove(path.size() - 1);
    }
}