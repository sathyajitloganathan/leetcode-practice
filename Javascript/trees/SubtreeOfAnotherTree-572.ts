/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     val: number
 *     left: TreeNode | null
 *     right: TreeNode | null
 *     constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.left = (left===undefined ? null : left)
 *         this.right = (right===undefined ? null : right)
 *     }
 * }
 */

 function isSubtree(root: TreeNode | null, subRoot: TreeNode | null): boolean {
    function traverse(r: TreeNode | null) {
        if (r == null) {
            return false;
        } else if (subRoot == null) {
            return true;
        }

        if (compareTrees(r, subRoot)) {
            return true;
        } else {
            return traverse(r.left) || 
            traverse(r.right);
        }

        // return false;
    }

    function compareTrees(p: TreeNode | null, q: TreeNode | null) {
        if (p == null && q == null) {
            return true;
        } else if (p && q && p.val == q.val) {
            return compareTrees(p.left, q.left) && compareTrees(p.right, q.right);
        }
        return false;
    }

    return traverse(root);

};