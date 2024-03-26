package javacode;

public class NearestPrime {
    // Function to check if a number is prime
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;

        if (n % 2 == 0 || n % 3 == 0) return false;

        for (int i = 5; i * i <= n; i = i + 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean isPrime(int n, int divisor, double limitDivisor) {
        if (n <= 1) return false;
//        if (divisor <= 1) return true;
        if (n % divisor == 0) return false;
        if (divisor == limitDivisor) return true;
        return (isPrime(n, divisor + 1, limitDivisor));
    }

    // Function to find the nearest prime number
    public static int findNearestPrime(int num) {
        if (isPrime(num)) {
            return num; // If the given number is prime, return it
        }

        int smaller = num - 1;
        int larger = num + 1;

        // Find nearest prime by checking in both directions
        while (true) {
            if (isPrime(smaller)) {
                return smaller;
            } else if (isPrime(larger)) {
                return larger;
            }
            smaller--;
            larger++;
        }
    }

    public static int findNearestPrimeRecursively(int num) {
        double limitDivisor = Math.floor(Math.sqrt(num));
        if (isPrime(num, 2, limitDivisor))
            return num;

        int smaller = num - 1;
        int larger = num + 1;

        // Recursively find nearest prime by checking in both directions
        if (isPrime(smaller, 2, Math.floor(Math.sqrt(smaller))))
            return smaller;
        else if (isPrime(larger, 2, Math.floor(Math.sqrt(larger))))
            return larger;
        else {
            return findNearestPrimeRecursively(smaller);
        }
    }

    public static void main(String[] args) {
        int num = 77; // Example input
        double limitDivisor = Math.floor(Math.sqrt(num));
        int nearestPrime = findNearestPrimeRecursively(num);
        System.out.println("Square root: "+Math.floor(Math.sqrt(num)));
        System.out.println("Nearest prime to " + num + " is: " + nearestPrime);
        int divisor = 8;
        System.out.println(divisor == limitDivisor);
    }
}
