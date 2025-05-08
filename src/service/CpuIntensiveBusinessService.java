package service;

public class CpuIntensiveBusinessService {

    // Our logical CPU-Intesive algorithm
    public long fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
