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
            if (match.getHomeGoals() > match.getGuestGoals())
            {
                this.points = this.getPoints() + 3;
                this.wins = this.getWins() + 1;
            }
            else if (match.getHomeGoals() == match.getGuestGoals())
            {
                this.points = this.getPoints() + 1;
                this.draws = this.getDraws() + 1;
            }
            else
            {
                this.defeats = this.getDefeats() + 1;
            }

            this.goalsShot = this.getGoalsShot() + match.getHomeGoals();
            this.goalsReceived = this.getGoalsReceived() + match.getGuestGoals();
        }
        else if (this.getName().equals(match.getGuestName()))
        {
            if (match.getGuestGoals() > match.getHomeGoals())
            {
                this.points = this.getPoints() + 3;
                this.wins = this.getWins() + 1;
            }
            else if (match.getGuestGoals() == match.getHomeGoals())
            {
                this.points = this.getPoints() + 1;
                this.draws = this.getDraws() + 1;
            }
            else
            {
                this.defeats = this.getDefeats() + 1;
            }

            this.goalsShot = this.getGoalsShot() + match.getGuestGoals();
            this.goalsReceived= this.getGoalsReceived() + match.getHomeGoals();
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
            return (t.goalsShot - t.goalsReceived) - (this.goalsShot - this.goalsReceived);
        }

        return t.getPoints() - this.getPoints();
    }
}
