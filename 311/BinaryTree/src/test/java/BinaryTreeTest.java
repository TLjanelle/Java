package test.java;

import main.java.BinaryTree;
import main.java.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest {
    BinaryTree<String> tree;

    @BeforeEach
    void constructAnEmptyTree() {
        tree = new BinaryTree<>();
    }

    @Test
    @DisplayName("Test an empty tree")
    void test1(){
        assertNull(tree.root());
        assertEquals(0, tree.size());
        assertEquals(-1, tree.height());
    }

    @Test
    @DisplayName("Test a tree with one node")
    void test2(){
        Node<String> root = tree.addRoot("Tasha");
        assertNotNull(root);
        assertNull(root.getParent());

        assertEquals(root, tree.root());
        assertEquals(root.getElement(), "Tasha");
        assertEquals(1, tree.size());
        assertEquals(0, tree.height());
    }

    @Test
    @DisplayName("Test addRoot when the tree already has a root")
    void test3(){
        Node<String> root = tree.addRoot("Tasha");
        Node<String> root2 = tree.addRoot("Emily");
        assertNull(root2);

        Node<String> realRoot = tree.root();
        assertEquals(root, realRoot);
        assertEquals(1, tree.size());
        assertEquals(0, tree.height());
    }

    @Test
    @DisplayName("Test addLeftChild")
    void test4(){
        Node<String> root = tree.addRoot("Tasha");
        Node<String> newNode = tree.addLeftChild(root, "Emily");
        assertNotNull(newNode);
        assertEquals(root, newNode.getParent());
        assertEquals("Emily", newNode.getElement());

        // check the status of the tree
        String out = tree.toString();
        String expected = "size: 2\n" +
                "Height of the tree is: 1\n" +
                "root: Tasha\n" +
                "Tasha\n" +
                " l:Emily\n";
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test addRightChild")
    void test5(){
        Node<String> root = tree.addRoot("Tasha");
        Node<String> newNode = tree.addRightChild(root, "Travis");
        assertNotNull(newNode);
        assertEquals(root, newNode.getParent());
        assertEquals("Travis", newNode.getElement());

        // check the status of the tree
        String out = tree.toString();
        String expected = "size: 2\n" +
                "Height of the tree is: 1\n" +
                "root: Tasha\n" +
                "Tasha\n" +
                " r:Travis\n";
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test addLeftChild and addRightChild")
    void test6(){
        Node<String> root = tree.addRoot("Tasha");
        Node<String> leftNode = tree.addLeftChild(root, "Emily");
        assertNotNull(leftNode);
        assertEquals(root, leftNode.getParent());
        assertEquals("Emily", leftNode.getElement());
        Node<String> rightNode = tree.addRightChild(root, "Travis");
        assertNotNull(rightNode);
        assertEquals(root, rightNode.getParent());
        assertEquals("Travis", rightNode.getElement());

        // check the status of the tree
        String out = tree.toString();
        String expected = "size: 3\n" +
                "Height of the tree is: 1\n" +
                "root: Tasha\n" +
                "Tasha\n" +
                " l:Emily\n" +
                " r:Travis\n";
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test addRightChild and addLeftChild")
    void test7(){
        Node<String> root = tree.addRoot("Tasha");
        Node<String> rightNode = tree.addRightChild(root, "Travis");
        assertNotNull(rightNode);
        assertEquals(root, rightNode.getParent());
        assertEquals("Travis", rightNode.getElement());
        Node<String> leftNode = tree.addLeftChild(root, "Emily");
        assertNotNull(leftNode);
        assertEquals(root, leftNode.getParent());
        assertEquals("Emily", leftNode.getElement());

        // check the status of the tree
        String out = tree.toString();
        String expected = "size: 3\n" +
                "Height of the tree is: 1\n" +
                "root: Tasha\n" +
                "Tasha\n" +
                " l:Emily\n" +
                " r:Travis\n";
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test add a null element")
    void test8(){
        Node<String> root = tree.addRoot(null);
        assertNotNull(root);
        assertEquals(root, tree.root());
        assertNull(root.getElement());
        assertEquals(1, tree.size());
        assertEquals(0, tree.height());
    }

    @Test
    @DisplayName("Test addLeftChild with a null element")
    void test9(){
        Node<String> root = tree.addRoot("Tasha");
        Node<String> newNode = tree.addLeftChild(root, null);
        assertNotNull(newNode);
        assertEquals(root, newNode.getParent());
        assertNull(newNode.getElement());

        // check the status of the tree
        String out = tree.toString();
        String expected = "size: 2\n" +
                "Height of the tree is: 1\n" +
                "root: Tasha\n" +
                "Tasha\n" +
                " l:(null)\n";
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test addRightChild with a null element")
    void test10(){
        Node<String> root = tree.addRoot("Tasha");
        Node<String> newNode = tree.addRightChild(root, null);
        assertNotNull(newNode);
        assertEquals(root, newNode.getParent());
        assertNull(newNode.getElement());

        // check the status of the tree
        String out = tree.toString();
        String expected = "size: 2\n" +
                "Height of the tree is: 1\n" +
                "root: Tasha\n" +
                "Tasha\n" +
                " r:(null)\n";
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test addLeftChild and addRightChild to the new child")
    void test11() {
        Node<String> root = tree.addRoot("Tasha");
        Node<String> leftNode = tree.addLeftChild(root, "Emily");
        assertNotNull(leftNode);
        assertEquals(root, leftNode.getParent());

        assertEquals("Emily", leftNode.getElement());
        Node<String> rightNode = tree.addRightChild(leftNode, "Travis");
        assertNotNull(rightNode);
        assertEquals("Travis", rightNode.getElement());
        assertEquals(leftNode, rightNode.getParent());

        // check the status of the tree
        String out = tree.toString();
        String expected = "size: 3\n" +
                "Height of the tree is: 2\n" +
                "root: Tasha\n" +
                "Tasha\n" +
                " l:Emily\n" +
                "  r:Travis\n";
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test a complicated tree")
    void test12(){
        /*
         *            Tasha
         *         /          \
         *     Emily          Travis
         *  /       \         /     \
         * Natasha  Mindy   Devin Jonathon
         *    \
         *    Lois
         */
        Node<String> root = tree.addRoot("Tasha");
        Node<String> leftNode = tree.addLeftChild(root, "Emily");
        Node<String> rightNode = tree.addRightChild(root, "Travis");
        Node<String> Natasha = tree.addLeftChild(leftNode, "Natasha");
        Node<String> Mindy = tree.addRightChild(leftNode, "Mindy");
        Node<String> Devin = tree.addLeftChild(rightNode, "Devin");
        Node<String> Jonathon = tree.addRightChild(rightNode, "Jonathon");
        Node<String> Lois = tree.addRightChild(Natasha, "Lois");

        assertEquals(8, tree.size());
        assertEquals(3, tree.height());
        // check the status of the tree
        String out = tree.toString();
        String expected = "size: 8\n" +
                "Height of the tree is: 3\n" +
                "root: Tasha\n" +
                "Tasha\n" +
                " l:Emily\n" +
                "  l:Natasha\n" +
                "   r:Lois\n" +
                "  r:Mindy\n" +
                " r:Travis\n" +
                "  l:Devin\n" +
                "  r:Jonathon\n";
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test a complicated tree 2")
    void test13(){
        /*
         * tree test2:
         *          16
         *       /     \
         *     13      19
         *    / \    /    \
         *   12 15  16    22
         *  /   /    \    /
         * 10  14    17  21
         *              /
         *             20
         * */
        Node<String> root = tree.addRoot("16");
        Node<String> leftNode = tree.addLeftChild(root, "13");
        Node<String> rightNode = tree.addRightChild(root, "19");
        Node<String> twelve = tree.addLeftChild(leftNode, "12");
        Node<String> fifteen = tree.addRightChild(leftNode, "15");
        Node<String> sixteen = tree.addLeftChild(rightNode, "16");
        Node<String> twentyTwo = tree.addRightChild(rightNode, "22");
        Node<String> ten = tree.addLeftChild(twelve, "10");
        Node<String> fourteen = tree.addLeftChild(fifteen, "14");
        Node<String> seventeen = tree.addRightChild(sixteen, "17");
        Node<String> twentyFirst = tree.addLeftChild(twentyTwo, "21");
        Node<String> twenty = tree.addLeftChild(twentyFirst, "20");

        assertEquals(12, tree.size());
        assertEquals(4, tree.height());

        // check the status of the tree
        String out = tree.toString();
        String expected = "size: 12\n" +
                "Height of the tree is: 4\n" +
                "root: 16\n" +
                "16\n" +
                " l:13\n" +
                "  l:12\n" +
                "   l:10\n" +
                "  r:15\n" +
                "   l:14\n" +
                " r:19\n" +
                "  l:16\n" +
                "   r:17\n" +
                "  r:22\n" +
                "   l:21\n" +
                "    l:20\n";
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test remove method: attempt to remove a node with two children")
    void test14(){
        /*
         *            Tasha
         *         /          \
         *     Emily          Travis
         *  /       \         /     \
         * Natasha  Mindy   Devin Jonathon
         *    \
         *    Lois
         */
        Node<String> root = tree.addRoot("Tasha");
        Node<String> leftNode = tree.addLeftChild(root, "Emily");
        Node<String> rightNode = tree.addRightChild(root, "Travis");
        Node<String> Natasha = tree.addLeftChild(leftNode, "Natasha");
        Node<String> Mindy = tree.addRightChild(leftNode, "Mindy");
        Node<String> Devin = tree.addLeftChild(rightNode, "Devin");
        Node<String> Jonathon = tree.addRightChild(rightNode, "Jonathon");
        Node<String> Lois = tree.addRightChild(Natasha, "Lois");

        boolean removed = tree.remove(leftNode);
        assertEquals(false, removed);

        assertEquals(8, tree.size());
        assertEquals(3, tree.height());
        // check the status of the tree
        String out = tree.toString();
        String expected = "size: 8\n" +
                "Height of the tree is: 3\n" +
                "root: Tasha\n" +
                "Tasha\n" +
                " l:Emily\n" +
                "  l:Natasha\n" +
                "   r:Lois\n" +
                "  r:Mindy\n" +
                " r:Travis\n" +
                "  l:Devin\n" +
                "  r:Jonathon\n";
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test remove method: remove a node with one child")
    void test15(){
        /*
         *            Tasha
         *         /          \
         *     Emily          Travis
         *  /       \         /     \
         * Natasha  Mindy   Devin Jonathon
         *    \
         *    Lois
         */
        Node<String> root = tree.addRoot("Tasha");
        Node<String> leftNode = tree.addLeftChild(root, "Emily");
        Node<String> rightNode = tree.addRightChild(root, "Travis");
        Node<String> Natasha = tree.addLeftChild(leftNode, "Natasha");
        Node<String> Mindy = tree.addRightChild(leftNode, "Mindy");
        Node<String> Devin = tree.addLeftChild(rightNode, "Devin");
        Node<String> Jonathon = tree.addRightChild(rightNode, "Jonathon");
        Node<String> Lois = tree.addRightChild(Natasha, "Lois");

        boolean removed = tree.remove(Natasha);
        assertTrue(removed);

        assertEquals(7, tree.size());
        assertEquals(2, tree.height());
        // check the status of the tree
        String out = tree.toString();
        String expected = "size: 7\n" +
                "Height of the tree is: 2\n" +
                "root: Tasha\n" +
                "Tasha\n" +
                " l:Emily\n" +
                "  l:Lois\n" +
                "  r:Mindy\n" +
                " r:Travis\n" +
                "  l:Devin\n" +
                "  r:Jonathon\n";
        assertEquals(expected, out);
    }

    @Test
    @DisplayName("Test remove method: remove a node with one child")
    void test16(){
        /*
         * tree test2:
         *          16
         *       /     \
         *     13      19
         *    / \    /    \
         *   12 15  16    22
         *  /   /    \    /
         * 10  14    17  21
         *              /
         *             20
         * */
        Node<String> root = tree.addRoot("16");
        Node<String> leftNode = tree.addLeftChild(root, "13");
        Node<String> rightNode = tree.addRightChild(root, "19");
        Node<String> twelve = tree.addLeftChild(leftNode, "12");
        Node<String> fifteen = tree.addRightChild(leftNode, "15");
        Node<String> sixteen = tree.addLeftChild(rightNode, "16");
        Node<String> twentyTwo = tree.addRightChild(rightNode, "22");
        Node<String> ten = tree.addLeftChild(twelve, "10");
        Node<String> fourteen = tree.addLeftChild(fifteen, "14");
        Node<String> seventeen = tree.addRightChild(sixteen, "17");
        Node<String> twentyFirst = tree.addLeftChild(twentyTwo, "21");
        Node<String> twenty = tree.addLeftChild(twentyFirst, "20");

        boolean removed = tree.remove(twentyTwo);
        assertTrue(removed);
        assertEquals(11, tree.size());
        assertEquals(3, tree.height());

        // check the status of the tree
        String out = tree.toString();
        String expected = "size: 11\n" +
                "Height of the tree is: 3\n" +
                "root: 16\n" +
                "16\n" +
                " l:13\n" +
                "  l:12\n" +
                "   l:10\n" +
                "  r:15\n" +
                "   l:14\n" +
                " r:19\n" +
                "  l:16\n" +
                "   r:17\n" +
                "  r:21\n" +
                "   l:20\n";
        assertEquals(expected, out);
    }

}
