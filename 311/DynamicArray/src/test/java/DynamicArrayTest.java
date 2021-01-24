package test.java;

import main.java.DynamicArray;
import org.junit.jupiter.api.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class DynamicArrayTest {
    Random random = new Random(1192021L);

    @Nested
    class ConstructorTests{
        @Test
        @DisplayName("Test the constructor with size 0")
        void testConstructor1() {
            assertThrows(IllegalArgumentException.class, () -> {
                DynamicArray dynamicArray1 = new DynamicArray(0);
            });
        }

        @RepeatedTest(value = 5)
        @DisplayName("Test the constructor with negative sizes")
        void testConstructor2() {
            int randomSize = random.nextInt(101) - 100;
            System.out.println("The initial size is: " + randomSize);
            assertThrows(IllegalArgumentException.class, () -> {
                DynamicArray dynamicArray1 = new DynamicArray(randomSize);
            });
        }

        @RepeatedTest(value = 5)
        @DisplayName("Test the constructor with a positive size")
        void testConstructor3() throws Exception {
            int initialSize = random.nextInt(30) + 1;
            System.out.println("The initial size is: " + initialSize);
            DynamicArray dynamicArray = new DynamicArray(initialSize);
            assertEquals(initialSize, dynamicArray.getCapacity());
            assertEquals(0, dynamicArray.getCount());
        }
    }

    @Nested
    class OtherTests{
        List<String> names = new ArrayList<>();
        DynamicArray dynamicArray;
        int initialSize;

        @BeforeEach
        void setup() throws Exception {
            InputStream in = getClass().getResourceAsStream("/test/resources/RandomNames.txt");
            Reader fr = new InputStreamReader(in, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(fr);

            while(reader.ready()) {
                String name = reader.readLine();
                names.add(name);
            }
            initialSize = random.nextInt(30) + 1;
            System.out.println("The initial size is: " + initialSize);
            dynamicArray = new DynamicArray(initialSize);
        }

        @RepeatedTest(value = 5)
        @DisplayName("Test the get method with an invalid index")
        void testGet1() {
            int randomIndex = random.nextInt(101) - 100;
            assertThrows(IndexOutOfBoundsException.class, () -> {
                dynamicArray.get(randomIndex);
            });
        }

        @Test
        @DisplayName("Test the get method with an invalid index")
        void testGet2() {
            assertThrows(IndexOutOfBoundsException.class, () -> {
                dynamicArray.get(-1);
            });
        }

        @RepeatedTest(value = 5)
        @DisplayName("Test the get method with an invalid index")
        void testGet3() throws Exception {
            int randomCount = random.nextInt(initialSize + 1);
            System.out.print("The count is: " + randomCount + ", ");
            for (int i = 0; i < randomCount; i ++){
                dynamicArray.append(names.get(i));
            }

            int randomIndex = random.nextInt(10) + randomCount;
            System.out.println("the index is: " + randomIndex);
            assertThrows(IndexOutOfBoundsException.class, () -> {
                dynamicArray.get(randomIndex);
            });
        }

        @Test
        @DisplayName("Test the get method with an invalid index")
        void testGet4() throws Exception {
            int randomCount = random.nextInt(initialSize + 1);
            System.out.print("The count is: " + randomCount + ", ");
            for (int i = 0; i < randomCount; i ++){
                dynamicArray.append(names.get(i));
            }

            int index = randomCount;
            System.out.println("the index is: " + index);
            assertThrows(IndexOutOfBoundsException.class, () -> {
                dynamicArray.get(index);
            });
        }

        @RepeatedTest(value = 5)
        @DisplayName("Test the get method with a valid index")
        void testGet5() throws Exception {
            int randomCount = random.nextInt(initialSize) + 1;
            for (int i = 0; i < randomCount; i++){
                dynamicArray.append(names.get(i));
            }

            int randomIndex = random.nextInt(randomCount);
            assertEquals(names.get(randomIndex), dynamicArray.get(randomIndex));
        }

        @RepeatedTest(value = 5)
        @DisplayName("Test the set method with an invalid index")
        void testSet1() {
            int randomIndex = random.nextInt(101) - 100;
            assertThrows(IndexOutOfBoundsException.class, () -> {
                dynamicArray.set(randomIndex, "");
            });
        }

        @Test
        @DisplayName("Test the set method with an invalid index")
        void testSet2() {
            assertThrows(IndexOutOfBoundsException.class, () -> {
                dynamicArray.set(-1, "");
            });
        }

        @RepeatedTest(value = 5)
        @DisplayName("Test the set method with an invalid index")
        void testSet3() throws Exception {
            int randomCount = random.nextInt(initialSize + 1);
            System.out.print("The count is: " + randomCount + ", ");
            for (int i = 0; i < randomCount; i ++){
                dynamicArray.append(names.get(i));
            }

            int randomIndex = random.nextInt(10) + randomCount;
            assertThrows(IndexOutOfBoundsException.class, () -> {
                dynamicArray.set(randomIndex, "");
            });
        }

        @Test
        @DisplayName("Test the set method with an invalid index")
        void testSet4() throws Exception {
            int randomCount = random.nextInt(initialSize + 1);
            System.out.print("The count is: " + randomCount + ", ");
            for (int i = 0; i < randomCount; i ++){
                dynamicArray.append(names.get(i));
            }

            int index = randomCount;
            System.out.println("the index is: " + index);
            assertThrows(IndexOutOfBoundsException.class, () -> {
                dynamicArray.set(index, "");
            });
        }

        @RepeatedTest(value = 5)
        @DisplayName("Test the set method with a valid index")
        void testSet5() throws Exception {
            int randomCount = random.nextInt(initialSize) + 1;
            for (int i = 0; i < randomCount; i ++){
                dynamicArray.append(names.get(i));
            }

            int randomIndex = random.nextInt(randomCount);
            String oldValue = dynamicArray.set(randomIndex, "");
            assertEquals("", dynamicArray.get(randomIndex));
            assertEquals(names.get(randomIndex), oldValue);
        }

        @Test
        @DisplayName("Adding random names to the dynamic array")
        void testAddingValues1() throws Exception {
            for (int i = 0; i < initialSize; i ++){
                dynamicArray.append(names.get(i));
            }

            for (int i = 0; i < initialSize; i++) {
                assertEquals(names.get(i), dynamicArray.get(i));
            }

            assertEquals(initialSize, dynamicArray.getCount());
            assertEquals(initialSize, dynamicArray.getCapacity());
        }

        @Test
        @DisplayName("Adding more random names than the initial capacity")
        void testAddingValues2() throws Exception {
            for (int i = 0; i < initialSize; i ++){
                dynamicArray.append(names.get(i));
            }
            dynamicArray.append("extra name");

            // check if the values are correct
            for (int i = 0; i < initialSize; i++) {
                assertEquals(names.get(i), dynamicArray.get(i));
            }
            assertEquals("extra name", dynamicArray.get(initialSize));

            // check if the count and the size of the array are correct
            assertEquals(initialSize + 1, dynamicArray.getCount());
            assertEquals(2 * initialSize, dynamicArray.getCapacity());
        }

        @Test
        @DisplayName("Adding more random names than the initial capacity")
        void testAddingValues3() throws Exception {
            for (int i = 0; i < 2 * initialSize; i ++){
                dynamicArray.append(names.get(i));
            }
            dynamicArray.append("extra name");

            // check if the values are correct
            for (int i = 0; i < 2 * initialSize; i++) {
                assertEquals(names.get(i), dynamicArray.get(i));
            }
            assertEquals("extra name", dynamicArray.get(2 * initialSize));

            // check if the count and the size of the array are correct
            assertEquals(2 * initialSize + 1, dynamicArray.getCount());
            assertEquals(4 * initialSize, dynamicArray.getCapacity());
        }

        @RepeatedTest(value = 5)
        @DisplayName("Test the insert method with an invalid index")
        void testInsert1() {
            int randomIndex = random.nextInt(101) - 100;
            assertThrows(IndexOutOfBoundsException.class, () -> {
                dynamicArray.insert(randomIndex, "");
            });
        }

        @Test
        @DisplayName("Test the insert method with an invalid index")
        void testInsert2() {
            assertThrows(IndexOutOfBoundsException.class, () -> {
                dynamicArray.insert(-1, "");
            });
        }

        @RepeatedTest(value = 5)
        @DisplayName("Test the insert method with an invalid index")
        void testInsert3() throws Exception {
            int randomCount = random.nextInt(initialSize + 1);
            System.out.print("The count is: " + randomCount + ", ");
            for (int i = 0; i < randomCount; i ++){
                dynamicArray.append(names.get(i));
            }

            int randomIndex = random.nextInt(10) + randomCount;
            assertThrows(IndexOutOfBoundsException.class, () -> {
                dynamicArray.insert(randomIndex, "");
            });
        }

        @Test
        @DisplayName("Test the insert method with an invalid index")
        void testInsert4() throws Exception {
            int randomCount = random.nextInt(initialSize + 1);
            System.out.print("The count is: " + randomCount + ", ");
            for (int i = 0; i < randomCount; i ++){
                dynamicArray.append(names.get(i));
            }

            int index = randomCount;
            System.out.println("the index is: " + index);
            assertThrows(IndexOutOfBoundsException.class, () -> {
                dynamicArray.insert(index, "");
            });
        }

        @RepeatedTest(value = 5)
        @DisplayName("Test the insert method with a valid index")
        void testInsert5() throws Exception {
            int randomCount = random.nextInt(initialSize) + 1;
            for (int i = 0; i < randomCount; i ++){
                dynamicArray.append(names.get(i));
            }

            int randomIndex = random.nextInt(randomCount);
            dynamicArray.insert(randomIndex, "");
            assertEquals(randomCount + 1, dynamicArray.getCount());

            for (int i = 0; i < randomIndex; i ++) {
                assertEquals(names.get(i), dynamicArray.get(i));
            }

            assertEquals("", dynamicArray.get(randomIndex));

            for (int i = randomIndex + 1; i < randomCount + 1; i++) {
                assertEquals(names.get(i-1), dynamicArray.get(i));
            }
        }

        @RepeatedTest(value = 5)
        @DisplayName("Test the insert method with a valid index")
        void testInsert6() throws Exception {
            int count = initialSize;
            for (int i = 0; i < count; i ++){
                dynamicArray.append(names.get(i));
            }

            int randomIndex = random.nextInt(count);
            dynamicArray.insert(randomIndex, "");
            assertEquals(count + 1, dynamicArray.getCount());

            for (int i = 0; i < randomIndex; i ++) {
                assertEquals(names.get(i), dynamicArray.get(i));
            }

            assertEquals("", dynamicArray.get(randomIndex));

            for (int i = randomIndex + 1; i < count + 1; i++) {
                assertEquals(names.get(i-1), dynamicArray.get(i));
            }

            assertEquals(2 * initialSize, dynamicArray.getCapacity());
        }

        @RepeatedTest(value = 5)
        @DisplayName("Test the remove method with an invalid index")
        void testRemove1() {
            int randomIndex = random.nextInt(101) - 100;
            assertThrows(IndexOutOfBoundsException.class, () -> {
                dynamicArray.remove(randomIndex);
            });
        }

        @Test
        @DisplayName("Test the remove method with an invalid index")
        void testRemove2() {
            assertThrows(IndexOutOfBoundsException.class, () -> {
                dynamicArray.remove(-1);
            });
        }

        @RepeatedTest(value = 5)
        @DisplayName("Test the remove method with an invalid index")
        void testRemove3() throws Exception {
            int randomCount = random.nextInt(initialSize + 1);
            System.out.print("The count is: " + randomCount + ", ");
            for (int i = 0; i < randomCount; i ++){
                dynamicArray.append(names.get(i));
            }

            int randomIndex = random.nextInt(10) + randomCount;
            assertThrows(IndexOutOfBoundsException.class, () -> {
                dynamicArray.remove(randomIndex);
            });
        }

        @Test
        @DisplayName("Test the remove method with an invalid index")
        void testRemove4() throws Exception {
            int randomCount = random.nextInt(initialSize + 1);
            System.out.print("The count is: " + randomCount + ", ");
            for (int i = 0; i < randomCount; i ++){
                dynamicArray.append(names.get(i));
            }

            int index = randomCount;
            System.out.println("the index is: " + index);
            assertThrows(IndexOutOfBoundsException.class, () -> {
                dynamicArray.remove(index);
            });
        }

        @RepeatedTest(value = 5)
        @DisplayName("Test the remove method with a valid index")
        void testRemove5() throws Exception {
            int randomCount = random.nextInt(initialSize) + 1;
            for (int i = 0; i < randomCount; i ++){
                dynamicArray.append(names.get(i));
            }

            int randomIndex = random.nextInt(randomCount);
            String removed = dynamicArray.remove(randomIndex);
            assertEquals(randomCount - 1, dynamicArray.getCount());
            assertEquals(names.get(randomIndex), removed);

            for (int i = 0; i < randomIndex; i ++) {
                assertEquals(names.get(i), dynamicArray.get(i));
            }

            for (int i = randomIndex; i < randomCount - 1; i++) {
                assertEquals(names.get(i+1), dynamicArray.get(i));
            }
        }
    }
}