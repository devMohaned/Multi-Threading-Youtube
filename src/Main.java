import repository.DatabaseRepository;
import service.BusinessLogic;

import java.util.List;


public class Main {
    private static final DatabaseRepository databaseRepository = new DatabaseRepository();

    public static void main(String[] args) {
        long timeStarted = System.currentTimeMillis();


        List<String> sentences = databaseRepository.findDataFromDatabase();
        for (String sentence : sentences) {
            BusinessLogic.fibSentence(sentence);
        }



        long timeEnded = System.currentTimeMillis();
        long timeTakenToExecute = (timeEnded - timeStarted);
        System.out.printf("Time Taken to complete our logic. %s milliseconds", timeTakenToExecute);
    }


}