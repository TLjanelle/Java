package main.java;

import java.math.BigInteger;

public class Fibonacci {
    // naive
    public static long recursiveFibonacci(int n) {
        // If (n < 0 ): throw an exception
        if (n < 0) try {
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // If (n <= 1): return n;
        if (n <= 1) return n;
        // return naïve(n-1) + naïve(n-2)

        return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
    }

    // efficient
    public static int arrayFibonacci(int n) {

        // If n < 0: throw new exception
        if (n < 0) try {
            throw new Exception("#2 Index less than 0.");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // if n <= 1: return n
        if (n <= 1) return n;

        // Create a new array, arr to store the Fibonacci numbers
        int[] arr = new int[n+1];

        // for i from 2 to n:
        for (int i = 2; i <= n; i++) {
            // arr[i] = arr[i-1] + arr[i-2]
            arr[0] = 0;
            arr[1] = 1;
            arr[i] = arr[i-1] + arr[i-2];
        }

        return arr[n];
    }

    public static void main(String[] args) {
        int startingNumber = 43;
        for (int i = 0; i < 6; i++) {
            System.out.println("--------n = " + (startingNumber+i) + "--------");
            long start = System.nanoTime();
            long fib = recursiveFibonacci(startingNumber+i);
            long stop = System.nanoTime();
            long timeElapsed = (stop - start) / 1_000_000_000;
            System.out.println("    naive: " + timeElapsed + "seconds");

            long start2 = System.nanoTime();
            long fib2 = arrayFibonacci(startingNumber+i);
            long stop2 = System.nanoTime();
            long timeElapsed2 = (stop2 - start2) / 1_000;
            System.out.println("    efficient: " + timeElapsed2 + "microseconds");

            if (fib == fib2) {
                System.out.println("    fibonacci number: " + fib);
            } else {
                System.err.println("!!!! The naive algorithm and the efficient algorithm produced two different numbers: " + fib + " and " + fib2);
                System.exit(1);
            }

            System.out.println("----------------------");
        }

    }
}
