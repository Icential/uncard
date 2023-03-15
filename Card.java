// Marco Soekmono
// 1/22/23
// CS145
// Lab #4

// This program will make the Card class for the Main class in
// order to create an object for cards in the game


// card class
public class Card {
    
    // init necessary variables
    private String name;
    private String purpose;
    private int id;
    
    // class constructor
    public Card(String name, String purpose, int id) {
        this.name = name;
        this.purpose = purpose;
        this.id = id;
    }

    // get name of card
    public String getName() {
        return this.name;
    }

    // get id of card
    public int getId() {
        return this.id;
    }

    // get purpose of card
    public String getPurpose() {
        return this.purpose;
    }
}
