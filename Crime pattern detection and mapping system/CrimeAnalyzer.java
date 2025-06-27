package model;

import java.io.IOException;
import java.util.*;
import java.awt.Desktop;
import java.net.URI;

public class CrimeAnalyzer {

    public static void showCrimeByLocation() {
        try {
            List<Crime> crimes = FileManager.readCrimes();
            if (crimes.isEmpty()) {
                System.out.println(" No crimes to analyze.");
                return;
            }

            Map<String, Integer> locationCount = new HashMap<>();
            for (Crime crime : crimes) {
                String location = crime.getLocation();
                locationCount.put(location, locationCount.getOrDefault(location, 0) + 1);
            }

            System.out.println(" Crime Count by Location:");
            for (Map.Entry<String, Integer> entry : locationCount.entrySet()) {
                System.out.println(entry.getKey() + " ➜ " + entry.getValue() + " crimes");
            }

            String topLocation = Collections.max(locationCount.entrySet(), Map.Entry.comparingByValue()).getKey();
            int max = locationCount.get(topLocation);
            System.out.println("\n🔥 Most Dangerous Area: " + topLocation + " (" + max + " crimes)");

        } catch (IOException e) {
            System.out.println("⚠️ Error analyzing crimes: " + e.getMessage());
        }
    }

    public static void showCrimeChart() {
        try {
            List<Crime> crimes = FileManager.readCrimes();
            if (crimes.isEmpty()) {
                System.out.println(" No crimes to chart.");
                return;
            }

            Map<String, Integer> locationCount = new HashMap<>();
            for (Crime crime : crimes) {
                String location = crime.getLocation();
                locationCount.put(location, locationCount.getOrDefault(location, 0) + 1);
            }

            System.out.println("\n📊 Crime Bar Chart:\n");
            for (Map.Entry<String, Integer> entry : locationCount.entrySet()) {
                String bar = "*".repeat(entry.getValue());
                System.out.println(entry.getKey() + ": " + bar + " (" + entry.getValue() + ")");
            }

        } catch (IOException e) {
            System.out.println("⚠️ Error: " + e.getMessage());
        }
    }

    public static void openTopLocationInMaps() {
        try {
            List<Crime> crimes = FileManager.readCrimes();
            if (crimes.isEmpty()) {
                System.out.println("No crimes to map.");
                return;
            }

            Map<String, Integer> locationCount = new HashMap<>();
            for (Crime crime : crimes) {
                String location = crime.getLocation();
                locationCount.put(location, locationCount.getOrDefault(location, 0) + 1);
            }

            String topLocation = Collections.max(locationCount.entrySet(), Map.Entry.comparingByValue()).getKey();
            String mapsUrl = "https://www.google.com/maps/search/" + topLocation.replace(" ", "+");
            System.out.println(" Opening Google Maps for: " + topLocation);
            Desktop.getDesktop().browse(new URI(mapsUrl));

        } catch (Exception e) {
            System.out.println(" Couldn't open browser: " + e.getMessage());
        }
    }

    public static void searchCrimes() {
        try {
            List<Crime> crimes = FileManager.readCrimes();
            if (crimes.isEmpty()) {
                System.out.println(" No crimes to search.");
                return;
            }

            Scanner sc = new Scanner(System.in);
            System.out.print(" Enter location or type to search: ");
            String input = sc.nextLine().toLowerCase();

            boolean found = false;
            for (Crime crime : crimes) {
                if (crime.getLocation().toLowerCase().contains(input) ||
                        crime.getType().toLowerCase().contains(input)) {
                    System.out.println(crime);
                    found = true;
                }
            }

            if (!found) {
                System.out.println(" No matching crimes found.");
            }

        } catch (IOException e) {
            System.out.println(" Error: " + e.getMessage());
        }
    }

    public static void showPercentageChart() {
        try {
            List<Crime> crimes = FileManager.readCrimes();
            if (crimes.isEmpty()) {
                System.out.println(" No crimes to chart.");
                return;
            }

            Map<String, Integer> locationCount = new HashMap<>();
            for (Crime crime : crimes) {
                String location = crime.getLocation();
                locationCount.put(location, locationCount.getOrDefault(location, 0) + 1);
            }

            int total = crimes.size();
            System.out.println("\n📈 Crime Percentage Chart:\n");
            for (Map.Entry<String, Integer> entry : locationCount.entrySet()) {
                double percent = (entry.getValue() * 100.0) / total;
                System.out.printf("%s: %.1f%% (%d crimes)\n", entry.getKey(), percent, entry.getValue());
            }

        } catch (IOException e) {
            System.out.println(" Error: " + e.getMessage());
        }
    }

    public static void sortCrimesByDate() {
        try {
            List<Crime> crimes = FileManager.readCrimes();
            if (crimes.isEmpty()) {
                System.out.println(" No crimes to sort.");
                return;
            }

            crimes.sort(Comparator.comparing(Crime::getDate));
            System.out.println("\n Crimes Sorted by Date:\n");
            for (Crime crime : crimes) {
                System.out.println(crime);
            }

        } catch (IOException e) {
            System.out.println(" Error: " + e.getMessage());
        }
    }

    public static void showCrimeTypeFrequency() {
        try {
            List<Crime> crimes = FileManager.readCrimes();
            if (crimes.isEmpty()) {
                System.out.println("No crimes to analyze.");
                return;
            }

            Map<String, Integer> typeCount = new HashMap<>();
            for (Crime crime : crimes) {
                String type = crime.getType();
                typeCount.put(type, typeCount.getOrDefault(type, 0) + 1);
            }

            System.out.println("\n Crime Type Frequency:\n");
            for (Map.Entry<String, Integer> entry : typeCount.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

        } catch (IOException e) {
            System.out.println(" Error: " + e.getMessage());
        }
    }

    public static void updateCrimeById() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Crime ID to update: ");
            String id = sc.nextLine();
            System.out.print("New Type: ");
            String type = sc.nextLine();
            System.out.print("New Location: ");
            String loc = sc.nextLine();
            System.out.print("New Date (YYYY-MM-DD): ");
            String date = sc.nextLine();
            System.out.print("New Description: ");
            String desc = sc.nextLine();

            boolean updated = FileManager.updateCrime(id, type, loc, date, desc);
            if (updated) {
                System.out.println(" Crime updated.");
            } else {
                System.out.println(" Crime ID not found.");
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void deleteCrimeById() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Crime ID to delete: ");
            String id = sc.nextLine();
            boolean deleted = FileManager.deleteCrime(id);
            if (deleted) {
                System.out.println(" Crime deleted.");
            } else {
                System.out.println(" Crime ID not found.");
            }

        } catch (IOException e) {
            System.out.println(" Error: " + e.getMessage());
        }
    }

    public static void exportReport() {
        try {
            List<Crime> crimes = FileManager.readCrimes();
            if (crimes.isEmpty()) {
                System.out.println(" No data to export.");
                return;
            }

            StringBuilder sb = new StringBuilder();
            sb.append(" Crime Report\n\n");
            for (Crime crime : crimes) {
                sb.append(crime.toString()).append("\n");
            }

            FileManager.exportReport(sb.toString());
            System.out.println(" Report exported to crime_report.txt");

        } catch (IOException e) {
            System.out.println("Error exporting: " + e.getMessage());
        }
    }
}
