package test.java;

import main.java.DoublyLinkedList;
import main.java.LinkedList;
import main.java.Node;
import main.java.SinglyLinkedList;
import org.junit.jupiter.api.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    public enum ListType {
        Singly,
        Doubly
    }
    static ListType listType = ListType.Doubly;

    @BeforeAll
    static void setupAll() {
        System.out.println("Testing: " + listType + " linked list.");
    }

    @Nested
    class ConstructorTests{
        @Test
        @DisplayName("Test the constructor")
        void testConstructor1() {
            LinkedList linkedList = switch (listType) {
                case Singly -> new SinglyLinkedList();
                case Doubly -> new DoublyLinkedList();
            };

            assertEquals(linkedList.getCount(), 0);
            assertNull(linkedList.getHead());
            if (linkedList instanceof DoublyLinkedList) {
                DoublyLinkedList doublyLinkedList = (DoublyLinkedList) linkedList;
                assertNull(doublyLinkedList.getTail());
            }
        }
    }

    @Nested
    class TestsWithOneNodeList  {
        LinkedList linkedList;
        Node currentNode;

        @BeforeEach
        void setup() {
            if (listType == ListType.Singly) {
                linkedList = new SinglyLinkedList();
            } else {
                linkedList = new DoublyLinkedList();
            }
            linkedList.append("node 1");
            currentNode = linkedList.getHead();
            System.out.println("Created linked list: n1: node 1");
        }

        @Test
        @DisplayName("Test the insertAfter method")
        void testInsert() {
            System.out.print("Testing the insert method: ");
            linkedList.insertAfter(currentNode, "new node");
            System.out.println("inserted after n1: new node");

            Node head = linkedList.getHead();
            if (listType == ListType.Doubly) {
                assertNull(((DoublyLinkedList.DoublyLinkedListNode)head).getPrev());
            }
            assertEquals("node 1", head.getValue());
            System.out.print("Checking the list: n1: " + head.getValue() + ", ");
            Node secondNode = head.getNext();
            if (listType == ListType.Doubly) {
                assertEquals(head, ((DoublyLinkedList.DoublyLinkedListNode)secondNode).getPrev());
                assertEquals(((DoublyLinkedList)linkedList).getTail(), secondNode);
            }
            assertEquals("new node", secondNode.getValue());
            assertNull(secondNode.getNext());
            System.out.print("n2: " + secondNode.getValue());

            assertEquals(2, linkedList.getCount());
            System.out.println("\n-------");
        }

        @Test
        @DisplayName("Test the remove method")
        void testRemove() {
            System.out.print("Testing the remove method: ");
            linkedList.remove(currentNode);
            System.out.println("remove n1");

            assertNull(linkedList.getHead());
            if (listType == ListType.Doubly) {
                assertNull(((DoublyLinkedList)linkedList).getTail());
            }
            assertEquals(0, linkedList.getCount());
            System.out.println("\n-------");
        }
    }

    @Nested
    class TestsWithVariableSizeList {
        private final Random random = new Random();
        List<String> names = new ArrayList<>();
        LinkedList linkedList;
        int initialSize;

        @BeforeEach
        void setup() throws Exception {
            /* initialize this.names with the lines in RandomNames.txt */
            InputStream in = getClass().getResourceAsStream("/test/resources/RandomNames.txt");
            Reader fr = new InputStreamReader(in, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(fr);

            while(reader.ready()) {
                String name = reader.readLine();
                names.add(name);
            }

            /* initialize linkedList with SinglyLinkedList or DoublyLinkedList */
            linkedList = switch (listType) {
                case Singly -> new SinglyLinkedList();
                case Doubly -> new DoublyLinkedList();
            };

            /* add a random number of elements into the linkedList */
            initialSize = random.nextInt(60) + 1;

            System.out.print("The count is: " + initialSize + ", ");
            System.out.println("created the list: ");
            for (int i = 0; i < initialSize; i ++){
                linkedList.append(names.get(i));
                System.out.print("n" + i + ": " + names.get(i) + ", ");
            }
            System.out.println("\nFinished set up.");
        }

        @RepeatedTest(value = 5)
        @DisplayName("Checking the status of the initialized linked list")
        void testAddingValues1() {
            System.out.println("Checking the list: ");
            for (int i = 0; i < initialSize; i++) {
                System.out.println("index: " + i);
                String value = linkedList.get(i).getValue();
                assertEquals(names.get(i), value);
                System.out.print("n" + i + ": " + value + ", ");
            }

            assertEquals(initialSize, linkedList.getCount());
            System.out.println("\n-------");
        }

        @RepeatedTest(value = 5)
        @DisplayName("Test the get method with a negative index")
        void testGet1() {
            int randomIndex = random.nextInt(100) - 100;
            System.out.println("Testing the get method with index: " + randomIndex);
            assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(randomIndex));
            System.out.println("\n-------");
        }

        @Test
        @DisplayName("Test the get method with index -1")
        void testGet2() {
            System.out.println("Testing the get method with index: -1");
            assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(-1));
            System.out.println("\n-------");
        }

        @RepeatedTest(value = 5)
        @DisplayName("Test the get method with an invalid index")
        void testGet3() {
            /* get the element of the linkedList at a random index */
            int randomIndex = random.nextInt(10) + this.initialSize;
            System.out.println("Testing the get method with index: " + randomIndex);
            assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(randomIndex));
            System.out.println("\n-------");
        }

        @Test
        @DisplayName("Test the get method with an invalid index")
        void testGet4() {
            int index = this.initialSize;
            System.out.println("Testing the get method with index: " + index);
            assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(index));
            System.out.println("\n-------");
        }

        @RepeatedTest(value = 5)
        @DisplayName("Test the get method with a valid index")
        void testGet5() {
            int randomIndex = random.nextInt(this.initialSize);
            System.out.println("Testing the get method with index: " + randomIndex);
            assertEquals(names.get(randomIndex), linkedList.get(randomIndex).getValue());
            System.out.println("\n-------");
        }

        @RepeatedTest(value = 5)
        @DisplayName("Test the set method with an invalid index")
        void testSet1() {
            int randomIndex = random.nextInt(100) - 100;
            System.out.println("Testing the set method with index: " + randomIndex);
            assertThrows(IndexOutOfBoundsException.class, () -> linkedList.set(randomIndex, ""));
            System.out.println("\n-------");
        }

        @Test
        @DisplayName("Test the set method with an invalid index")
        void testSet2() {
            System.out.println("Testing the set method with index: -1");
            assertThrows(IndexOutOfBoundsException.class, () -> linkedList.set(-1, ""));
            System.out.println("\n-------");
        }

        @RepeatedTest(value = 5)
        @DisplayName("Test the set method with an invalid index")
        void testSet3() {
            int randomIndex = random.nextInt(10) + this.initialSize;
            System.out.println("Testing the set method with index: " + randomIndex);
            assertThrows(IndexOutOfBoundsException.class, () -> linkedList.set(randomIndex, ""));
            System.out.println("\n-------");
        }

        @Test
        @DisplayName("Test the set method with an invalid index")
        void testSet4() {
            int index = this.initialSize;
            System.out.println("Testing the set method with index: " + index);
            assertThrows(IndexOutOfBoundsException.class, () -> linkedList.set(index, ""));
            System.out.println("\n-------");
        }

        @RepeatedTest(value = 5)
        @DisplayName("Test the set method with a valid index")
        void testSet5() {
            int randomIndex = random.nextInt(this.initialSize);
            System.out.println("Testing the set method with index: " + randomIndex);
            String oldValue = linkedList.set(randomIndex, "");
            assertEquals("", linkedList.get(randomIndex).getValue());
            assertEquals(names.get(randomIndex), oldValue);
            System.out.println("\n-------");
        }

        @RepeatedTest(value = 5)
        @DisplayName("Test the insert method with a node")
        void testInsert() {
            int randomIndex = random.nextInt(this.initialSize);
            Node node = this.linkedList.get(randomIndex);

            System.out.println("Testing the insert method with index: " + randomIndex);
            linkedList.insertAfter(node, "new value");
            assertEquals(this.initialSize + 1, linkedList.getCount());

            Node n = linkedList.getHead();
            int nameIndex = 0;
            int count = 0;
            int nodeIndex = 0;
            while(n != null) {
                count ++;
                if (nodeIndex == randomIndex + 1) {
                    assertEquals("new value", n.getValue());
                } else {
                    assertEquals(names.get(nameIndex), n.getValue());
                    nameIndex++;
                }
                System.out.print("n" + nodeIndex + ": " + n.getValue() + ", ");
                n = n.getNext();
                nodeIndex++;
            }

            assertEquals(this.initialSize+1, count);

            if (listType == ListType.Doubly) {
                DoublyLinkedList list = (DoublyLinkedList) this.linkedList;
                // the prev pointers
                DoublyLinkedList.DoublyLinkedListNode n2 = list.getTail();
                int nameIndex2 = this.initialSize - 1;
                int count2 = 0;
                int nodeIndex2 = this.initialSize;
                while (n2 != null) {
                    count2 ++;
                    if (nodeIndex2 == randomIndex + 1) {
                        assertEquals("new value", n2.getValue());
                    } else {
                        assertEquals(names.get(nameIndex2), n2.getValue());
                        nameIndex2 --;
                    }
                    n2 = n2.getPrev();
                    nodeIndex2 --;
                }

                assertEquals(this.initialSize+1, count2);
            }
        }

        @RepeatedTest(value = 5)
        @DisplayName("Test the remove method with a node")
        void testRemove() {
            int randomIndex = random.nextInt(this.initialSize);
            Node node = this.linkedList.get(randomIndex);

            String removed = linkedList.remove(node);
            assertEquals(this.initialSize - 1, linkedList.getCount());
            assertEquals(names.get(randomIndex), removed);

            // iterate the linkedlist from head to tail to check every node
            Node n = linkedList.getHead();
            int i = 0;
            int count = 0;
            while(n != null) {
                count ++;
                if (i == randomIndex) {
                    i++; // skip the target name in the names
                }

                assertEquals(names.get(i), n.getValue());
                i++;
                n = n.getNext();
            }

            assertEquals(this.initialSize - 1, count);

            if (listType == ListType.Doubly) {
                // iterate the linkedlist from tail to head to check every node

                DoublyLinkedList list = (DoublyLinkedList) this.linkedList;
                // the prev pointers
                DoublyLinkedList.DoublyLinkedListNode n2 = list.getTail();
                int i2 = this.initialSize - 1;
                int count2 = 0;
                while (n2 != null) {
                    count2 ++;
                    if (i2 == randomIndex) {
                        i2 --; // skip the target name in the names
                    }

                    assertEquals(names.get(i2), n2.getValue());
                    i2 --;
                    n2 = n2.getPrev();
                }

                assertEquals(this.initialSize - 1, count2);
            }
        }
    }
}