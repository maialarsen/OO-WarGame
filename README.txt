Maia Larsen

1. Information Expert Pattern: In the Deck class it has the function to split deck and shuffle cards because it has the information of the deck, so it does not
have to be done by the Player or the Game objects.

2. Single Responsibility Principle: This principle I think is shown with the Deck class because it has the one function of managing the deck so there would only be one
reason for any changes to the class.

3. Open Closed Principle: This principle is shown in the Game class through abstraction where it would not need to be modified if another version of the game were
to be added we wouldn't need to modify existing code.

4. Creator Pattern: I used this principle with the Game class, and it was responsible for creating all the objects such as the Deck and the Players are all contained within
because it is what makes most sense.