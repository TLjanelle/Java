package test.java;

import main.java.DP_Exercise;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DP_ExerciseTest {
    private static Stream<Arguments> testSource() throws IOException {
        List<String> faceValuesList = getStrings("/test/resources/faceValues");
        List<String> moneyList = getStrings("/test/resources/money");
        List<String> outputList = getStrings("/test/resources/output");

        Stream.Builder<Arguments> builder = Stream.builder();

        for (int i = 0; i < faceValuesList.size(); i ++) {
            String[] faceValuesStr = faceValuesList.get(i).split(",");
            int[] faceValues = new int[faceValuesStr.length];
            for (int j = 0; j < faceValuesStr.length; j++) {
                faceValues[j] = Integer.parseInt(faceValuesStr[j]);
            }

            int money = Integer.parseInt(moneyList.get(i));
            int output = Integer.parseInt(outputList.get(i));

            builder = builder.add(Arguments.of(faceValues, money, output));
        }

        return builder.build();
    }

    private static List<String> getStrings(String filePath) throws IOException {
        InputStream in = DP_ExerciseTest.class.getResourceAsStream(filePath);
        Reader fr = new InputStreamReader(in, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(fr);
        List<String> inputs = new ArrayList<>();

        while(reader.ready()) {
            String input = reader.readLine();
            inputs.add(input);
        }
        return inputs;
    }

    @DisplayName("Test the recursive method")
    @ParameterizedTest
    @MethodSource("testSource")
    void test_recursive(int[] faceValues, int money, int expected){
        int result = DP_Exercise.recursiveChange(faceValues, money);
        assertEquals(expected, result);
    }

    @DisplayName("Test the method with memoization")
    @ParameterizedTest
    @MethodSource("testSource")
    void test_memo(int[] faceValues, int money, int expected){
        HashMap<Integer, Integer> memo = new HashMap<>();
        int result = DP_Exercise.memoChange(faceValues, money, memo);
        assertEquals(expected, result);
    }

    @DisplayName("Test the method with tabulation")
    @ParameterizedTest
    @MethodSource("testSource")
    void test_tab(int[] faceValues, int money, int expected){
        int result = DP_Exercise.tabChange(faceValues, money);
        assertEquals(expected, result);
    }
}
