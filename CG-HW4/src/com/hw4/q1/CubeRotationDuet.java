package com.hw4.q1;

import java.awt.*;
import java.awt.event.*;


public class CubeRotationDuet extends Frame{
	public static void main(String[] args){new CubeRotationDuet();}
	 
	   CubeRotationDuet()
	   {  super("Cube Rotation Duet");
	      addWindowListener(new WindowAdapter()
	         {public void windowClosing(WindowEvent e){System.exit(0);}});
	      setLayout(new BorderLayout());
	      add("Center", new CvCubePers());
	      Dimension dim = getToolkit().getScreenSize();
	      setSize(dim.width/2, dim.height/2);
	      setLocation(dim.width/4, dim.height/4);
	      setVisible(true);
	   }
}
