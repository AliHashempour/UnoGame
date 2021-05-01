/**
 * this class represents the action cards such as A  B  8  2  10  7  8
 * @author ALi.Hashempour
 * @version 1.0
 * this class inherits from Class card
 */

public class dynamicCard extends Card {
    /**
     * we pass the color and the grade of the card to this
     *
     * @param color the color we pass
     * @param symbol the symbol we pass like 8 A B 3
     */
    public dynamicCard(String color, String symbol) {
        super(color, symbol);
    }

}
