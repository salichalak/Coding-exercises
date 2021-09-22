package P09_ArraysMoreExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        long[] fibonaccies = new long[n + 1];
        fibonaccies[0] = 0;
        if (n != 0) {
            fibonaccies[1] = 1;
        }
        for (int i = 2; i <= n; i++) {
            fibonaccies[i] = -1;
        }
        long fib8 = fibonacci(n,fibonaccies);
        System.out.println(fib8);
    }

    public static long fibonacci(int n, long[] fibonaccies){
        if (fibonaccies[n] != -1){
            return fibonaccies[n];
        }
        long prev = fibonacci(n - 1, fibonaccies);
        long prevPrev = fibonacci(n - 2, fibonaccies);
        long result = prev + prevPrev;
        fibonaccies[n] = result;
        return result;
    }
}