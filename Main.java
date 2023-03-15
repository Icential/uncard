// Marco Soekmono
// 1/22/23
// CS145
// Lab #4

// This program will make an original card game session with the player
// with five unique cards with the computer. The goal is to
// deplete the deck faster than the other player. This program
// uses lists and queues to process drawing and decking cards.
// It also uses switch cases to verify actions of cards.


// import relevant libraries
import java.util.Random;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.ListIterator;

// main init
public class Main {

    // introductory statement
    public static void intro() {
        System.out.println("Welcome to Uncard! A card game that I just made");
        System.out.println("The goal is simple, get rid of all the cards");
        System.out.println("Type 'info' for card information");
        System.out.println("You draw a card every other turn");
        System.out.println("Have fun!");
        System.out.println();
    }

    // information for each card
    public static void info(Card[] cards) {
        for (int i = 0; i < cards.length; i++) {
            System.out.println(cards[i].getName() + ": " + cards[i].getPurpose());
        }
        System.out.println();
    }

    // shuffle the draw card for game with randomly generated cards
    public static Queue<Card> shuffle(Queue<Card> draw, Card[] cards) {
        Random rand = new Random();
        int rng = 0;
        for (int i = 0; i < 50; i++) {
            rng = rand.nextInt(5);
            draw.add(cards[rng]);
        }
        return draw;
    }

    // draws cards from the draw queue to the deck list
    public static List<Card> initDraw(List<Card> deck, Queue<Card> draw) {
        for (int i = 0; i < 6; i++) {
            deck.add(draw.poll());
        }
        return deck;
    }

    // enumerate each deck's cards onto an enumerating list that prints it out
    public static void enumerate(List<Card> hand) {
        System.out.println("Your deck is: (" + hand.size() + " total card(s))");
        List<String> names = new ArrayList<String>();
        for (int i = 0; i < hand.size(); i++) {
            names.add(hand.get(i).getName());
        }
        ListIterator<String> e = names.listIterator();
        while (e.hasNext()) {
            System.out.print((e.nextIndex() + 1) + ". " + e.next() + " | ");
        }
        System.out.println();
    }

    // rerolls all the cards in a deck
    public static List<Card> reroll(List<Card> hand, Card[] cards, Random rand) {
        int rng = 0;
        for (int i = 0; i < hand.size(); i++) {
            rng = rand.nextInt(5);
            hand.set(i, cards[rng]);
        }
        return hand;
    }

    // main session
    public static void session() {

        // init variables (cards, decks, draw, boolean conditions, random variable)
        Scanner scan = new Scanner(System.in);
        List<Card> playerDeck = new ArrayList<Card>();
        List<Card> enemyDeck = new ArrayList<Card>();
        Queue<Card> draw = new LinkedList<>();
        Card blank = new Card("Blank", "Does nothing; it exists", 1);
        Card voi = new Card("Void", "Removes a random card from your deck from the game", 2);
        Card origin = new Card("Origin", "Forces the enemy to draw a card", 3);
        Card ether = new Card("Ether", "Gives you an extra turn", 4);
        Card machina = new Card("Machina", "Rerolls your entire hand", 5);
        Card[] cards = {blank, voi, origin, ether, machina};
        boolean proceed = false;
        boolean playerSkip = false;
        boolean enemySkip = false;
        boolean drawFlag = true;
        Card chosen = blank;
        Random rand = new Random();
        int r = 0;

        // display card info
        info(cards);

        // initialize draw queue and share it to player and enemy deck
        draw = shuffle(draw, cards);
        playerDeck = initDraw(playerDeck, draw);
        enemyDeck = initDraw(enemyDeck, draw);

        // loop session
        while(true) {
            
            // if enemy skips player
            if (!enemySkip) {

                // show player deck
                enumerate(playerDeck);
                System.out.println("The enemy has " + enemyDeck.size() + " card(s).");
                System.out.println("What card would you like to play? (Type a number index)");
                String input = scan.nextLine();
                System.out.println();

                // from user input, choose this card/index and set it as the chosen card
                switch(input) {
                    case "info":
                        info(cards);
                        proceed = false;
                        break;
                    case "1":
                            chosen = playerDeck.get(0);
                            playerDeck.remove(0);
                            proceed = true;
                        break;
                    case "2":
                        if (playerDeck.size() < 2) {
                            System.out.println("Invalid card index!");
                            proceed = false;
                        } else {
                            chosen = playerDeck.get(1);
                            playerDeck.remove(1);
                            proceed = true;
                        }
                        break;
                    case "3":
                        if (playerDeck.size() < 3) {
                            System.out.println("Invalid card index!");
                            proceed = false;
                        } else {
                            chosen = playerDeck.get(2);
                            playerDeck.remove(2);
                            proceed = true;

                        }
                        break;
                    case "4":
                        if (playerDeck.size() < 4) {
                            System.out.println("Invalid card index!");
                            proceed = false;
                        } else {
                            chosen = playerDeck.get(3);
                            playerDeck.remove(3);
                            proceed = true;

                        }
                        break;
                    case "5":
                        if (playerDeck.size() < 5) {
                            System.out.println("Invalid card index!");
                            proceed = false;
                        } else {
                            chosen = playerDeck.get(4);
                            playerDeck.remove(4);
                            proceed = true;

                        }
                        break;
                    case "6":
                        if (playerDeck.size() < 6) {
                            System.out.println("Invalid card index!");
                            proceed = false;
                        } else {
                            chosen = playerDeck.get(5);
                            playerDeck.remove(5);
                            proceed = true;

                        }
                        break;
                    case "7":
                        if (playerDeck.size() < 7) {
                            System.out.println("Invalid card index!");
                            proceed = false;
                        } else {
                            chosen = playerDeck.get(6);
                            playerDeck.remove(6);
                            proceed = true;

                        }
                        break;
                    case "8":
                        if (playerDeck.size() < 8) {
                            System.out.println("Invalid card index!");
                            proceed = false;
                        } else {
                            chosen = playerDeck.get(7);
                            playerDeck.remove(7);
                            proceed = true;

                        }
                        break;
                    case "9":
                        if (playerDeck.size() < 9) {
                            System.out.println("Invalid card index!");
                            proceed = false;
                        } else {
                            chosen = playerDeck.get(8);
                            playerDeck.remove(8);
                            proceed = true;

                        }
                        break;
                    case "10":
                        if (playerDeck.size() < 10) {
                            System.out.println("Invalid card index!");
                            proceed = false;
                        } else {
                            chosen = playerDeck.get(9);
                            playerDeck.remove(9);
                            proceed = true;

                        }
                        break;
                    default:
                        System.out.println("Unknown entry, please try again");
                        proceed = false;
                        break;

                }

            }

            // if process can proceed to enemy turn
            if (proceed) {

                // if enemy skips player
                if (!enemySkip) {

                    draw.add(chosen);

                    // Do actions based on the card chosen
                    switch(chosen.getId()) {
                        case 1:
                            System.out.println("You used a blank card");
                            break;
                        case 2:
                            if (playerDeck.size() > 1) {
                                int rng2 = rand.nextInt(playerDeck.size());
                                playerDeck.remove(rng2);
                            }
                            System.out.println("Removed a random card from your deck!");
                            break;
                        case 3:
                            enemyDeck.add(draw.poll());
                            System.out.println("Forced the enemy to draw a card!");
                            break;
                        case 4:
                            playerSkip = true;
                            System.out.println("Skipping the enemy's turn");
                            break;
                        case 5:
                            playerDeck = reroll(playerDeck, cards, rand);
                            System.out.println("Rerolling your entire deck!");
                            break;

                    }

                    System.out.println();

                }

                // return boolean to default false
                enemySkip = false;

                // check if deck is empty
                if (playerDeck.size() == 0) {
                    System.out.println("You win!");
                    break;
                }

                // check if player skips enemy
                if (!playerSkip) {

                    // get random card from enemy's deck and chooses it
                    r = rand.nextInt(enemyDeck.size());
                    chosen = enemyDeck.get(r);
                    enemyDeck.remove(r);
                    draw.add(chosen);

                    // action for enemy's chosen card
                    switch(chosen.getId()) {
                        case 1:
                            System.out.println("Enemy used a blank card");
                            break;
                        case 2:
                            if (enemyDeck.size() > 1) { 
                                int rng2 = rand.nextInt(enemyDeck.size());
                                enemyDeck.remove(rng2);
                                System.out.println("Removed a random card from enemy's deck!");
                            }
                            break;
                        case 3:
                            playerDeck.add(draw.poll());
                            System.out.println("Enemy forced you to draw an extra card!");
                            break;
                        case 4:
                            enemySkip = true;
                            System.out.println("Enemy has skipped your turn!");
                            break;
                        case 5:
                            enemyDeck = reroll(enemyDeck, cards, rand);
                            System.out.println("Enemy rerolls their entire deck!");
                            break;
                    }

                    System.out.println();

                }

                // make boolean to default false
                playerSkip = false;

                // every other turn, make both players draw a card
                if (drawFlag) {
                    if (playerDeck.size() <= 10) {
                        playerDeck.add(draw.poll());
                        System.out.println("You draw a card");
                    }
                    if (enemyDeck.size() <= 10) {
                        enemyDeck.add(draw.poll());
                        System.out.println("Enemy draws a card");
                    }
                    System.out.println();
                    drawFlag = false;
                } else {
                    drawFlag = true;
                }

                // check if enemy has no cards left
                if (enemyDeck.size() == 0) {
                    System.out.println("Enemy wins!");
                    break;
                }

            }

        }

        // close scanners
        scan.close();
    }

    // main
    public static void main(String[] args) {
        intro();
        session();
    }
}