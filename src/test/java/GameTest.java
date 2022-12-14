import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class GameTest {

    Player player1 = new Player(1, "Name1", 70);
    Player player2 = new Player(2, "Name2", 60);
    Player player3 = new Player(3, "Name3", 80);
    Player player4 = new Player(4, "Name4", 70);

    @Test
    public void registered() {


    }

    @Test
    public void firstPlayerIsWinn() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);


        int excepted = 1;
        int actual = game.round("Name1", "Name2");

        Assertions.assertEquals(excepted, actual);
    }

    @Test
    public void secondPlayerIsWinn() {
        Game game = new Game();
        game.register(player1);
        game.register(player3);

        int excepted = 2;
        int actual = game.round("Name1", "Name3");

        Assertions.assertEquals(excepted, actual);
    }

    @Test
    public void neitherWinn() {
        Game game = new Game();
        game.register(player1);
        game.register(player4);

        int excepted = 0;
        int actual = game.round("Name1", "Name4");

        Assertions.assertEquals(excepted, actual);
    }

    @Test
    public void firstPlayerIsNotRegistered() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Name1", "Name3");
        });
    }

    @Test
    public void secondPlayerIsNotRegistered() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Name4", "Name2");
        });
    }

    @Test
    public void registerPlayers() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);

        List<Player> expected = Arrays.asList(player1, player2);
        List<Player> actual = game.getPlayersList();

        Assertions.assertEquals(expected, actual);
    }

}