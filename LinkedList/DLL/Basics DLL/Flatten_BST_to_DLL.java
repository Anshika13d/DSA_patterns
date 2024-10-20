/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: root of a tree
     * @return: head node of a doubly linked list
     */

    TreeNode head = null;
	  TreeNode tail = null;

    public TreeNode treeToDoublyList(TreeNode root) {
        // Write your code here.
        if(root == null) return null;
		
    		helper(root);
    
    		head.left = tail;
    		tail.right = head;
    		return head;
    }

    public void helper(TreeNode node){
  	  if(node == null) return;
  	
  	  helper(node.left);
  	
  	  if(tail != null){
      	tail.right = node;
      	node.left = tail;
      }
      else{
        head = node;
      }
    
      tail = node;
      
      helper(node.right);
  }

}
