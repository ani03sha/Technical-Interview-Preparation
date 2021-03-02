const TreeMap = require("treemap-js");
/**
 * @author Anirudh Sharma
 * 
 * Given a pointer to the root of a binary tree, print the top view of the binary tree.
 * 
 * The tree as seen from the top the nodes, is called the top view of the tree.
 * 
 * Constraints:
 * 1 <= N <= 10^5
 * 1 <= Node Data <= 10^5
 */
const topView = (root) => {
    // Array to store the top view
    const result = [];
    // TreeMap to store node's data, height and
    // horizontal distance
    const treeMap = new TreeMap();
    topViewHelper(root, 0, 0, treeMap);
    treeMap.each((value, key) => {
        result.push(value.nodeData);
    });
    return result;
};

const topViewHelper = (root, verticalDistance, horizontalDistance, treeMap) => {
    // Base case
    if (root === null) {
        return;
    }
    // If the node for a horizontal distance is not
    // present in the map, add it.
    if (!treeMap.get(horizontalDistance)) {
        treeMap.set(horizontalDistance, new Pair(root.data, verticalDistance));
    }
    // If the node for a horizontal distance is present,
    // then we will pick up the node that comes first
    else {
        const currentPair = treeMap.get(horizontalDistance);
        if (currentPair.height >= verticalDistance) {
            treeMap.put(horizontalDistance, new Pair(root.data, verticalDistance));
        }
    }
    topViewHelper(root.left, verticalDistance + 1, horizontalDistance - 1, treeMap);
    topViewHelper(root.right, verticalDistance + 1, horizontalDistance + 1, treeMap);
};

function Pair(nodeData, height) {
    this.nodeData = (nodeData === undefined ? 0 : nodeData);
    this.height = (height === undefined ? 0 : height);
}

function Node(data, left, right) {
    this.data = (data === undefined ? 0 : data);
    this.left = (left === undefined ? null : left);
    this.right = (right === undefined ? null : right);
}

const main = () => {
    let root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.left.left = new Node(8);
    root.left.left.right = new Node(9);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);
    console.log(topView(root));

    root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.right = new Node(4);
    root.right.left = new Node(5);
    root.right.right = new Node(6);
    root.right.left.left = new Node(7);
    root.right.left.right = new Node(8);
    console.log(topView(root));
};

main();