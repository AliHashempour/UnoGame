import java.util.Random;

/**
 * this class represents a card
 * @author ali hashem
 * @version 1.0
 */
public class Card {
    private String color;
    private String emtiaz;
    private String symbol;

    /**
     * we pass the color and the grade of the card to this
     *
     * @param color is the color we pass
     * @param emtiaz is the score we pass it can be like A or C or 4 ..it will be handled in constructor
     */
    public Card(String color, String emtiaz) {
        this.color = color;
        if (emtiaz.equals("A")) {
            this.emtiaz = "11";
            this.symbol = emtiaz;
        } else if (emtiaz.equals("B")) {
            this.emtiaz = "12";
            this.symbol = emtiaz;
        } else if (emtiaz.equals("C")) {
            this.emtiaz = "12";
            this.symbol = emtiaz;
        } else if (emtiaz.equals("D")) {
            this.emtiaz = "13";
            this.symbol = emtiaz;
        } else {
            this.emtiaz = emtiaz;
            this.symbol = emtiaz;
        }
    }

    /**
     * overloading the constructor
     * we pass the color and the grade of the card to this
     *
     * @param color is the color we pass
     * @param emtiaz is the score we pass
     */

    public Card(String color, int emtiaz) {
        this.color = color;
        this.emtiaz = Integer.toString(emtiaz);
        this.symbol = Integer.toString(emtiaz);

    }


    /**
     * getter for the color
     * @return color
     */
    public String getColor() {
        return color;
    }

    /**
     * getter for the score
     * @return score
     */
    public String getEmtiaz() {
        return emtiaz;
    }

    /**
     * getter for the symbol
     * @return symbol
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * this method prints the card completely
     */
    public void printCompleteCard() {
        String ANSI_BLUE = "\u001B[34m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_GREEN = "\u001B[32m";
        String ANSI_PURPLE = "\u001B[35m";
        String ANSI_RESET = "\u001B[0m";

        switch (color) {
            case "Blue":
                if (emtiaz.equals("10")) {
                    System.out.print(ANSI_BLUE + "┍━━━━━━━━┑" + "\n");
                    System.out.println("|" + symbol + "\t\t |");
                    System.out.println("|\t\t |");
                    System.out.println("|" + "\t   " + symbol + "|");
                    System.out.print(ANSI_BLUE + "┕━━━━━━━━┙" + ANSI_RESET + "\n");
                } else {
                    System.out.print(ANSI_BLUE + "┍━━━━━━━━┑" + "\n");
                    System.out.println("| " + symbol + "\t\t |");
                    System.out.println("|\t\t |");
                    System.out.println("|" + "\t   " + symbol + " |");
                    System.out.print(ANSI_BLUE + "┕━━━━━━━━┙" + ANSI_RESET + "\n");
                }
                break;
            case "Green":
                if (emtiaz.equals("10")) {
                    System.out.print(ANSI_GREEN + "┍━━━━━━━━┑" + "\n");
                    System.out.println("|" + symbol + "\t\t |");
                    System.out.println("|\t\t |");
                    System.out.println("|" + "\t   " + symbol + "|");
                    System.out.print(ANSI_GREEN + "┕━━━━━━━━┙" + ANSI_RESET + "\n");
                } else {
                    System.out.print(ANSI_GREEN + "┍━━━━━━━━┑" + "\n");
                    System.out.println("| " + symbol + "\t\t |");
                    System.out.println("|\t\t |");
                    System.out.println("|" + "\t   " + symbol + " |");
                    System.out.print(ANSI_GREEN + "┕━━━━━━━━┙" + ANSI_RESET + "\n");
                }
                break;
            case "Red":
                if (emtiaz.equals("10")) {
                    System.out.print(ANSI_RED + "┍━━━━━━━━┑" + "\n");
                    System.out.println("|" + symbol + "\t\t |");
                    System.out.println("|\t\t |");
                    System.out.println("|" + "\t   " + symbol + "|");
                    System.out.print(ANSI_RED + "┕━━━━━━━━┙" + ANSI_RESET + "\n");
                } else {
                    System.out.print(ANSI_RED + "┍━━━━━━━━┑" + "\n");
                    System.out.println("| " + symbol + "\t\t |");
                    System.out.println("|\t\t |");
                    System.out.println("|" + "\t   " + symbol + " |");
                    System.out.print(ANSI_RED + "┕━━━━━━━━┙" + ANSI_RESET + "\n");
                }
                break;
            case "Purple":
                if (emtiaz.equals("10")) {
                    System.out.print(ANSI_PURPLE +"┍━━━━━━━━┑" + "\n");
                    System.out.println(ANSI_PURPLE + "|" + symbol + "\t\t |");
                    System.out.println("|\t\t |");
                    System.out.println("|" + "\t   " + symbol + "|");
                    System.out.print(ANSI_PURPLE + "┕━━━━━━━━┙" + ANSI_RESET + "\n");
                } else {
                    System.out.print(ANSI_PURPLE + "┍━━━━━━━━┑" + "\n");
                    System.out.println("| " + symbol + "\t\t |");
                    System.out.println("|\t\t |");
                    System.out.println("|" + "\t   " + symbol + " |");
                    System.out.print(ANSI_PURPLE + "┕━━━━━━━━┙" + ANSI_RESET + "\n");
                }
                break;
        }
    }

    /**
     * setter for color
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

}
