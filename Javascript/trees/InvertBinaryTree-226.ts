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

class TreeNode {
    val: number;
    left: TreeNode | null;
    right: TreeNode | null;

    constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
        this.val = val === undefined ? 0 : val;
        this.left = left === undefined ? null : left;
        this.right = right === undefined ? null : right;
    }
}


//                                        (6)
//                  (4)                                            (21)
//     (8)                       (111)                   (2)                      (1)
// (null)      (155)              (143)         (654)         (445)       (5)           (766)          (987)


//                                         (6)
//                  (21)                                            (4)
//     (111)                       (8)                   (2)                      (1)
// (null)      (155)              (143)         (654)         (445)       (5)           (766)          (987)


function invertTree(root: TreeNode | null): TreeNode | null {
    if (root == null) {
        return root;
    }

    let tmp = root.left;
    root.left = root.right;
    root.right = tmp;

    invertTree(root.left);
    invertTree(root.right);

    return root;
}
