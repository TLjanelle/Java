package test.java;

import main.java.ElementaryTable;
import main.java.HashTableSimpleHash;
import main.java.HashTableUniversalHash;
import main.java.Table;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TableTest {
    Table<String, Integer> table;
    String tableType;

    TableTest(String tableType) {
        this.tableType = tableType;

        switch (tableType) {
            case "ElementaryTable" -> table = new ElementaryTable<>();
            case "HashTableSimpleHash" -> table = new HashTableSimpleHash<>();
            case "HashTableUniversalHash" -> table = new HashTableUniversalHash<>();
        }
    }

    @Test
    @DisplayName("Testing putting and retrieving one value")
    void test1(){
        // reset the table
        table.clear();

        Integer value = table.put("99", 1);
        assertNull(value);
        assertEquals(1, table.get("99"));
    }

    @Test
    @DisplayName("Testing putting and retrieving three values")
    void test2(){
        // reset the table
        table.clear();

        Integer value1 = table.put("99", 1);
        assertNull(value1);

        Integer value2 = table.put("2", 2);
        assertNull(value2);

        Integer value3 = table.put("1", 3);
        assertNull(value3);

        assertEquals(1, table.get("99"));
        assertEquals(2, table.get("2"));
        assertEquals(3, table.get("1"));
    }

    @Test
    @DisplayName("Testing putting and retrieving three values in different order")
    void test3(){
        // reset the table
        table.clear();

        Integer value1 = table.put("99", 1);
        assertNull(value1);

        Integer value2 = table.put("2", 2);
        assertNull(value2);

        Integer value3 = table.put("1", 3);
        assertNull(value3);

        assertEquals(2, table.get("2"));
        assertEquals(3, table.get("1"));
        assertEquals(1, table.get("99"));
    }

    @Test
    @DisplayName("Testing overwriting value")
    void test4(){
        // reset the table
        table.clear();

        Integer value1 = table.put("99", 1);
        assertNull(value1);

        Integer value2 = table.put("99", 2);
        assertEquals(1, value2);

        assertEquals(2, table.get("99"));
    }

    @Test
    @DisplayName("Testing overwriting value")
    void test5(){
        // reset the table
        table.clear();

        Integer value1 = table.put("99", 1);
        assertNull(value1);

        Integer value2 = table.put("99", 2);
        assertEquals(1, value2);

        Integer value3 = table.put("99", 4);
        assertEquals(2, value3);

        Integer value4 = table.put("99", 3);
        assertEquals(4, value4);

        Integer value5 = table.put("1", 1);
        assertNull(value5);

        assertEquals(3, table.get("99"));
        assertEquals(1, table.get("1"));
    }

    @Test
    @DisplayName("Testing stacking values")
    void test6(){
        // reset the table
        table.clear();

        Integer value1 = table.put("99", 1);
        assertNull(value1);

        Integer value2 = table.put("1", 2);
        assertNull(value2);

        Integer value3 = table.put("5", 3);
        assertNull(value3);

        assertEquals(1, table.get("99"));
        assertEquals(2, table.get("1"));
        assertEquals(3, table.get("5"));
    }

    @Test
    @DisplayName("Testing get with no key value existing")
    void test7(){
        // reset the table
        table.clear();

        assertNull(table.get("99"));
        assertNull(table.get("1"));
    }

    @Test
    @DisplayName("Testing get with no key value existing")
    void test8(){
        // reset the table
        table.clear();

        Integer value1 = table.put("99", 1);
        assertNull(value1);

        Integer value2 = table.put("1", 1);
        assertNull(value2);

        assertEquals(1, table.get("99"));
        assertEquals(1, table.get("1"));
        assertNull(table.get("0"));
    }

    @Test
    @DisplayName("Testing get lots of nonexistent keys")
    void test9(){
        // reset the table
        table.clear();

        for(int i=0;i<200;i++) {
            assertNull(table.get("" + i));
        }
    }

    @Test
    @DisplayName("Testing delete")
    void test10(){
        // reset the table
        table.clear();

        Integer value1 = table.put("99", 1);
        assertNull(value1);

        Integer value2 = table.put("1", 1);
        assertNull(value2);

        Integer value3 = table.remove("99");
        assertEquals(1, value3);

        assertNull(table.get("99"));
        assertEquals(1, table.get("1"));
    }

    @Test
    @DisplayName("Testing get with null value")
    void test11(){
        // reset the table
        table.clear();

        Integer value1 = table.put("99", null);
        assertNull(value1);

        Integer value2 = table.put("1", 1);
        assertNull(value2);

        assertNull(table.get("99"));
        assertEquals(1, table.get("1"));
    }

    @Test
    @DisplayName("Testing containsKey with no values")
    void test12(){
        // reset the table
        table.clear();

        boolean hasKey = table.containsKey("1");
        assertFalse(hasKey);
    }

    @Test
    @DisplayName("Testing contains with no values lots of times")
    void test14(){
        // reset the table
        table.clear();

        for(int i=0;i<200;i++) {
            assertFalse(table.containsKey("" + i));
        }
    }

    @Test
    @DisplayName("Testing contains with a value")
    void test15(){
        // reset the table
        table.clear();

        Integer value1 = table.put("1", 1);
        assertNull(value1);

        boolean hasKey = table.containsKey("1");
        assertTrue(hasKey);
    }

    @Test
    @DisplayName("Testing contains with a value that's been deleted")
    void test16(){
        // reset the table
        table.clear();

        Integer value1 = table.put("1", 1);
        assertNull(value1);

        Integer value2 = table.put("99", 2);
        assertNull(value2);

        Integer value3 = table.remove("1");
        assertEquals(1, value3);

        boolean hasKey = table.containsKey("1");
        assertFalse(hasKey);
    }

    @Test
    @DisplayName("Testing contains with a value that's been deleted and reput")
    void test17(){
        // reset the table
        table.clear();

        Integer value1 = table.put("1", 1);
        assertNull(value1);

        Integer value2 = table.remove("1");
        assertEquals(1, value2);

        Integer value3 = table.put("1", 3);
        assertNull(value3);

        boolean hasKey = table.containsKey("1");
        assertTrue(hasKey);
    }

    @Test
    @DisplayName("Testing contains with a value that's been deleted and reput, plus new value")
    void test18(){
        // reset the table
        table.clear();

        Integer value1 = table.put("1", 1);
        assertNull(value1);

        Integer value2 = table.remove("1");
        assertEquals(1, value2);

        Integer value3 = table.put("99", 2);
        assertNull(value1);

        Integer value4 = table.put("2", 3);
        assertNull(value1);

        Integer value5 = table.put("1", 4);
        assertNull(value1);

        assertTrue(table.containsKey("1"));
        assertTrue(table.containsKey("99"));
        assertTrue(table.containsKey("2"));
    }

    @Test
    @DisplayName("Testing with 2000 random keys and values")
    void test19() throws IOException {
        // reset the table
        table.clear();

        List<String> keys = getStrings("/test/resources/keys");
        List<String> values = getStrings("/test/resources/values");

        for (int i = 0; i < keys.size(); i ++) {
            String key = keys.get(i);
            int value = Integer.parseInt(values.get(i));
            table.put(key, value);
        }

        String output = table.toString();
        String[] outputLines = output.split(System.getProperty("line.separator"));
        if (tableType.equals("ElementaryTable")) {
            List<String> elementaryExpected = getStrings("/test/resources/elementary");
            for (int i = 0; i < elementaryExpected.size(); i++) {
                String expected = elementaryExpected.get(i).strip();
                String outputted = outputLines[i].strip();
                assertEquals(expected, outputted);
            }

            for (int i = elementaryExpected.size(); i < outputLines.length; i++) {
                assertTrue(outputLines[i].strip().isEmpty());
            }
        } else {
            System.out.print(output);
        }
    }

    private static List<String> getStrings(String filePath) throws IOException {
        InputStream in = TableTest.class.getResourceAsStream(filePath);
        Reader fr = new InputStreamReader(in, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(fr);
        List<String> inputs = new ArrayList<>();

        while(reader.ready()) {
            String input = reader.readLine();
            inputs.add(input.strip());
        }
        return inputs;
    }
}
