import repository.DatabaseRepository;
import service.BusinessLogic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class Main {
    private static final DatabaseRepository databaseRepository = new DatabaseRepository();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long timeStarted = System.currentTimeMillis();

        ExecutorService executor = Executors.newFixedThreadPool(4);
        List<Future<Void>> futures = new ArrayList<>();

        List<String> sentences = databaseRepository.findDataFromDatabase();
        for (String sentence : sentences) {
            futures.add(executor.submit(() -> BusinessLogic.fibSentence(sentence)));

        }

        for (Future<Void> future : futures) {
            future.get();
        }

        executor.shutdown();

        long timeEnded = System.currentTimeMillis();
        long timeTakenToExecute = (timeEnded - timeStarted);
        System.out.printf("Time Taken to complete our logic. %s milliseconds", timeTakenToExecute);
    }


}