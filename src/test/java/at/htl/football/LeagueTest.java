package at.htl.football;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.greaterThan;



import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class LeagueTest {

    @Test
    void addMatchResult()
    {
        League l = new League();
        Match m = new Match("Salzburg", "Rapid", 10, 0);
        Match n = new Match("Rapid", "Salzburg", 2, 6);

        l.addMatchResult(m);
        l.addMatchResult(n);

        List<Team> t = l.getTable();

        assertThat(t.get(0).getName(), is("Salzburg"));
        assertThat(t.get(1).getName(), is("Rapid"));
        assertThat(t.size(), is(2));

    }
}