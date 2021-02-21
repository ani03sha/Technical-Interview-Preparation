/**
 * @author Anirudh Sharma
 * 
 * Given a Binary Tree, find diameter of it.
 * The diameter of a tree is the number of nodes on the longest path between two end nodes in the tree.
 * 
 * Constraints:
 * 1 <= Number of nodes <= 10000
 * 1 <= Data of a node <= 1000
 */
const diameter = (root) => {
    // Base case
    if (root === null) {
        return 0;
    }
    // Heights of left and right subtrees
    let leftHeight = height(root.left);
    let rightHeight = height(root.right);
    // Diameters of left and right subtrees
    let leftDiameter = diameter(root.left);
    let rightDiameter = diameter(root.right);

    return Math.max((leftHeight + rightHeight + 1), Math.max(leftDiameter, rightDiameter));
};

const height = (root) => {
    // Special case
    if (root === null) {
        return 0;
    }
    // Get the height of the left subtree
    let leftHeight = height(root.left);
    // Get the height of the right subtree
    let rightHeight = height(root.right);
    // Return the max of left subtree height
    // and right subtree height plus 1 for root
    return 1 + Math.max(leftHeight, rightHeight);
};

function Node(data, left, right) {
    this.data = (data === undefined ? 0 : data);
    this.left = (left === undefined ? null : left);
    this.right = (right === undefined ? null : right);
}

const main = () => {
    let root = new Node(1);
    root.left = new Node(3);
    root.right = new Node(2);
    console.log(diameter(root));

    root = new Node(10);
    root.left = new Node(20);
    root.right = new Node(30);
    root.left.left = new Node(40);
    root.left.right = new Node(60);
    console.log(diameter(root));

    root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    console.log(diameter(root));
};

main();