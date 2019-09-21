package at.htl.football;

public class Team implements Comparable<Team>{

    private String name;
    private int points;
    private int wins;
    private int draws;
    private int defeats;
    private int goalsShot;
    private int goalsReceived;

    public Team(String name)
    {
        this.name = name;
    }


    public void addMatch(Match match)
    {
        if (this.getName().equals(match.getHomeName()))
        {
            givePoints(match.getHomePoints());

            this.goalsShot = this.getGoalsShot() + match.getHomeGoals();
            this.goalsReceived = this.getGoalsReceived() + match.getGuestGoals();
        }
        else if (this.getName().equals(match.getGuestName()))
        {
            givePoints(match.getGuestPoints());

            this.goalsShot = this.getGoalsShot() + match.getGuestGoals();
            this.goalsReceived= this.getGoalsReceived() + match.getHomeGoals();
        }
    }

    public void givePoints(int p)
    {
        if (p == 1)
        {
            this.points = this.getPoints() + 3;
            this.wins = this.getWins() + 1;
        }
        else if (p == 0)
        {
            this.points = this.getPoints() + 1;
            this.draws = this.getDraws() + 1;
        }
        else
        {
            this.defeats = this.getDefeats() + 1;
        }
    }


    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public int getWins() {
        return wins;
    }

    public int getDraws() {
        return draws;
    }

    public int getDefeats() {
        return defeats;
    }

    public int getGoalsShot() {
        return goalsShot;
    }

    public int getGoalsReceived() {
        return goalsReceived;
    }



    public int compareTo(Team t)
    {
        if (t.getPoints() - this.getPoints() == 0) {
            return (t.getGoalsShot() - t.getGoalsReceived()) - (this.getGoalsShot() - this.getGoalsReceived());
        }

        return t.getPoints() - this.getPoints();
    }
}
