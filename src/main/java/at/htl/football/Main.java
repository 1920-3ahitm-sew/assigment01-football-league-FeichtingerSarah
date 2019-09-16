package at.htl.football;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        League league = new League();
        List lines = readTable();

        for (int i  = 1; i < lines.size(); i++) {
            String [] line = ((String) lines.get(i)).split(";");
            Match m = new Match(line[1], line[2], Integer.parseInt(line[3]), Integer.parseInt(line[4]));

            league.addMatchResult(m);
        }
    }

    public static List<String> readTable()
    {
        Path file = Paths.get("bundesliga-1819.csv");

        try
        {
            List<String> allLines = Files.readAllLines(file);
            return allLines;
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }

        return null;
    }

    private void printTable(List<Team> teams)
    {

    }
}
