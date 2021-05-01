import java.util.ArrayList;


/**
 * this class represents a robot in our game
 * this class inherits from Player class
 *
 * @author ALi.Hashempour
 * @version 1.0
 */
public class Robot extends Player {
    private String name;
    private ArrayList<Card> robotCards;
    private int totalScore;


    /**
     * constructor for this class
     *
     * @param name
     */
    public Robot(String name) {
        super(name);
        this.robotCards = new ArrayList<>();
        this.name = name;
    }

    @Override
    /**
     * adds a card to the robot's array list of cards
     *
     * @param card
     */

    public void addCart(Card card) {
        robotCards.add(card);
    }

    @Override
    /**
     * removes a card from the robot's array list of cards
     *
     * @param card
     */

    public void removeCart(Card card) {
        robotCards.remove(card);
    }


    /**
     * getter for robot cards
     *
     * @return robot cards
     */
    public ArrayList<Card> getPlayerCards() {
        return robotCards;
    }


    /**
     * getter for score
     *
     * @return
     */
    public int getTotalScore() {
        return totalScore;
    }


    @Override
    /**
     * overriding the calculate score method
     *
     * @return
     */
    public int calculateScore() {
        int score = 0;
        for (Card robotCard : robotCards) {
            score += Integer.parseInt(robotCard.getEmtiaz());
        }
        totalScore = score;
        return score;
    }
}
