import java.io.IOException;

import javax.swing.JFrame;

/**
 * 
 * @author belaid
 *
 */
public class LionHeart extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	
	/**
	 * 
	 * @throws IOException
	 */
	public LionHeart() throws IOException {

		super("LionHeart");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Plateau plateau = new Plateau();
		add(plateau);

		pack();
		setVisible(true);
	}

	/**
	 * 
	 * @param arg
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	public static void main(String[] arg) throws IOException {

		LionHeart l = new LionHeart();
	}

}