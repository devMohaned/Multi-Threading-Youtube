package service;

public class BusinessLogic {
    private static final CpuIntensiveBusinessService cpuIntensiveBusinessService = new CpuIntensiveBusinessService();

    public static void fibSentence(String sentence) {
        int length = sentence.length();
        long fibonacciPerSentence = cpuIntensiveBusinessService.fibonacci(length);
        String logMessage = String.format("String: %s | Length: %d | Fibonacci: %d | Thread: %s",
                sentence, length, fibonacciPerSentence, Thread.currentThread().getName());
        System.out.println(logMessage);
    }
}
