package at.htl.football;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class League {
    private List<Team> teams = new ArrayList<>();

    public void addMatchResult(Match m)
    {
        Team homeTeam = findOrCreateTeam(m.getHomeName());
        Team guestTeam = findOrCreateTeam(m.getGuestName());
        homeTeam.addMatch(m);
        guestTeam.addMatch(m);
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
        Collections.sort(teams);
        return teams;
    }
}
