import javax.swing.*;
import java.awt.*;

public class logo extends JPanel
{
	//logo is the class used to generate the hotel logo

	private String myText;

	public logo()
	{
		super();
		
		this.myText ="Hotel Pangkor";
	}
	


	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		this.setBackground(Color.YELLOW);

		g.setColor(Color.BLACK);
		g.fillRect(20, 20, 340, 100);
		
		g.setColor(new Color(240,226,38)); //another way to create a color
		g.fillRect(30, 30, 320, 80);

		
		g.setColor(Color.cyan);
		//g.fillArc(x, y, width, height, startAngle, arcAngle);

		g.fillArc(30, 45, 640, 130 , 90, 90);

		//Fills a rectangle


		g.setColor(new Color(240,38,85));
		Font font = new Font("Serif", Font.BOLD, 48);
		g.setFont(font);
		g.drawString(myText, 40, 90);
		
	}



	public String getMyText() {
		return myText;
	}



	public void setMyText(String myText) {
		this.myText = myText;
	}
	
}

