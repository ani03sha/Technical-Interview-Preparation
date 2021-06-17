/**
 * @author Anirudh Sharma
 * 
 * Given a Binary Tree, find size of the Largest Independent Set(LIS) in it.
 * 
 * A subset of all tree nodes is an independent set if there is no edge between any
 * two nodes of the subset.
 */
const largestIndependentSet = (root) => {
    // Special cases
    if (root === null) {
        return 0;
    }
    if (root.lis !== 0) {
        return root.lis;
    }
    if (root.left === null && root.right === null) {
        return root.lis = 1;
    }
    // LIS if we exclude current node
    let exclude = largestIndependentSet(root.left) + largestIndependentSet(root.right);
    // LIS if we include current node
    let include = 1;
    if (root.left !== null) {
        include += largestIndependentSet(root.left.left) + largestIndependentSet(root.left.right);
    }
    if (root.right !== null) {
        include += largestIndependentSet(root.right.left) + largestIndependentSet(root.right.right);
    }
    return Math.max(include, exclude);
};

function TreeNode(data, horizontalDistance, left, right) {
    this.data = (data === undefined ? 0 : data);
    this.lis = 0;
    this.left = (left === undefined ? null : left);
    this.right = (right === undefined ? null : right);
}

const main = () => {
    let root = new TreeNode(20);
    root.left = new TreeNode(8);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(12);
    root.left.right.left = new TreeNode(10);
    root.left.right.right = new TreeNode(14);
    root.right = new TreeNode(22);
    root.right.right = new TreeNode(25);
    console.log(largestIndependentSet(root));
};

main();