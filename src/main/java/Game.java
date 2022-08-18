import java.util.ArrayList;

public class Game {
    protected ArrayList<Player> players = new ArrayList<>();

    public ArrayList<Player> findAll() {
        return players;
    }

    public void register(Player player) {
        players.add(player);
    }

    public Player findPlayer(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public int play(String playerName1, String playerName2) {
        Player player1 = findPlayer(playerName1);
        Player player2 = findPlayer(playerName2);

        if (player1 == null) {
            throw new NotRegisteredException("Игрок " + playerName1 + "не найден");
        }
        if (player2 == null) {
            throw new NotRegisteredException("Игрок " + playerName2 + "не найден");
        }

        if (player1.getStrength() == player2.getStrength()) {
            return 0;
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else {
            return 2;
        }
    }
}