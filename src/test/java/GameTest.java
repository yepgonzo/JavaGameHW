import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GameTest {

    Game game = new Game();
    Player player1 = new Player("Sasha", 10);
    Player player2 = new Player("Masha", 15);
    Player player3 = new Player("Dasha", 10);
    Player player4 = new Player("Pasha", 8);


    @Test
    public void addAllPlayers() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        List<Player> expected = List.of(player1, player2, player3, player4);
        List<Player> actual = game.findAll();

        assertEquals(expected, actual);
    }

    @Test
    public void findOnePlayer() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        Player expected = player1;
        Player actual = game.findPlayer("Sasha");

        assertEquals(expected, actual);
    }

    @Test
    public void unregisteredPlayers1() {
        game.register(player1);
        game.register(player2);

        assertThrows(NotRegisteredException.class, () -> {
            game.play(player3.getName(), player1.getName());
        });
    }

    @Test
    public void unregisteredPlayers2() {
        game.register(player3);
        game.register(player4);

        assertThrows(NotRegisteredException.class, () -> {
            game.play(player4.getName(), player2.getName());
        });
    }

    @Test
    public void equalStrength() {
        game.register(player1);
        game.register(player3);

        int expected = 0;
        int actual = game.play(player1.getName(), player3.getName());

        assertEquals(expected, actual);
    }

    @Test
    public void StrengthOfTheFirstPlayerIsGreater () {
        game.register(player1);
        game.register(player4);

        int expected = 1;
        int actual = game.play(player1.getName(), player4.getName());

        assertEquals(expected, actual);
    }

    @Test
    public void StrengthOfTheSecondPlayerIsGreater () {
        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.play(player1.getName(), player2.getName());

        assertEquals(expected, actual);
    }
}
