import java.util.ArrayList;

/**
 * this class represents a player in our game
 *
 * @author ALi.Hashempour
 * @version 1.0
 */
public class Player {
    private String name;
    private ArrayList<Card> playerCards;
    private int totalScore;


    /**
     * constructor for this class
     *
     * @param name the name
     */
    public Player(String name) {
        this.playerCards = new ArrayList<>();
        this.name = name;
    }


    /**
     * adds a card to the player's array list of cards
     *
     * @param card the card we pass
     */
    public void addCart(Card card) {
        playerCards.add(card);
    }

    /**
     * removes a card from the player's array list of cards
     *
     * @param card the card we pass
     */

    public void removeCart(Card card) {
        playerCards.remove(card);
    }


    /**
     * getter for the player name
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * getter for the player array list of cards
     *
     * @return
     */
    public ArrayList<Card> getPlayerCards() {
        return playerCards;
    }

    /**
     * this method prints the cards of player's set
     */
    public void printPlayerSet() {
        String Blue = "\u001B[34m";
        String Red = "\u001B[31m";
        String Green = "\u001B[32m";
        String Purple = "\u001B[35m";
        String Reset = "\u001B[0m";

        int i;
        for (i = 0; i < playerCards.size() - 1; i++) {
            switch (playerCards.get(i).getColor()) {
                case "Blue" -> System.out.print(Blue + "┍━━━━");
                case "Red" -> System.out.print(Red + "┍━━━━");
                case "Green" -> System.out.print(Green + "┍━━━━");
                case "Purple" -> System.out.print(Purple + "┍━━━━");
            }
        }
        switch (playerCards.get(i).getColor()) {
            case "Blue" -> System.out.print(Blue + "┍━━━━━━━━┑");
            case "Red" -> System.out.print(Red + "┍━━━━━━━━┑");
            case "Green" -> System.out.print(Green + "┍━━━━━━━━┑");
            case "Purple" -> System.out.print(Purple + "┍━━━━━━━━┑");
        }

        System.out.println();
        int j;
        for (j = 0; j < playerCards.size() - 1; j++) {
            switch (playerCards.get(j).getColor()) {
                case "Blue" -> System.out.print(Blue + "|" + playerCards.get(j).getSymbol() + "   ");
                case "Red" -> System.out.print(Red + "|" + playerCards.get(j).getSymbol() + "   ");
                case "Green" -> System.out.print(Green + "|" + playerCards.get(j).getSymbol() + "   ");
                case "Purple" -> System.out.print(Purple + "|" + playerCards.get(j).getSymbol() + "   ");
            }
        }
        switch (playerCards.get(j).getColor()) {
            case "Blue" -> System.out.print(Blue + "|" + playerCards.get(j).getSymbol() + "       |");
            case "Red" -> System.out.print(Red + "|" + playerCards.get(j).getSymbol() + "       |");
            case "Green" -> System.out.print(Green + "|" + playerCards.get(j).getSymbol() + "       |");
            case "Purple" -> System.out.print(Purple + "|" + playerCards.get(j).getSymbol() + "       |");
        }
        System.out.println();
        int k;
        for (k = 0; k < playerCards.size() - 1; k++) {
            switch (playerCards.get(k).getColor()) {
                case "Blue" -> System.out.print(Blue + "|    ");
                case "Red" -> System.out.print(Red + "|    ");
                case "Green" -> System.out.print(Green + "|    ");
                case "Purple" -> System.out.print(Purple + "|    ");
            }
        }
        switch (playerCards.get(k).getColor()) {
            case "Blue" -> System.out.print(Blue + "|" + "        |");
            case "Red" -> System.out.print(Red + "|" + "        |");
            case "Green" -> System.out.print(Green + "|" + "        |");
            case "Purple" -> System.out.print(Purple + "|" + "        |");
        }
        System.out.println();
        int l;
        for (l = 0; l < playerCards.size() - 1; l++) {
            switch (playerCards.get(l).getColor()) {
                case "Blue" -> System.out.print(Blue + "|" + "    ");
                case "Red" -> System.out.print(Red + "|" + "    ");
                case "Green" -> System.out.print(Green + "|" + "    ");
                case "Purple" -> System.out.print(Purple + "|" + "    ");
            }
        }
        switch (playerCards.get(l).getColor()) {
            case "Blue" -> System.out.print(Blue + "|" + "       " + playerCards.get(l).getSymbol() + "|");
            case "Red" -> System.out.print(Red + "|" + "       " + playerCards.get(l).getSymbol() + "|");
            case "Green" -> System.out.print(Green + "|" + "      " + playerCards.get(l).getSymbol() + "|");
            case "Purple" -> System.out.print(Purple + "|" + "       " + playerCards.get(l).getSymbol() + "|");
        }
        System.out.println();
        int m;
        for (m = 0; m < playerCards.size() - 1; m++) {
            switch (playerCards.get(m).getColor()) {
                case "Blue" -> System.out.print(Blue + "┕━━━━");
                case "Red" -> System.out.print(Red + "┕━━━━");
                case "Green" -> System.out.print(Green + "┕━━━━");
                case "Purple" -> System.out.print(Purple + "┕━━━━");
            }
        }
        switch (playerCards.get(m).getColor()) {
            case "Blue" -> System.out.print(Blue + "┕━━━━━━━━┙" + Reset);
            case "Red" -> System.out.print(Red + "┕━━━━━━━━┙" + Reset);
            case "Green" -> System.out.print(Green + "┕━━━━━━━━┙" + Reset);
            case "Purple" -> System.out.print(Purple + "┕━━━━━━━━┙" + Reset);
        }
        System.out.println();

    }


    /**
     * getter for the total score of the player
     *
     * @return
     */
    public int getTotalScore() {
        return totalScore;
    }

    /**
     * calculates the score of the player and returns it
     */

    public int calculateScore() {
        int score = 0;
        for (Card playerCard : playerCards) {
            score += Integer.parseInt(playerCard.getEmtiaz());
        }
        totalScore = score;
        return score;
    }

}
