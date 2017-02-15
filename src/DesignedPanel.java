/**
 * @(#)DesignPanel.java
 *
 *
 * @Jude Ugbefu
 * @version 1.00 2014/9/17
 */


import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

//@SuppressWarnings("unchecked")
public class DesignedPanel extends JPanel
{
   	Image bgimage = null;

   	public DesignedPanel(String imageName)
    {
     	MediaTracker mt = new MediaTracker(this);
      	bgimage = Toolkit.getDefaultToolkit().getImage(imageName);
        mt.addImage(bgimage, 0);
      	try
       	{
         	mt.waitForAll();
      	}
       	catch (InterruptedException e)
       	{
         	e.printStackTrace();
        }
    }
  	protected void paintComponent(Graphics g)
   	{
       	super.paintComponent(g);
     	int imwidth = bgimage.getWidth(null);
        int imheight = bgimage.getHeight(null);
        g.drawImage(bgimage, 1, 1, null);
    }
    
}