/**
 * @author Anirudh Sharma
 * 
 * Given a binary tree, write an iterative and recursive solution to traverse the tree using inorder traversal.
 */
const inorderTraversalRecursively = (root) => {
    // Base case
    if (root == null) {
        return;
    }
    inorderTraversalRecursively(root.left);
    console.log(root.data);
    inorderTraversalRecursively(root.right);
};

const inorderTraversalIteratively = (root) => {
    // Stack to store the nodes
    const nodes = [];
    // Take the reference of the root node in
    // the temp variable
    let temp = root;
    while (nodes.length > 0 || temp !== null) {
        if (temp !== null) {
            nodes.push(temp);
            temp = temp.left;
        } else {
            temp = nodes.pop();
            console.log(temp.data);
            temp = temp.right;
        }
    }
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
    console.log("Recursively:");
    inorderTraversalRecursively(root);
    console.log("Iteratively:");
    inorderTraversalIteratively(root);
    console.log();

    root = new Node(10);
    root.left = new Node(20);
    root.right = new Node(30);
    root.left.left = new Node(40);
    root.left.right = new Node(60);
    console.log("Recursively:");
    inorderTraversalRecursively(root);
    console.log("Iteratively:");
    inorderTraversalIteratively(root);
    console.log();

    root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    console.log("Recursively:");
    inorderTraversalRecursively(root);
    console.log("Iteratively:");
    inorderTraversalIteratively(root);
    console.log();
};

main();