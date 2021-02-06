package test.java;

import main.java.Stack;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    @Test
    @DisplayName("Test the constructor, which should create an empty stack")
    void testConstructor(){
        Stack stack = new Stack();
        assertTrue(stack.empty());
        assertEquals(0, stack.size());
        assertThrows(EmptyStackException.class, () -> stack.pop());
        assertThrows(EmptyStackException.class, () -> stack.top());
    }

    @Test
    @DisplayName("Test the push and top methods with one value")
    void testPush1(){
        Stack stack = new Stack();
        stack.push("A");
        assertEquals(1, stack.size());
        assertEquals("A", stack.top());
        assertFalse(stack.empty());
    }

    @Test
    @DisplayName("Test the push and top methods with two values")
    void testPush2(){
        Stack stack = new Stack();
        stack.push("A");
        assertEquals(1, stack.size());
        assertEquals("A", stack.top());
        assertFalse(stack.empty());

        stack.push("B");
        assertEquals(2, stack.size());
        assertEquals("B", stack.top());
        assertFalse(stack.empty());
    }

    @Test
    @DisplayName("Test the push and pop methods with one value")
    void testPush3(){
        Stack stack = new Stack();
        stack.push("A");
        assertEquals(1, stack.size());
        assertEquals("A", stack.pop());
        assertTrue(stack.empty());
    }

    @Test
    @DisplayName("Test the push and pop methods with two values")
    void testPush4(){
        Stack stack = new Stack();
        stack.push("A");
        assertEquals(1, stack.size());
        stack.push("B");
        assertEquals(2, stack.size());
        assertFalse(stack.empty());

        assertEquals("B", stack.pop());
        assertFalse(stack.empty());
        assertEquals(1, stack.size());
    }

    @Test
    @DisplayName("Test the push and pop methods with two values")
    void testPush5(){
        Stack stack = new Stack();
        stack.push("A");
        assertEquals(1, stack.size());
        stack.push("B");
        assertEquals(2, stack.size());
        assertFalse(stack.empty());

        assertEquals("B", stack.pop());
        assertFalse(stack.empty());
        assertEquals(1, stack.size());

        assertEquals("A", stack.pop());
        assertTrue(stack.empty());
        assertEquals(0, stack.size());

        assertThrows(EmptyStackException.class, () -> stack.pop());
        assertThrows(EmptyStackException.class, () -> stack.top());
    }
}