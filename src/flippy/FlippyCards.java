package flippy;

/**
 * Keeps track of the cards and and answers questions
 * for the flippy card game. 
 * 
 * Red cards (hearts and diamonds) award positive points, while black cards 
 * (clubs and spades) award negative points.  Cards 2-10 have points worth 
 * their face value, Jack, Queen and King 10 and Ace 11.
 * 
 * @author 
 *
 */
public class FlippyCards {
	private Card[] cards; // the cards for the game

	/**
	 * Create a new flippy card game state, which consists of the
	 * numCards cards for the game.
	 * 
	 * @param numCards number of cards in the game
	 */
	public FlippyCards(int numCards){
		cards = new Card[numCards];
	}

	/**
	 * Returns the flippy card at the given index 
	 * 
	 * @return the flippy card at the given index
	 */
	public Card getCard(int index) {
		return cards[index];
	}
	
	/**
	 * Flip the card over at this index.  Card indices
	 * start at 0 and go up the cards.length-1
	 * 
	 * @param cardIndex the index of the card to flip over
	 */
	public void flipCard(int cardIndex) {
		cards[cardIndex].flip();
	}

	/**
	 * Calculate the best possible score for the
	 * current cards.
	 * 
	 * @return the optimal score
	 */
	public int calculateOptimalScore(){
		int numOfredCards = 0;
		int numOfblackCards = 0;
		int max = 0;
		int sum = 0;
		int sumOfredCards = 0;
		for(Card card : cards){
			sum += card.getFlippyCardValue();
			if (card.getFlippyCardValue()>max){
				max = card.getFlippyCardValue();
			}
			if (card.isRedCard()){
				numOfredCards ++;
				sumOfredCards += card.getFlippyCardValue();
			}
			else{
				numOfblackCards ++;
			}
		}
		if (numOfredCards == 0){
			return max;
		}
		else if(numOfblackCards == 0){
			return sum;

		}
		else{
			return sumOfredCards;

		}
			
		}
	


	/**
	 * Calculate the flippy card score for the cards that are
	 * face up.  
	 * 
	 * @return the flippy card score for faceup cards
	 */
	public int faceUpTotal(){
		for(Card card : cards){
			if (card.isFaceUp()){
				return card.getFlippyCardValue();
			}
		}
		return 0;
	}

	/**
	 * Calculate the flippy card score for the cards that are
	 * face down.  
	 * 
	 * @return the flippy card score for facedown cards
	 */
	public int faceDownTotal(){
		for(Card card : cards){
			if (!card.isFaceUp()){
				return card.getFlippyCardValue();
			}
		}
		return 0;
	}

	@Override
	public String toString(){
		String result = "";
		for(int i = 0; i< cards.length; i++){
			if(i!= cards.length-1){
				if(cards[i].isFaceUp()){
				result += cards[i].toString() + " | ";
				}
				else{
				result += "FACE-DOWN | ";
				}
			}
			else{
				if(cards[i].isFaceUp()){
					result += cards[i].toString();
				}
				else{
					result += "FACE-DOWN";
				}	
			}
		}
		return result;
	}

	public static void main(String[] args){
		FlippyCards game = new FlippyCards(5);
		game.cards[0] = new Card(1, "hearts");
		game.cards[1] = new Card(13, "spades");
		game.cards[2] = new Card(5, "diamonds");
		game.cards[3] = new Card(10, "clubs");
		game.cards[4] = new Card(7, "hearts");

		System.out.println(game);
		System.out.println("Optimal score: " + game.calculateOptimalScore());
		
		game.flipCard(0);
		game.flipCard(2);
		System.out.println(game);
		System.out.println("Face up total: " + game.faceUpTotal());
		System.out.println("Face down total: " + game.faceDownTotal());
	}
}
