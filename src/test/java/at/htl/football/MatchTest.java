package at.htl.football;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class MatchTest {

    @Test
    void testMatch()
    {
        Match m = new Match("Salzburg", "Rapid", 10, 0);
        assertThat(m.getHomeName(), is("Salzburg"));
        assertThat(m.getGuestName(), is("Rapid"));
        assertThat(m.getHomeGoals(), is(10));
        assertThat(m.getGuestGoals(), is(0));
    }
}