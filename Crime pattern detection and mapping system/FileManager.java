package model;

import java.io.*;
import java.util.*;

public class FileManager {
    private static final String FILE_PATH = "crimes.csv";

    public static void saveCrime(Crime crime) throws IOException {
        FileWriter writer = new FileWriter(FILE_PATH, true);
        writer.write(String.format("%s,%s,%s,%s,%s\n",
                crime.getId(), crime.getType(), crime.getLocation(), crime.getDate(), crime.getDescription()));
        writer.close();
    }

    public static List<Crime> readCrimes() throws IOException {
        List<Crime> crimes = new ArrayList<>();
        File file = new File(FILE_PATH);
        if (!file.exists()) return crimes;

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",", 5);
            if (data.length == 5) {
                crimes.add(new Crime(data[0], data[1], data[2], data[3], data[4]));
            }
        }
        reader.close();
        return crimes;
    }

    public static void overwriteCrimes(List<Crime> crimes) throws IOException {
        FileWriter writer = new FileWriter(FILE_PATH);
        for (Crime c : crimes) {
            writer.write(String.format("%s,%s,%s,%s,%s\n",
                    c.getId(), c.getType(), c.getLocation(), c.getDate(), c.getDescription()));
        }
        writer.close();
    }

    public static boolean updateCrime(String id, String newType, String newLocation, String newDate, String newDesc) throws IOException {
        List<Crime> crimes = readCrimes();
        boolean found = false;

        for (Crime c : crimes) {
            if (c.getId().equals(id)) {
                c.setType(newType);
                c.setLocation(newLocation);
                c.setDate(newDate);
                c.setDescription(newDesc);
                found = true;
                break;
            }
        }

        if (found) overwriteCrimes(crimes);
        return found;
    }

    public static boolean deleteCrime(String id) throws IOException {
        List<Crime> crimes = readCrimes();
        boolean removed = crimes.removeIf(c -> c.getId().equals(id));
        if (removed) overwriteCrimes(crimes);
        return removed;
    }

    public static void exportReport(String content) throws IOException {
        FileWriter writer = new FileWriter("crime_report.txt");
        writer.write(content);
        writer.close();
    }
}
