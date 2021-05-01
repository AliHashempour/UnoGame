import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 * this class is the class that we play our game in it
 *
 * @author ALi.Hashempour
 * @version 1.0
 */


public class Game {

    private ArrayList<Player> players;

    private boolean clockwise = true;

    private boolean endGame = false;

    private int turn = 0;

    private int Get7 = 0;


    /**
     * constructor for the class
     */
    public Game() {

        this.players = new ArrayList<>();
    }

    /**
     * prints all player scors and if a player score was 0 he is the winner so he is in the top
     */

    public void printScores() {
        System.out.println("\n");
        ArrayList<Integer> scores = new ArrayList<>();
        for (int i = 0; i < players.size(); i++) {
            players.get(i).calculateScore();
            scores.add(players.get(i).calculateScore());
        }
        Collections.sort(scores);


        for (int i = 0; i < scores.size(); i++) {
            for (int j = 0; j < scores.size(); j++) {

                if (scores.get(i).equals(players.get(j).getTotalScore())) {
                    if (i == 0) {
                        System.out.println(players.get(j).getName() + " score is " + scores.get(i) + " winner!!!");
                        break;
                    } else {
                        System.out.println(players.get(j).getName() + " score is " + scores.get(i));
                        break;
                    }
                }
            }
        }

    }

    /**
     * adds a player to our list of players
     *
     * @param player the player we pass
     */
    public void addPlayer(Player player) {
        players.add(player);
    }

    /**
     * getter for players
     *
     * @return list of players
     */

    public ArrayList<Player> getPlayers() {
        return players;
    }


    /**
     * checks that if the game is finished or not ..
     *
     * @return a boolean
     */
    public boolean endGame() {
        boolean endGame = false;
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getPlayerCards().isEmpty()) {
                endGame = true;
                break;
            }
        }
        return endGame;
    }


    /**
     * this method prints the top card of the game
     *
     * @param set a set of our card that is our storage and we pass it to this method
     */
    public void showTable(Set set) {
        System.out.println("\ntop card: ");

        set.getAllCards().get(set.getAllCards().size() - 1).printCompleteCard();
        System.out.println("\n\n");

    }

    /**
     * checks the robot cards set with the top card ... if he had an suitable card ... it retirns true else..false
     *
     * @param player the player
     * @param set    the set
     * @return
     */

    public Boolean isThereTheCard(Player player, Set set) {
        boolean isThere = false;
        for (int i = 0; i < player.getPlayerCards().size(); i++) {
            if (player.getPlayerCards().get(i).getColor().equalsIgnoreCase(set.getAllCards().get(set.lastIndex()).getColor())
                    || player.getPlayerCards().get(i).getSymbol().equalsIgnoreCase(set.getAllCards().get(set.lastIndex()).getSymbol())) {
                isThere = true;
            }
        }
        return isThere;
    }


    /**
     * checks the player cards set with the top card ... if he had an suitable card ... it retirns true else..false
     *
     * @param player the player
     * @return
     */


    public boolean isThereInMySet(String color, String symbol, Player player) {
        boolean isThere = false;
        for (int i = 0; i < player.getPlayerCards().size(); i++) {
            if (player.getPlayerCards().get(i).getColor().equalsIgnoreCase(color) &&
                    (player.getPlayerCards().get(i).getSymbol().equalsIgnoreCase(symbol))) {
                isThere = true;
            }
        }
        return isThere;
    }


    /**
     * checks that if the symbol we pass to it..represents an action card or not
     *
     * @param symbol symbol is like( A  D  5  2 )
     * @return returns a boolean
     */

    public boolean isDynamic(String symbol) {
        boolean isDynamic = false;
        if (symbol.equals("2") || symbol.equals("7") || symbol.equals("8") || symbol.equals("10")
                || symbol.equals("A") || symbol.equals("B")) {
            isDynamic = true;
        }
        return isDynamic;
    }


    /**
     * with this method we can handle the turn...when we call this method
     * and this method will handle the turn..weather its clockwise or not
     */
    public void changeTurn() {
        if (clockwise) {
            turn = (turn + 1) % players.size();
        } else
            turn = (turn + players.size() - 1) % players.size();

    }


    /**
     * this method shows us that every player has how many cards
     */
    public void status() {
        System.out.println("\nstatus: ");
        for (int i = 0; i < players.size(); i++) {
            System.out.println(players.get(i).getName() + " has " + players.get(i).getPlayerCards().size() + " cards");
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();
        Set storageCards = new Set();
        Random random = new Random();

        for (int i = 3; i < 7; i++) {

            storageCards.addCart(new Card("Red", i));
        }
        storageCards.addCart(new Card("Red", "C"));
        storageCards.addCart(new Card("Red", "D"));
        storageCards.addCart(new Card("Red", "9"));
        storageCards.addCart(new cardA("Red", "A"));
        storageCards.addCart(new cardB("Red", "B"));
        storageCards.addCart(new card2("Red", "2"));
        storageCards.addCart(new simple7("Red", "7"));
        storageCards.addCart(new card8("Red", "8"));
        storageCards.addCart(new card10("Red", "10"));

        for (int i = 3; i < 7; i++) {

            storageCards.addCart(new Card("Green", i));
        }
        storageCards.addCart(new Card("Green", "C"));
        storageCards.addCart(new Card("Green", "D"));
        storageCards.addCart(new Card("Green", "9"));
        storageCards.addCart(new cardA("Green", "A"));
        storageCards.addCart(new cardB("Green", "B"));
        storageCards.addCart(new card2("Green", "2"));
        storageCards.addCart(new simple7("Green", "7"));
        storageCards.addCart(new card8("Green", "8"));
        storageCards.addCart(new card10("Green", "10"));
        for (int i = 3; i < 7; i++) {

            storageCards.addCart(new Card("Purple", i));
        }
        storageCards.addCart(new Card("Purple", "C"));
        storageCards.addCart(new Card("Purple", "D"));
        storageCards.addCart(new Card("Purple", "9"));
        storageCards.addCart(new cardA("Purple", "A"));
        storageCards.addCart(new card8("Purple", "B"));
        storageCards.addCart(new card2("Purple", "2"));
        Purple7 purple7 = new Purple7("Purple", "7");
        storageCards.addCart(purple7);
        storageCards.addCart(new card8("Purple", "8"));
        storageCards.addCart(new card10("Purple", "10"));
        for (int i = 3; i < 7; i++) {

            storageCards.addCart(new Card("Blue", i));
        }
        storageCards.addCart(new Card("Blue", "C"));
        storageCards.addCart(new Card("Blue", "D"));
        storageCards.addCart(new Card("Blue", "9"));
        storageCards.addCart(new cardA("Blue", "A"));
        storageCards.addCart(new card8("Blue", "B"));
        storageCards.addCart(new card2("Blue", "2"));
        storageCards.addCart(new simple7("Blue", "7"));
        storageCards.addCart(new cardB("Blue", "8"));
        storageCards.addCart(new card10("Blue", "10"));

        storageCards.shuffleSet();
        Thread.sleep(1000);


        System.out.println("hello\n\n");
        Thread.sleep(1000);


        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1-play with bot\n2-play with player");
            int botOrPlayer = scanner.nextInt();


            if (botOrPlayer == 1) {
                int info = 0;
                boolean isInfoTrue = false;
                while (!isInfoTrue) {
                    System.out.println("set the number of players between 3 to 5: ");
                    info = scanner.nextInt();
                    System.out.println();
                    if ((info > 2) && (info < 6)) {
                        System.out.println("thank you");
                        isInfoTrue = true;

                    } else {
                        System.out.println("wrong number try again");

                    }
                }
                System.out.println();
                scanner.nextLine();


                System.out.println("now set name for your self ");
                System.out.println();
                String name = scanner.nextLine();
                game.addPlayer(new Player(name));
                Thread.sleep(1000);
                System.out.println("now set name for " + (info - 1) + " robots");
                for (int i = 0; i < info - 1; i++) {
                    String robotName = scanner.nextLine();
                    game.addPlayer(new Robot(robotName));
                }


                for (int i = 0; i < game.getPlayers().size(); i++) {
                    for (int j = 0; j < 7; j++) {
                        int k = storageCards.getAllCards().size();
                        game.getPlayers().get(i).addCart(storageCards.getAllCards().get(k - 1));
                        storageCards.removeCard(storageCards.getAllCards().get(k - 1));
                    }
                }


                game.turn = random.nextInt(info);
                while (!game.endGame) {


                    for (int step = game.turn; step <= game.players.size() && !(game.endGame); game.changeTurn()) {

                        for (int i = 0; i < game.players.size(); i++) {
                            if (game.players.get(i).getPlayerCards().isEmpty()) {
                                game.endGame = true;
                                break;
                            }
                        }
                        game.status();


                        System.out.println("\nit is " + game.players.get(game.turn).getName() + " turn");

                        if (game.Get7 == 0) {
                            if (game.players.get(game.turn) instanceof Robot) {
                                System.out.println("press a key to show the top card");
                                scanner.nextLine();
                                game.showTable(storageCards);
                                if (!game.isThereTheCard(game.getPlayers().get(game.turn), storageCards)) {
                                    System.out.println("he doesnt have an suitable card ..press a key to continue");
                                    scanner.nextLine();
                                    Thread.sleep(2000);
                                    int index = random.nextInt(storageCards.lastIndex());
                                    game.getPlayers().get(game.turn).addCart(storageCards.getAllCards().get(index));
                                    storageCards.removeCard(storageCards.getAllCards().get(index));
                                    Thread.sleep(2000);
                                    System.out.println("card added to " + game.players.get(game.turn).getName() + " cards");
                                    Thread.sleep(2000);

                                } else {
                                    System.out.println(game.players.get(game.turn).getName() + " is choosing card please wait...\n");
                                    Thread.sleep(2000);
                                    for (int i = 0; i < game.players.get(game.turn).getPlayerCards().size(); i++) {
                                        if (game.players.get(game.turn).getPlayerCards().get(i).getSymbol().equals(
                                                storageCards.getAllCards().get(storageCards.lastIndex()).getSymbol()) || (
                                                game.players.get(game.turn).getPlayerCards().get(i).getColor().equals(
                                                        storageCards.getAllCards().get(storageCards.lastIndex()).getColor()))) {

                                            if (!(game.players.get(game.turn).getPlayerCards().get(i) instanceof dynamicCard)) {
                                                storageCards.addCart(game.players.get(game.turn).getPlayerCards().get(i));
                                                game.players.get(game.turn).removeCart(game.players.get(game.turn).getPlayerCards().get(i));
                                                if (game.endGame()) {
                                                    game.endGame = true;

                                                }
                                                System.out.println("he played his turn press a key to see it");
                                                scanner.nextLine();
                                                game.showTable(storageCards);
                                                Thread.sleep(2000);
                                                break;


                                            } else if (game.players.get(game.turn).getPlayerCards().get(i) instanceof dynamicCard) {
                                                String symbolCard = game.players.get(game.turn).getPlayerCards().get(i).getSymbol();
                                                String colorCard = game.players.get(game.turn).getPlayerCards().get(i).getColor();


                                                storageCards.addCart(game.players.get(game.turn).getPlayerCards().get(i));
                                                game.players.get(game.turn).removeCart(game.players.get(game.turn).getPlayerCards().get(i));
                                                System.out.println("he played his turn press a key to continue");
                                                if (game.endGame()) {
                                                    game.endGame = true;

                                                }
                                                scanner.nextLine();
                                                Thread.sleep(2000);


                                                if (symbolCard.equals("A")) {
                                                    if (!game.endGame()) {
                                                        game.changeTurn();
                                                        System.out.println(" he chosed A so the next player is blocked");
                                                        Thread.sleep(2000);
                                                    }

                                                } else if (symbolCard.equals("B")) {
                                                    if (!game.endGame()) {
                                                        System.out.println("he played B so he is choosing the next card color ");
                                                        Thread.sleep(2000);
                                                        String nextColor;
                                                        int randomColor = random.nextInt(4);
                                                        if (randomColor == 0) {
                                                            nextColor = "Red";
                                                            storageCards.getAllCards().get(storageCards.lastIndex()).setColor(nextColor);
                                                            System.out.println("next color will be " + nextColor);

                                                        } else if (randomColor == 1) {
                                                            nextColor = "Green";
                                                            storageCards.getAllCards().get(storageCards.lastIndex()).setColor(nextColor);
                                                            System.out.println("next color will be " + nextColor);

                                                        } else if (randomColor == 2) {
                                                            nextColor = "Purple";
                                                            storageCards.getAllCards().get(storageCards.lastIndex()).setColor(nextColor);
                                                            System.out.println("next color will be " + nextColor);

                                                        } else {
                                                            nextColor = "Blue";
                                                            storageCards.getAllCards().get(storageCards.lastIndex()).setColor(nextColor);
                                                            System.out.println("next color will be " + nextColor);

                                                        }

                                                        Thread.sleep(2000);

                                                    }
                                                } else if (symbolCard.equals("10")) {
                                                    if (!game.endGame()) {
                                                        if (game.clockwise) {
                                                            game.clockwise = false;
                                                            System.out.println(" he plaeyd 10 so it will be reversed to unclock wise");
                                                            Thread.sleep(2000);
                                                        } else {
                                                            game.clockwise = true;
                                                            System.out.println("he played 10 so it will be reversed to clock wise");
                                                            Thread.sleep(2000);
                                                        }

                                                        Thread.sleep(3000);
                                                    }
                                                } else if (symbolCard.equals("8")) {
                                                    if (!game.endGame()) {
                                                        game.turn--;
                                                        System.out.println(" he chosed 8 so it will be his turn again");
                                                        Thread.sleep(3000);
                                                        break;
                                                    }
                                                } else if (symbolCard.equals("2")) {
                                                    if (!game.endGame()) {
                                                        System.out.println(" he played 2 so he is chosing a player to add cart to him..");
                                                        Thread.sleep(2000);
                                                        int choose = random.nextInt(info);
                                                        int randomCard = random.nextInt(game.players.get(game.turn).getPlayerCards().size());
                                                        game.players.get(choose).addCart(game.players.get(game.turn).getPlayerCards().get(randomCard));
                                                        game.players.get(game.turn).removeCart(game.players.get(game.turn).getPlayerCards().get(randomCard));
                                                        System.out.println("card added to the player ");
                                                        Thread.sleep(3000);
                                                    }
                                                } else if (symbolCard.equals("7") && colorCard.equalsIgnoreCase("Purple")) {
                                                    game.Get7 += 4;
                                                } else if (symbolCard.equals("7")) {
                                                    game.Get7 += 2;
                                                }
                                                break;
                                            }

                                        }


                                    }

                                }

                            }

                            //player...

                            else {
                                System.out.println("press a key to show the top card");
                                scanner.nextLine();
                                game.showTable(storageCards);
                                game.players.get(game.turn).printPlayerSet();

                                if (!game.isThereTheCard(game.players.get(game.turn), storageCards)) {
                                    System.out.println("you dont have suitable card ... a card will be add to your cards.");
                                    Thread.sleep(2000);
                                    int index = random.nextInt(storageCards.lastIndex());
                                    game.getPlayers().get(game.turn).addCart(storageCards.getAllCards().get(index));
                                    storageCards.removeCard(storageCards.getAllCards().get(index));
                                    Thread.sleep(2000);
                                    System.out.println("card added ");
                                    Thread.sleep(2000);


                                } else {

                                    System.out.println("enter the color and the symbol of card ...\n");
                                    String color = scanner.nextLine();
                                    String symbol = scanner.nextLine();
                                    if (game.isThereInMySet(color, symbol, game.players.get(game.turn)) &&
                                            (storageCards.validToPush(color, symbol))) {
                                        if (!game.isDynamic(symbol)) {
                                            for (int i1 = 0; i1 < game.players.get(game.turn).getPlayerCards().size(); i1++) {
                                                if (game.players.get(game.turn).getPlayerCards().get(i1).getSymbol().equalsIgnoreCase(symbol)
                                                        && game.players.get(game.turn).getPlayerCards().get(i1).getColor().equalsIgnoreCase(color)) {
                                                    storageCards.addCart(game.players.get(game.turn).getPlayerCards().get(i1));
                                                    game.players.get(game.turn).removeCart(game.players.get(game.turn).getPlayerCards().get(i1));
                                                    System.out.println("removed from your cards");
                                                    if (game.endGame()) {
                                                        game.endGame = true;

                                                    }
                                                    game.showTable(storageCards);

                                                }
                                            }
                                        } else {
                                            for (int i1 = 0; i1 < game.players.get(game.turn).getPlayerCards().size(); i1++) {

                                                if (game.players.get(game.turn).getPlayerCards().get(i1).getSymbol().equalsIgnoreCase(symbol)
                                                        && game.players.get(game.turn).getPlayerCards().get(i1).getColor().equalsIgnoreCase(color)) {
                                                    storageCards.addCart(game.players.get(game.turn).getPlayerCards().get(i1));
                                                    game.players.get(game.turn).removeCart(game.players.get(game.turn).getPlayerCards().get(i1));
                                                    System.out.println("removed from your cards");
                                                    if (game.endGame()) {
                                                        game.endGame = true;

                                                    }
                                                    Thread.sleep(2000);

                                                }
                                            }
                                            if (symbol.equalsIgnoreCase("A")) {
                                                if (!game.endGame()) {
                                                    game.changeTurn();
                                                    System.out.println("next player is blocked");
                                                    Thread.sleep(2000);

                                                }
                                            } else if (symbol.equalsIgnoreCase("B")) {
                                                if (!game.endGame()) {
                                                    System.out.println("choose the next card color...first word of the color must be capital " +
                                                            "like Green ....");
                                                    String nextColor = scanner.nextLine();
                                                    storageCards.getAllCards().get(storageCards.lastIndex()).setColor(nextColor);
                                                    System.out.println("next color will be " + nextColor);

                                                    Thread.sleep(2000);

                                                }
                                            } else if (symbol.equalsIgnoreCase("10")) {
                                                if (!game.endGame()) {
                                                    if (game.clockwise) {
                                                        game.clockwise = false;
                                                        Thread.sleep(2000);
                                                    } else {
                                                        game.clockwise = true;
                                                        Thread.sleep(2000);
                                                    }
                                                    System.out.println(" it will be reversed ...");
                                                    Thread.sleep(3000);

                                                }
                                            } else if (symbol.equals("8")) {
                                                if (!game.endGame()) {
                                                    game.turn--;
                                                    System.out.println("it will be your turn again");
                                                    Thread.sleep(3000);

                                                }
                                            } else if (symbol.equals("2")) {
                                                if (!game.endGame()) {
                                                    System.out.println("choose a player to add cart to him... tell the index of the player..." +
                                                            "(your index is always 0)");
                                                    int choose = scanner.nextInt();
                                                    int randomCard = random.nextInt(game.players.get(game.turn).getPlayerCards().size());
                                                    game.players.get(choose).addCart(game.players.get(game.turn).getPlayerCards().get(randomCard));
                                                    game.players.get(game.turn).removeCart(game.players.get(game.turn).getPlayerCards().get(randomCard));
                                                    System.out.println("card added to the player ");
                                                    Thread.sleep(3000);
                                                }
                                            } else if (symbol.equals("7") && color.equalsIgnoreCase("Purple")) {
                                                game.Get7 += 4;
                                            } else if (symbol.equals("7")) {
                                                game.Get7 += 2;
                                            }

                                        }
                                    } else {
                                        System.out.println("invalid input try again...");
                                        Thread.sleep(2000);
                                        break;
                                    }
                                }
                            }

                        } else {
                            System.out.println("player " + game.players.get(game.turn).getName() + " you have to choose a 7 card" +
                                    " cuz the last card is 7");
                            Thread.sleep(2000);
                            if (game.players.get(game.turn) instanceof Robot) {
                                for (int i = 0; i < game.players.get(game.turn).getPlayerCards().size(); i++) {
                                    if (game.players.get(game.turn).getPlayerCards().get(i).getSymbol().equals("7")) {
                                        if (game.players.get(game.turn).getPlayerCards().get(i).getColor().equalsIgnoreCase("Purple")) {
                                            System.out.println("the player is removing his  purple card7 press a key");
                                            scanner.nextLine();
                                            storageCards.addCart(purple7);
                                            game.getPlayers().get(game.turn).removeCart(purple7);
                                            game.Get7 += 4;
                                            System.out.println("card7 removed and added to storage");
                                            if (game.endGame()) {
                                                game.endGame = true;

                                            }
                                            Thread.sleep(2000);
                                            break;

                                        } else {
                                            System.out.println("the player is removing his card7 press a key");
                                            scanner.nextLine();
                                            storageCards.addCart(game.players.get(game.turn).getPlayerCards().get(i));
                                            game.getPlayers().get(game.turn).removeCart(game.players.get(game.turn).getPlayerCards().get(i));
                                            game.Get7 += 2;
                                            System.out.println("card7 removed and added to storage");
                                            if (game.endGame()) {
                                                game.endGame = true;

                                            }
                                            Thread.sleep(2000);
                                            break;
                                        }
                                    } else {
                                        System.out.println("the " + game.players.get(game.turn).getName() + " doesnt have 7  some cards will add" +
                                                " to his set " +
                                                "press a key to continue");
                                        scanner.nextLine();
                                        for (int i1 = 0; i1 < game.Get7; i1++) {
                                            int punishCart = random.nextInt(storageCards.getAllCards().size());
                                            game.players.get(game.turn).addCart(storageCards.getAllCards().get(punishCart));
                                            storageCards.removeCard(storageCards.getAllCards().get(punishCart));
                                        }
                                        game.Get7 = 0;
                                        break;
                                    }
                                }

                            } else {
                                game.players.get(game.turn).printPlayerSet();
                                System.out.println("if you have a 7 card write yes else right no");
                                String card7Exist = scanner.nextLine();
                                if (card7Exist.equals("yes")) {
                                    System.out.println("enter the color and the symbol of card\n");
                                    String color = scanner.nextLine();
                                    String symbol = scanner.nextLine();
                                    if (game.isThereInMySet(color, symbol, game.players.get(game.turn)) &&
                                            (storageCards.validToPush(color, symbol))) {
                                        for (int i = 0; i < game.players.get(game.turn).getPlayerCards().size(); i++) {
                                            if (game.players.get(game.turn).getPlayerCards().get(i).getSymbol().equalsIgnoreCase(symbol)
                                                    && game.players.get(game.turn).getPlayerCards().get(i).getColor().equalsIgnoreCase(color)) {
                                                if (color.equals("Purple")) {
                                                    storageCards.addCart(game.players.get(game.turn).getPlayerCards().get(i));
                                                    game.players.get(game.turn).removeCart(game.players.get(game.turn).getPlayerCards().get(i));
                                                    System.out.println("removed from your cards");
                                                    game.Get7 += 4;
                                                    if (game.endGame()) {
                                                        game.endGame = true;

                                                    }
                                                    game.showTable(storageCards);
                                                } else {
                                                    storageCards.addCart(game.players.get(game.turn).getPlayerCards().get(i));
                                                    game.players.get(game.turn).removeCart(game.players.get(game.turn).getPlayerCards().get(i));
                                                    System.out.println("removed from your cards");
                                                    game.Get7 += 2;
                                                    if (game.endGame()) {
                                                        game.endGame = true;

                                                    }
                                                    game.showTable(storageCards);
                                                }
                                            }
                                        }

                                    } else {
                                        System.out.println("invalid input try again...");
                                        Thread.sleep(2000);
                                        break;
                                    }

                                } else if (card7Exist.equals("no")) {
                                    System.out.println("you  dont have 7 press a key to continue and some cards will be added to your set...");
                                    scanner.nextLine();
                                    for (int i = 0; i < game.Get7; i++) {
                                        int punishCart = random.nextInt(storageCards.getAllCards().size());
                                        game.players.get(game.turn).addCart(storageCards.getAllCards().get(punishCart));
                                        storageCards.removeCard(storageCards.getAllCards().get(punishCart));
                                    }
                                    game.Get7 = 0;
                                }
                            }
                        }


                    }
                }

                System.out.println("\nthe game is finished ...\n\n  ");
                Thread.sleep(2000);
                game.printScores();


            } else if (botOrPlayer == 2) {
                int info = 0;
                boolean isInfoTrue = false;
                while (!isInfoTrue) {
                    System.out.println("set the number of players between 3 to 5: ");
                    info = scanner.nextInt();
                    System.out.println();
                    if ((info > 2) && (info < 6)) {
                        System.out.println("thank you");
                        isInfoTrue = true;

                    } else {
                        System.out.println("wrong number try again");

                    }
                }
                System.out.println();
                scanner.nextLine();


                System.out.println("now set name for your self ");
                System.out.println();
                String name = scanner.nextLine();
                game.addPlayer(new Player(name));
                Thread.sleep(1000);
                System.out.println("now set name for " + (info - 1) + " other players");
                for (int i = 0; i < info - 1; i++) {
                    String other = scanner.nextLine();
                    game.addPlayer(new Player(other));
                }


                for (int i = 0; i < game.getPlayers().size(); i++) {
                    for (int j = 0; j < 7; j++) {
                        int k = storageCards.getAllCards().size();
                        game.getPlayers().get(i).addCart(storageCards.getAllCards().get(k - 1));
                        storageCards.removeCard(storageCards.getAllCards().get(k - 1));
                    }
                }


                game.turn = random.nextInt(info);
                while (!game.endGame) {

                    for (int step = game.turn; step <= game.players.size() && !(game.endGame); game.changeTurn()) {
                        for (int i = 0; i < game.players.size(); i++) {
                            if (game.players.get(i).getPlayerCards().isEmpty()) {
                                game.endGame = true;
                                break;
                            }
                        }
                        game.status();


                        System.out.println("\nplayer " + game.players.get(game.turn).getName() + " its your turn");

                        if (game.Get7 == 0) {


                            //player...


                            System.out.println("press a key to show the top card");
                            scanner.nextLine();
                            game.showTable(storageCards);
                            game.players.get(game.turn).printPlayerSet();

                            if (!game.isThereTheCard(game.players.get(game.turn), storageCards)) {
                                System.out.println("you dont have suitable card ... a card will be add to your cards.");
                                Thread.sleep(2000);
                                int index = random.nextInt(storageCards.lastIndex());
                                game.getPlayers().get(game.turn).addCart(storageCards.getAllCards().get(index));
                                storageCards.removeCard(storageCards.getAllCards().get(index));
                                Thread.sleep(2000);
                                System.out.println("card added ");
                                Thread.sleep(2000);


                            } else {

                                System.out.println("enter the color and the symbol of card\n");
                                String color = scanner.nextLine();
                                String symbol = scanner.nextLine();
                                if (game.isThereInMySet(color, symbol, game.players.get(game.turn)) &&
                                        (storageCards.validToPush(color, symbol))) {
                                    if (!game.isDynamic(symbol)) {
                                        for (int i1 = 0; i1 < game.players.get(game.turn).getPlayerCards().size(); i1++) {
                                            if (game.players.get(game.turn).getPlayerCards().get(i1).getSymbol().equalsIgnoreCase(symbol)
                                                    && game.players.get(game.turn).getPlayerCards().get(i1).getColor().equalsIgnoreCase(color)) {
                                                storageCards.addCart(game.players.get(game.turn).getPlayerCards().get(i1));
                                                game.players.get(game.turn).removeCart(game.players.get(game.turn).getPlayerCards().get(i1));
                                                System.out.println("removed from your cards");
                                                if (game.endGame()) {
                                                    game.endGame = true;

                                                }
                                                game.showTable(storageCards);

                                            }
                                        }
                                    } else {
                                        for (int i1 = 0; i1 < game.players.get(game.turn).getPlayerCards().size(); i1++) {

                                            if (game.players.get(game.turn).getPlayerCards().get(i1).getSymbol().equalsIgnoreCase(symbol)
                                                    && game.players.get(game.turn).getPlayerCards().get(i1).getColor().equalsIgnoreCase(color)) {
                                                storageCards.addCart(game.players.get(game.turn).getPlayerCards().get(i1));
                                                game.players.get(game.turn).removeCart(game.players.get(game.turn).getPlayerCards().get(i1));
                                                System.out.println("removed from your cards");
                                                if (game.endGame()) {
                                                    game.endGame = true;

                                                }
                                                Thread.sleep(2000);

                                            }
                                        }
                                        if (symbol.equalsIgnoreCase("A")) {
                                            if (!game.endGame()) {
                                                game.changeTurn();
                                                System.out.println("next player is blocked");
                                                Thread.sleep(2000);


                                            }
                                        } else if (symbol.equalsIgnoreCase("B")) {
                                            if (!game.endGame()) {
                                                System.out.println("choose the next card color...first word of the color must be capital " +
                                                        "like Green ....");
                                                String nextColor = scanner.nextLine();
                                                storageCards.getAllCards().get(storageCards.lastIndex()).setColor(nextColor);
                                                System.out.println("next color will be " + nextColor);

                                                Thread.sleep(2000);


                                            }
                                        } else if (symbol.equals("10")) {
                                            if (!game.endGame()) {
                                                if (game.clockwise) {
                                                    game.clockwise = false;
                                                    Thread.sleep(2000);
                                                } else {
                                                    game.clockwise = true;
                                                    Thread.sleep(2000);
                                                }
                                                System.out.println("it will be reversed");
                                                Thread.sleep(3000);

                                            }
                                        } else if (symbol.equals("8")) {
                                            if (!game.endGame()) {
                                                game.turn--;
                                                System.out.println("it will be your turn again");
                                                Thread.sleep(3000);

                                            }
                                        } else if (symbol.equals("2")) {
                                            if (!game.endGame()) {
                                                System.out.println("choose a player to add cart to him... tell the index of the player...");
                                                int choose = scanner.nextInt();
                                                int randomCard = random.nextInt(game.players.get(game.turn).getPlayerCards().size());
                                                game.players.get(choose).addCart(game.players.get(game.turn).getPlayerCards().get(randomCard));
                                                game.players.get(game.turn).removeCart(game.players.get(game.turn).getPlayerCards().get(randomCard));
                                                System.out.println("card added to the player ");
                                                Thread.sleep(3000);
                                            }
                                        } else if (symbol.equals("7") && color.equalsIgnoreCase("Purple")) {
                                            game.Get7 += 4;
                                        } else if (symbol.equals("7")) {
                                            game.Get7 += 2;
                                        }

                                    }
                                } else {
                                    System.out.println("invalid input try again...");
                                    Thread.sleep(2000);
                                    break;
                                }
                            }


                        } else {
                            System.out.println("player " + game.players.get(game.turn).getName() + " you have to choose a 7 card" +
                                    " cuz the last card is 7");
                            Thread.sleep(2000);

                            game.players.get(game.turn).printPlayerSet();
                            System.out.println("if you have a 7 card write yes else right no");
                            String card7Exist = scanner.nextLine();
                            if (card7Exist.equals("yes")) {
                                System.out.println("enter the color and the symbol of card\n");
                                String color = scanner.nextLine();
                                String symbol = scanner.nextLine();
                                if (game.isThereInMySet(color, symbol, game.players.get(game.turn)) &&
                                        (storageCards.validToPush(color, symbol))) {
                                    for (int i = 0; i < game.players.get(game.turn).getPlayerCards().size(); i++) {
                                        if (game.players.get(game.turn).getPlayerCards().get(i).getSymbol().equalsIgnoreCase(symbol)
                                                && game.players.get(game.turn).getPlayerCards().get(i).getColor().equalsIgnoreCase(color)) {
                                            if (color.equals("Purple")) {
                                                storageCards.addCart(game.players.get(game.turn).getPlayerCards().get(i));
                                                game.players.get(game.turn).removeCart(game.players.get(game.turn).getPlayerCards().get(i));
                                                System.out.println("removed from your cards");
                                                game.Get7 += 4;
                                                if (game.endGame()) {
                                                    game.endGame = true;
                                                }
                                                game.showTable(storageCards);
                                            } else {
                                                storageCards.addCart(game.players.get(game.turn).getPlayerCards().get(i));
                                                game.players.get(game.turn).removeCart(game.players.get(game.turn).getPlayerCards().get(i));
                                                System.out.println("removed from your cards");
                                                game.Get7 += 2;
                                                if (game.endGame()) {
                                                    game.endGame = true;
                                                }
                                                game.showTable(storageCards);
                                            }
                                        }
                                    }
                                } else {
                                    System.out.println("invalid input try again...");
                                    Thread.sleep(2000);
                                    break;
                                }
                            } else if (card7Exist.equals("no")) {
                                System.out.println("you  dont have 7 press a key to continue and some cards will be added to your set...");
                                scanner.nextLine();
                                for (int i = 0; i < game.Get7; i++) {
                                    int punishCart = random.nextInt(storageCards.getAllCards().size());
                                    game.players.get(game.turn).addCart(storageCards.getAllCards().get(punishCart));
                                    storageCards.removeCard(storageCards.getAllCards().get(punishCart));
                                }
                                game.Get7 = 0;
                            }
                        }
                    }
                }
                System.out.println("\nthe game is finished ... \n\n ");
                Thread.sleep(2000);
                game.printScores();
            } else {
                System.out.println("you have to choose 1 or 2\n");

            }
        }
    }
}
