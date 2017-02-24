package com.hw4.q2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.hw4.q1.CvCubePers;

public class BonusViewer extends Frame{

	String fileName;

	public BonusViewer(String fileName) {
		// TODO Auto-generated constructor stub
		
		super(fileName);
		this.fileName = fileName;
		Obj3D obj3d = new Obj3D();
		obj3d.read(fileName);
		addWindowListener(new WindowAdapter()
        {public void windowClosing(WindowEvent e){e.getWindow().dispose();}});
     setLayout(new BorderLayout());
     add("Center", new CvPainter( obj3d ));
     Dimension dim = getToolkit().getScreenSize();
     setSize(dim.width/2, dim.height/2);
     setLocation(dim.width/4, dim.height/4);
     setVisible(true);
	}
}
