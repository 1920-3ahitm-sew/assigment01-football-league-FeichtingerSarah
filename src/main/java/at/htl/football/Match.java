package at.htl.football;

public class Match {

    private String homeName;
    private String guestName;
    private int homeGoals;
    private int guestGoals;

    private int homePoints;
    private int guestPoints;

    public Match(String homeName, String guestName, int homeGoals, int guestGoals)
    {
        this.homeName = homeName;
        this.guestName = guestName;
        this.homeGoals = homeGoals;
        this.guestGoals = guestGoals;
    }

    public String getHomeName() {
        return homeName;
    }

    public String getGuestName() {
        return guestName;
    }

    public int getHomeGoals() {
        return homeGoals;
    }

    public int getGuestGoals() {
        return guestGoals;
    }

    public int getHomePoints() {
        if (getHomeGoals() > getGuestGoals())
        {
            return 1;
        }
        else if (getHomeGoals() == getGuestGoals())
        {
            return 0;
        }
        else
        {
            return -1;
        }
    }

    public int getGuestPoints() {
        if (getGuestGoals() > getHomeGoals())
        {
            return 1;
        }
        else if (getGuestGoals() == getHomeGoals())
        {
            return 0;
        }
        else
        {
            return -1;
        }
    }
}
