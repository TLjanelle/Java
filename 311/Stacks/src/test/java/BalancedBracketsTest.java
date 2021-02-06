package test.java;

import main.java.BalancedBrackets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


class BalancedBracketsTest {
    @DisplayName("Test balancing brackets")
    @ParameterizedTest
    @MethodSource("bracketsList")
    void test(String input, boolean expected){
        boolean result = BalancedBrackets.match(input);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> bracketsList() throws IOException {
        List<String> inputs = getStrings("/test/resources/input");
        List<String> outputs = getStrings("/test/resources/output");

        Stream.Builder<Arguments> builder = Stream.builder();

        for (int i = 0; i < inputs.size(); i ++) {
            String input = inputs.get(i);
            String output = outputs.get(i);
            if (output.equals("true")) {
                builder = builder.add(Arguments.of(input, true));
            } else {
                builder = builder.add(Arguments.of(input, false));
            }

        }

        return builder.build();
    }

    private static List<String> getStrings(String filePath) throws IOException {
        InputStream in = BalancedBracketsTest.class.getResourceAsStream(filePath);
        Reader fr = new InputStreamReader(in, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(fr);
        List<String> inputs = new ArrayList<>();

        while(reader.ready()) {
            String input = reader.readLine();
            inputs.add(input);
        }
        return inputs;
    }
}