/**
 * @author Anirudh Sharma
 * 
 * Given a binary tree, the task is to create a new binary tree which is a mirror image of
 * the given binary tree.
 */
const mirror = (root) => {
    // Base case
    if (root === null) {
        return null;
    }
    // Get left and right children of the node
    let left = mirror(root.left);
    let right = mirror(root.right);
    // Swap the nodes
    root.right = left;
    root.left = right;
    return root;
};

const inorderTraversal = (node) => {
    if (node === null) {
        return;
    }
    inorderTraversal(node.left);
    console.log(node.data + " ");
    inorderTraversal(node.right);
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
    inorderTraversal(mirror(root));
    console.log();

    root = new Node(10);
    root.left = new Node(20);
    root.right = new Node(30);
    root.left.left = new Node(40);
    root.left.right = new Node(60);
    inorderTraversal(mirror(root));
    console.log();

    root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    inorderTraversal(mirror(root));
    console.log();
};

main();