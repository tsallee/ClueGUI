package clueGame;

import java.awt.Color;
import java.awt.Graphics;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

import clueGame.Card.cardType;

public class ClueGame extends JPanel {
	private Solution solution;
	private ArrayList<Card> cards;
	private ArrayList<Player> players;
	private int whoseTurn;
	private Board board;
	
	public Board getBoard() {
		return board;
	}

	public ClueGame() {
		solution = new Solution();
		players = new ArrayList<Player>();
		cards = new ArrayList<Card>();
		board = new Board();
	}
	
	public void loadConfigFiles() {
		try {
			board.loadConfigFiles();
		} catch (BadConfigFormatException e) {
			System.out.println();
		}
		loadPeople();
		loadCards();
	}
	
	public void loadPeople() {
		try {
			boolean flag = true;
			String input, name, color;
			int row, column, startPosition;
			String[] sep;
			FileReader reader = new FileReader("CluePeople.txt");
			Scanner scanner = new Scanner(reader);
			while ( scanner.hasNext()) {
				input = scanner.nextLine();
				sep = input.split(", ");
				name = sep[0];
				color = sep[1];
				row = Integer.parseInt(sep[2]);
				column = Integer.parseInt(sep[3]);
				startPosition = board.calcIndex(row, column);
				System.out.println(row + " " + column);
				System.out.println(startPosition);
				if ( flag ) {
					players.add(new HumanPlayer(name, startPosition, color));
					flag = false;
				} else {
					players.add(new ComputerPlayer(name, startPosition, color));
				}
//				for ( Player p : players ) {
//					System.out.println(p.getLocation());
//				}
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void loadCards() {
		try {
			String input, name, type;
			String[] sep;
			FileReader reader = new FileReader("ClueCards.txt");
			Scanner scanner = new Scanner(reader);
			while ( scanner.hasNext()) {
				input = scanner.nextLine();
				sep = input.split(", ");
				name = sep[0];
				type = sep[1];
				if ( type.equals("person") ) {
					cards.add(new Card(Card.cardType.PERSON, name));
				} else if (type.equals("room") ) {
					cards.add(new Card(Card.cardType.ROOM, name));
				} else if (type.equals("weapon") ) {
					cards.add(new Card(Card.cardType.WEAPON, name));
				} else
					throw new BadConfigFormatException("Card file has bad format");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		board.paintComponent(g);
		for ( Player p : players ) {
			p.draw(g, board);
			//System.out.println( p.getLocation() );
		}
		drawRooms(g, board);
	}

	
	public void deal() {
		Card card;
		String person = "", weapon = "", room = "";
		Random r = new Random();
		ArrayList<Card> c = new ArrayList<Card>(cards);
		int rand = 0;
		while ( true ) {
			rand = r.nextInt(c.size());
			card = c.get(rand);
			if ( card.getType() == Card.cardType.PERSON && person == "") {
				person = card.getName();
				c.remove(rand);
			}
			else if ( card.getType() == Card.cardType.ROOM && room == "") {
				room = card.getName();
				c.remove(rand);
			}
			else if ( card.getType() == Card.cardType.WEAPON && weapon == "") {
				weapon = card.getName();
				c.remove(rand);
			}
			if ( person != "" && room != "" && weapon != "" )
				break;			
		}
		
		solution = new Solution(person, room, weapon);
			
		int i = 0;
		while( c.size() > 0) {
			rand = r.nextInt(c.size());
			players.get(i).addCard(c.get(rand));
			c.remove(rand);
			i = (i + 1) % 6;
		}
	}
	
	private void drawRooms(Graphics g, Board b) {
		int bigSquareX = GameBoardGUI.getBoardLength()/b.getNumColumns();
		int bigSquareY = GameBoardGUI.getBoardHeight()/b.getNumRows();
		int bigSquareWidth = GameBoardGUI.getBoardLength();
		int bigSquareHeight = GameBoardGUI.getBoardHeight();
		g.setColor(Color.BLACK);
		g.drawRect(bigSquareX, bigSquareY, bigSquareWidth, bigSquareHeight);
		
	}
	
	public void selectAnswer(Solution s) {
		solution = s;
	}

	public boolean checkAccusation(Solution solution) {
		if ( this.solution.equals(solution))
			return true;
		return false;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public ArrayList<Card> getCards() {
		return cards;
	}

	public void setSolution(Solution solution) {
		this.solution = solution;
	}
	
	public Solution getSolution() {
		return solution;
	}
	
	public void setWhoseTurn(String name) {
		
	}
	
	public String handleSuggestion(Player player) {
		Random rand = new Random();
		String disprove;
		int index = 0;
		int r = 0;
		ArrayList<Player> p = new ArrayList(players);
		p.remove(player);
		r = rand.nextInt(p.size());
		for ( int i = 0; i < p.size(); ++i ) {
			index = (i + r) % p.size();
			disprove = p.get(index).disproveSuggestion(player.getSuggestion());
			if ( disprove != null)
				return disprove;
		}
		return null;
	}
	
}
