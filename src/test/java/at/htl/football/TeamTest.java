package at.htl.football;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.greaterThan;



import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class TeamTest {

    @Test
    void testTeam()
    {
        Team t = new Team("Salzburg");
        assertThat(t.getName(), is("Salzburg"));
    }

    @Test
    void addMatch()
    {
        Team t = new Team("Salzburg");
        Match m = new Match("Salzburg", "Rapid", 10, 0);
        Match n = new Match("Salzburg", "Island", 2, 3);
        Match o = new Match("Rapid", "Salzburg", 1, 5);
        Match p = new Match("Island", "Salzburg", 3, 3);

        t.addMatch(m);
        t.addMatch(n);
        t.addMatch(o);
        t.addMatch(p);

        assertThat(t.getPoints(), is(7));
        assertThat(t.getGoalsShot(), is(20));
        assertThat(t.getGoalsReceived(), is(7));
        assertThat(t.getWins(), is(2));
        assertThat(t.getDraws(), is(1));
        assertThat(t.getDefeats(), is(1));
    }

    @Test
    void compareTo()
    {
        Match m;
        Team t;
        Team u;

        t = new Team("Salzburg");
        u = new Team("Rapid");
        m = new Match("Salzburg", "Rapid", 10, 0);
        t.addMatch(m);
        u.addMatch(m);
        assertThat(t.compareTo(u), lessThan(0));
        System.out.println(t.compareTo(u));

        t = new Team("Salzburg");
        u = new Team("Rapid");
        m = new Match("Salzburg", "Rapid", 1, 1);           // natürlich absoluter Blödsinn (Salzburg gewinnt!)
        t.addMatch(m);
        u.addMatch(m);
        assertThat(t.compareTo(u), is(0));
        System.out.println(t.compareTo(u));

        t = new Team("Salzburg");
        u = new Team("Rapid");
        m = new Match("Salzburg", "Rapid", 2, 3);           // -- . --
        t.addMatch(m);
        u.addMatch(m);
        assertThat(t.compareTo(u), greaterThan(0));
        System.out.println(t.compareTo(u));
    }
}