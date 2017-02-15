/*
 * AWT Sample application
 *
 * @Jude Ugbefu 
 * @version 1.00 14/09/17
 */
 
import javax.swing.JFrame;
import javax.swing.UIManager;
 
@SuppressWarnings("unchecked")
public class AirlineReservationSystem 
{
    
    public static void main(String[] args) 
    {
        // Create application frame.
        MainMenu frame = new MainMenu();      // Instantiate the main frame of the application
        frame.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);   // Dispose the frame when closed to release space
    	frame.setSize(600, 460);    		 // Set the size of the frame
    	frame.setResizable(false);  		 // Make the frame non-resizable
    	frame.setVisible(true);     		 // Make the frame visible
    	frame.setLocationRelativeTo(null);   // Make the frame appear at the centre of the screen
    }
}