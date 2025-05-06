import java.util.*;

public class BerkeleyAlgorithmFixed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of slave nodes: ");
        int n = sc.nextInt();

        int[] clockTimes = new int[n + 1]; // [0] is master, others are slaves

        System.out.print("Enter master's clock time (in ms): ");
        clockTimes[0] = sc.nextInt();
        int originalMasterTime = clockTimes[0];  // save original master time

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter clock time for slave " + i + " (in ms): ");
            clockTimes[i] = sc.nextInt();
        }

        System.out.println("\nClock times before synchronization:");
        System.out.println("Master: " + clockTimes[0] + " ms");
        for (int i = 1; i <= n; i++) {
            System.out.println("Slave " + i + ": " + clockTimes[i] + " ms");
        }

        // Calculate total difference
        int totalDifference = 0;
        for (int i = 1; i <= n; i++) {
            totalDifference += (clockTimes[i] - originalMasterTime);
        }

        int averageDiff = totalDifference / (n + 1);

        // Update master
        clockTimes[0] = originalMasterTime + averageDiff;

        // Adjust slaves
        for (int i = 1; i <= n; i++) {
            int adjustment = averageDiff - (clockTimes[i] - originalMasterTime);
            clockTimes[i] += adjustment;
        }

        System.out.println("\nClock times after synchronization:");
        System.out.println("Master: " + clockTimes[0] + " ms");
        for (int i = 1; i <= n; i++) {
            System.out.println("Slave " + i + ": " + clockTimes[i] + " ms");
        }

        sc.close();
    }
}
