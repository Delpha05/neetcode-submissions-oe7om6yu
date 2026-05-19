/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if(root == null)
            return 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        dfs(root, pq, k);

        return pq.poll();
    }

    private void dfs(TreeNode node, PriorityQueue<Integer> pq, int k){
        if(node == null)
            return;
        
        pq.offer(node.val);
        if(pq.size() > k)
            pq.poll();
        
        dfs(node.left, pq, k);
        dfs(node.right, pq, k);
    }
}
