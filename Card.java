package MemoryGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Card {

	public static final int SIZE = 100;
	
	private static Image[] images; 
	private static Image backSideImage;
	private static String[] imageNames = {"20", "7", "1",
			                              "2", "3", "4",
			                              "5", "6", "21",
			                              "8", "9", "10",
			                              "11", "12", "13", 
			                              "14", "15", "16",
			                              "17", "18", "19" };
	
	
	private int x, y; // card position
	private Image image;
	private boolean shouldReveal;
	private boolean matched;
	
	
	static {
		images = new Image[imageNames.length];
		for(int i=0; i<images.length; i++) {
			//images[i] = new ImageIcon("file:///Users/shivani/Documents/JrJavaMacOxygen/eclipseWS/Projects/src/MemoryGame/" + imageNames[i] + ".png").getImage();
			images[i] = new ImageIcon("src/MemoryGame/" + imageNames[i] + ".png").getImage();
		}
		
		//ImageIcon bsi = new ImageIcon("file:///Users/shivani/Documents/JrJavaMacOxygen/eclipseWS/Projects/src/MemoryGame/backside.png");
		ImageIcon bsi = new ImageIcon("src/MemoryGame/red balloon.png");
		backSideImage = bsi.getImage();
		System.out.println("backsideImage width: " + bsi.getIconWidth());
		//System.out.println("backsideImage: " + new ImageIcon(backSideImage));
	}
	
	
	
	public Card(int imageIndex, int x, int y) {
		image = images[imageIndex];
		this.x = x;
		this.y = y;
	}
	
	
	public boolean matchedWith(Card card) {
		return image==card.image;
	}
	
	public void swapImages(Card anotherCard) {
		Image temp = image;
		image = anotherCard.image;
		anotherCard.image = temp;
	}
	
	
	public void show() { shouldReveal = true; }
	public void hide() { shouldReveal = false; }
	
	public void setMatched() { matched = true; }
	public boolean hasBeenMatched() { return matched; }
	
	
	public boolean isSelected(int mx, int my) {
		return mx>x && mx<x+SIZE && my>y && my<y+SIZE;
	}
	
	
	public void draw(Graphics g) { 
		if(matched) return;
		
		//System.out.println("In draw. shouldReveal = " + shouldReveal);
		if(shouldReveal) g.drawImage(image, x+10,  y+10, SIZE-20, SIZE-20, null);
		else g.drawImage(backSideImage, x+10,  y+10, SIZE-20, SIZE-20, null);
		
		g.setColor(Color.LIGHT_GRAY);
		g.drawRect(x+5, y+5, SIZE-10, SIZE-10); 
		g.setColor(Color.BLACK);
		g.drawRect(x,  y, SIZE, SIZE); 
		
	}
	
}





