package at.htl.football;

import java.util.List;

public class League {
    private List<Team> teams;

    public void addMatchResult(Match m)
    {
        Team homeTeam = findOrCreateTeam(m.getHomeName());
        homeTeam.addMatch(m);
    }

    private Team findOrCreateTeam(String teamName)
    {
        for (int i = 0; i < teams.size(); i++) {
            if (teams.get(i).getName().equals(teamName))
            {
                return teams.get(i);
            }
        }

        teams.add(new Team(teamName));
        return teams.get(teams.size()-1);
    }

    public List<Team> getTable()
    {
        return this.teams;
    }
}
