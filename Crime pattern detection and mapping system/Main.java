package model;

import java.io.IOException;
import java.util.*;

public class Main {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Login
        System.out.println(" Login Required");
        System.out.print("Username: ");
        String uname = scanner.nextLine();
        System.out.print("Password: ");
        String pass = scanner.nextLine();

        if (!USERNAME.equals(uname) || !PASSWORD.equals(pass)) {
            System.out.println(" Invalid credentials. Exiting...");
            return;
        }

        System.out.println(" Login successful! Welcome, Jasmin ");

        while (true) {
            System.out.println("\n🚨 Crime Pattern Detection System ");
            System.out.println("1. Add Crime");
            System.out.println("2. View All Crimes");
            System.out.println("3. Analyze Top Crime Locations");
            System.out.println("4. Show Crime Bar Chart");
            System.out.println("5. Show Crime Percentage Chart");
            System.out.println("6. Open Top Location in Google Maps");
            System.out.println("7. Search Crimes (by Location or Type)");
            System.out.println("8. Sort Crimes by Date");
            System.out.println("9. Crime Type Frequency");
            System.out.println("10. Update Crime by ID");
            System.out.println("11. Delete Crime by ID");
            System.out.println("12. Export Report to Text File");
            System.out.println("13. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // eat newline

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Crime ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Type: ");
                        String type = scanner.nextLine();
                        System.out.print("Location: ");
                        String loc = scanner.nextLine();
                        System.out.print("Date (YYYY-MM-DD): ");
                        String date = scanner.nextLine();
                        System.out.print("Description: ");
                        String desc = scanner.nextLine();

                        Crime crime = new Crime(id, type, loc, date, desc);
                        FileManager.saveCrime(crime);
                        System.out.println("Crime saved.");
                        break;

                    case 2:
                        List<Crime> crimes = FileManager.readCrimes();
                        if (crimes.isEmpty()) {
                            System.out.println(" No crimes found.");
                        } else {
                            for (Crime c : crimes) {
                                System.out.println(c);
                            }
                        }
                        break;

                    case 3: CrimeAnalyzer.showCrimeByLocation(); break;
                    case 4: CrimeAnalyzer.showCrimeChart(); break;
                    case 5: CrimeAnalyzer.showPercentageChart(); break;
                    case 6: CrimeAnalyzer.openTopLocationInMaps(); break;
                    case 7: CrimeAnalyzer.searchCrimes(); break;
                    case 8: CrimeAnalyzer.sortCrimesByDate(); break;
                    case 9: CrimeAnalyzer.showCrimeTypeFrequency(); break;
                    case 10: CrimeAnalyzer.updateCrimeById(); break;
                    case 11: CrimeAnalyzer.deleteCrimeById(); break;
                    case 12: CrimeAnalyzer.exportReport(); break;

                    case 13:
                        System.out.println("Exiting... Goodbye Jasmin!");
                        return;

                    default:
                        System.out.println(" Invalid option.");
                }
            } catch (IOException e) {
                System.out.println(" File error: " + e.getMessage());
            }
        }
    }
}
