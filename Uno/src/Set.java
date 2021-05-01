import java.util.ArrayList;
import java.util.Collections;


/**
 * represents a set of cards
 *
 * @author ALi.Hashempour
 * @version 1.0
 */

public class Set {

    private ArrayList<Card> allCards;

    /**
     * constructor for the class
     */
    public Set() {
        this.allCards = new ArrayList<>();

    }

    /**
     * adds a card to the arraylist of cards that we have
     *
     * @param card the card we pass
     */

    public void addCart(Card card) {
        allCards.add(card);

    }

    /**
     * removes a card frome our array list
     *
     * @param card the card we pass
     */

    public void removeCard(Card card) {
        allCards.remove(card);

    }

    /**
     * it returns the last index of our set
     *
     * @return
     */

    public int lastIndex() {
        return (allCards.size() - 1);
    }

    /**
     * we pass it the color and the symbol of the card and it checks that if the player can play that card or not
     * @param color the color of the card
     * @param symbol the symbol
     * @return returns a boolean
     */

    public boolean validToPush(String color, String symbol) {
        boolean bool = false;
        if (allCards.get(lastIndex()).getSymbol().equalsIgnoreCase(symbol) ||
                allCards.get(lastIndex()).getColor().equalsIgnoreCase(color)) {
            bool = true;
        }
        return bool;
    }


    /**
     * it shuffles our set of cards
     */
    public void shuffleSet() {
        Collections.shuffle(allCards);
    }


    /**
     * it prints our set of cards
     */

    public void printSet() {
        String Blue = "\u001B[34m";
        String Red = "\u001B[31m";
        String Green = "\u001B[32m";
        String Purple = "\u001B[35m";
        String Reset = "\u001B[0m";

        int i;
        for (i = 0; i < allCards.size() - 1; i++) {
            switch (allCards.get(i).getColor()) {
                case "Blue" -> System.out.print(Blue + "┍━━━━");
                case "Red" -> System.out.print(Red + "┍━━━━");
                case "Green" -> System.out.print(Green + "┍━━━━");
                case "Purple" -> System.out.print(Purple + "┍━━━━");
            }
        }
        switch (allCards.get(i).getColor()) {
            case "Blue" -> System.out.print(Blue + "┍━━━━━━━━┑");
            case "Red" -> System.out.print(Red + "┍━━━━━━━━┑");
            case "Green" -> System.out.print(Green + "┍━━━━━━━━┑");
            case "Purple" -> System.out.print(Purple + "┍━━━━━━━━┑");
        }

        System.out.println();
        int j;
        for (j = 0; j < allCards.size() - 1; j++) {
            switch (allCards.get(j).getColor()) {
                case "Blue" -> System.out.print(Blue + "|" + allCards.get(j).getSymbol() + "    ");
                case "Red" -> System.out.print(Red + "|" + allCards.get(j).getSymbol() + "   ");
                case "Green" -> System.out.print(Green + "|" + allCards.get(j).getSymbol() + "   ");
                case "Purple" -> System.out.print(Purple + "|" + allCards.get(j).getSymbol() + "   ");
            }
        }
        switch (allCards.get(j).getColor()) {
            case "Blue" -> System.out.print(Blue + "|" + allCards.get(j).getSymbol() + "     |");
            case "Red" -> System.out.print(Red + "|" + allCards.get(j).getSymbol() + "     |");
            case "Green" -> System.out.print(Green + "|" + allCards.get(j).getSymbol() + "     |");
            case "Purple" -> System.out.print(Purple + "|" + allCards.get(j).getSymbol() + "     |");
        }
        System.out.println();
        int k;
        for (k = 0; k < allCards.size() - 1; k++) {
            switch (allCards.get(k).getColor()) {
                case "Blue" -> System.out.print(Blue + "|    ");
                case "Red" -> System.out.print(Red + "|    ");
                case "Green" -> System.out.print(Green + "|    ");
                case "Purple" -> System.out.print(Purple + "|    ");
            }
        }
        switch (allCards.get(k).getColor()) {
            case "Blue" -> System.out.print(Blue + "|" + "        |");
            case "Red" -> System.out.print(Red + "|" + "        |");
            case "Green" -> System.out.print(Green + "|" + "        |");
            case "Purple" -> System.out.print(Purple + "|" + "        |");
        }
        System.out.println();
        int l;
        for (l = 0; l < allCards.size() - 1; l++) {
            switch (allCards.get(l).getColor()) {
                case "Blue" -> System.out.print(Blue + "|" + "    ");
                case "Red" -> System.out.print(Red + "|" + "    ");
                case "Green" -> System.out.print(Green + "|" + "    ");
                case "Purple" -> System.out.print(Purple + "|" + "    ");
            }
        }
        switch (allCards.get(l).getColor()) {
            case "Blue" -> System.out.print(Blue + "|" + "       " + allCards.get(l).getSymbol() + "|");
            case "Red" -> System.out.print(Red + "|" + "       " + allCards.get(l).getSymbol() + "|");
            case "Green" -> System.out.print(Green + "|" + "       " + allCards.get(l).getSymbol() + "|");
            case "Purple" -> System.out.print(Purple + "|" + "       " + allCards.get(l).getSymbol() + "|");
        }
        System.out.println();
        int m;
        for (m = 0; m < allCards.size() - 1; m++) {
            switch (allCards.get(m).getColor()) {
                case "Blue" -> System.out.print(Blue + "┕━━━━");
                case "Red" -> System.out.print(Red + "┕━━━━");
                case "Green" -> System.out.print(Green + "┕━━━━");
                case "Purple" -> System.out.print(Purple + "┕━━━━");
            }
        }
        switch (allCards.get(m).getColor()) {
            case "Blue" -> System.out.print(Blue + "┕━━━━━━━━┙" + Reset);
            case "Red" -> System.out.print(Red + "┕━━━━━━━━┙" + Reset);
            case "Green" -> System.out.print(Green + "┕━━━━━━━━┙" + Reset);
            case "Purple" -> System.out.print(Purple + "┕━━━━━━━━┙" + Reset);
        }
        System.out.println();
    }

    /**
     * its a getter for our set cards
     * @return
     */

    public ArrayList<Card> getAllCards() {
        return allCards;
    }


}
