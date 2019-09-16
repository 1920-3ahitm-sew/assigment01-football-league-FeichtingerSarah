package at.htl.football;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    static League league = new League();

    public static void main(String[] args) {
        readFile();
        List<Team> sortedTeam = league.getTable();
        printTable(sortedTeam);
    }

    public static void readFile()
    {
        Path file = Paths.get("bundesliga-1819.csv");

        try
        {
            List<String> allLines = Files.readAllLines(file);

            for (int i  = 1; i < allLines.size(); i++) {
                String [] line = (allLines.get(i)).split(";");
                Match m = new Match(line[1], line[2], Integer.parseInt(line[3]), Integer.parseInt(line[4]));

                league.addMatchResult(m);
            }
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    private static void printTable(List<Team> teams)
    {
        System.out.println("Team                   Pts     W     D     L    GF    GA    GD");

        for(Team t : teams)
        {
            System.out.printf("%-20s %5d %5d %5d %5d %5d %5d %5d\n", t.getName(), t.getPoints(), t.getWins(), t.getDraws(), t.getDefeats(), t.getGoalsShot(), t.getGoalsReceived(), t.getGoalsShot() - t.getGoalsReceived());
        }

        System.out.println("Pts...Points, W...Won, D...Drawn, L...Lost\nGF...Goals for, GA...Goals agains, GD...Goal Difference");
    }
}
