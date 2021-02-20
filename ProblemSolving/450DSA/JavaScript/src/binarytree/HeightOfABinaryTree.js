/**
 * @author Anirudh Sharma
 * 
 * Given a binary tree, find its height.
 * 
 * Constraints:
 * 1 <= Number of nodes <= 10^5
 * 1 <= Data of a node <= 10^5
 */
const getHeight = (root) => {
    // Special case
    if (root === null) {
        return 0;
    }
    // Get the height of the left subtree
    let leftHeight = getHeight(root.left);
    // Get the height of the right subtree
    let rightHeight = getHeight(root.right);
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
    console.log(getHeight(root));

    root = new Node(10);
    root.left = new Node(20);
    root.right = new Node(30);
    root.left.left = new Node(40);
    root.left.right = new Node(60);
    console.log(getHeight(root));
};

main();