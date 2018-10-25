import java.util.ArrayList;
import java.util.Random;

public class Deck {
	private ArrayList<Card> cards;
	//TODO: Please implement the constructor (30 points)
	public ArrayList<Card> usedCard; 
	public int nUsed;
	Random rnd = new Random(); 
	public Deck(int nDeck){
		cards=new ArrayList<Card>();
		usedCard=new ArrayList<Card>();
		//1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
		//Hint: Use new Card(x,y) and 3 for loops to add card into deck
		//Sample code start
		//Card card=new Card(1,1); ->means new card as clubs ace
		//cards.add(card);
		//Sample code end
		for(int deck=0;deck<nDeck;deck++) {
			for(int s=1;s<=4;s++) {
				for(int num=1;num<=13;num++) {
					if(s == 1) {
					      Card c = new Card(Card.Suit.Spade,num);
					      cards.add(c);
					     }
					     else if (s == 2) {
					      Card c = new Card(Card.Suit.Heart,num);
					      cards.add(c);
					     }
					     else if (s == 3) {
					      Card c = new Card(Card.Suit.Diamond,num);
					      cards.add(c);
					     }
					     else if (s == 4) {
					      Card c = new Card(Card.Suit.Club,num);
					      cards.add(c);
					     }
				};
			};
		};
		
		shuffle();

	}	
	//TODO: Please implement the method to print all cards on screen (10 points)
	public void printDeck(){
		//Hint: print all items in ArrayList<Card> cards, 
		//TODO: please implement and reuse printCard method in Card class (5 points)
		for(int n=0;n<cards.size();n++) {
			Card c=cards.get(n);
			c.printCard();
		};
		System.out.println();
	}
	public ArrayList<Card> getAllCards(){
		return cards;
	}
	public void shuffle() {
		  
		nUsed = 0;
		cards.addAll(usedCard);
		usedCard.clear();
		//­«³]
		for(int i = 0;i < cards.size() ;i++) 
	    {
			int tmp = rnd.nextInt(cards.size());
			Card take =cards.get(tmp);
			cards.set(tmp,cards.get(i));
			cards.set(i,take);     
	    }
	}
	public Card getOneCard() {
		 if(cards.size() == 0) {
			   shuffle();
			  }
		Card cc=cards.get(0);
		cards.remove(0);
		usedCard.add(cc);
		nUsed++;
		return cc;
	}
}
