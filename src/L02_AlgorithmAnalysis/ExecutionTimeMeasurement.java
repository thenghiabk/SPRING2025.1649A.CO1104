package L02_AlgorithmAnalysis;

public class ExecutionTimeMeasurement {
    public static void main(String[] args) {

        int numOfLoop = 50000;
        long startTime = System.currentTimeMillis(); // get timestamps
        /* algorithm */
        // repeat1( "A", numOfLoop );
        repeat2("A", numOfLoop);
        long endTime = System.currentTimeMillis(); // get timestamps

        long elapsedTime = endTime - startTime; // nanosecond

        System.out.println("Execution time: " + elapsedTime + " (ms).");
    }

    public static String repeat1(String c, int n) {
        String answer = "";
        for (int i = 0; i < n; i++) {
            answer += c;
        }
        return answer;
    }

    public static String repeat2(String c, int n) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            answer.append(c);
        }
        return answer.toString();
    }
}
