package com.hw4.q1;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public class CvCubePers extends Canvas implements Runnable{
 int centerX, centerY, centerX1 ; 
   Obj3D obj = new Obj3D();
   Obj3D obj1 = new Obj3D();
   // temporary graph from image class
   Graphics tempGraph = null;
   //image class used as a buffer
   Image offscreenImage = null;
     
   int iX(float x){return Math.round(centerX + x);}
   int iX1(float x){return Math.round(centerX1 + x);}
   int iY(float y){return Math.round(centerY - y);}
   
   void line(Graphics g, int i, int j)
   {  Point2D p = obj.vScr[i], q = obj.vScr[j];
      g.drawLine(iX(p.x), iY(p.y), iX(q.x), iY(q.y));
      Point2D p1 = obj1.vScr[i], q1 = obj1.vScr[j];
      g.drawLine(iX1(p1.x), iY(p1.y), iX1(q1.x), iY(q1.y));
   }

   @Override
   public void update(Graphics g){
	   paint(g);
   }
   
   public void paint(Graphics g) 
   {  
	  init();
	  Dimension dim = getSize();
      int maxX = dim.width - 1, maxY = dim.height - 1,
          minMaxXY = Math.min(maxX, maxY);
      
      offscreenImage = this.createImage(getWidth(), getHeight());
      tempGraph = offscreenImage.getGraphics();
      
      centerX = maxX/4; centerX1 = maxX*3/4; centerY = maxY/2;
      obj.d = obj.rho * minMaxXY / obj.objSize;
      obj1.d = obj1.rho * minMaxXY / obj1.objSize;
      obj.eyeAndScreen();  
      obj1.eyeAndScreen();  
       
    // Horizontal edges at the bottom:
       line(tempGraph, 0, 1); line(tempGraph, 1, 2); line(tempGraph, 2, 3); line(tempGraph, 3, 0);
       // Horizontal edges at the top:
       line(tempGraph, 4, 5); line(tempGraph, 5, 6); line(tempGraph, 6, 7); line(tempGraph, 7, 4);
       // Vertical edges:
       line(tempGraph, 0, 4); line(tempGraph, 1, 5); line(tempGraph, 2, 6); line(tempGraph, 3, 7);
      
       Font font = new Font("TimesRoman", Font.PLAIN, 20);
       tempGraph.setFont(font);
       
       Point2D [] arr2D = obj.vScr;
       for(int i = 0; i < arr2D.length; i++){
     	  Point2D p = arr2D[i];
     	  tempGraph.drawString(String.valueOf(i), iX(p.x), iY(p.y));
       }
       
       Point2D [] arr2D1 = obj1.vScr;
       for(int i = 0; i < arr2D1.length; i++){
     	  Point2D p = arr2D1[i];
     	  tempGraph.drawString(String.valueOf(i), iX1(p.x), iY(p.y));
       }
      
       g.drawImage(offscreenImage, 0, 0, this);
   }
   
  // float alpha = (float) 0.01;
   Thread thr = new Thread(this);
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try
	      {  while(true)
	         {
	            repaint();
	            Thread.sleep(20);
	         }
	      }
	      catch (InterruptedException e){}
	}
	
	public CvCubePers() {
		// TODO Auto-generated constructor stub
		thr.start();
	}

	//rotate around a-b axis
	void init(){
		Rota3D.initRotate(obj.w[1], obj.w[5], 0.01);
		Point3D [] points = obj.w;
		for(int i = 0 ; i < points.length; i++){
			points[i] = Rota3D.rotate(points[i]);
		}
		
		Rota3D.initRotate(obj1.w[0], obj1.w[6], 0.05);
		Point3D [] points1 = obj1.w;
		for(int i = 0 ; i < points1.length; i++){
			points1[i] = Rota3D.rotate(points1[i]);
		}
	}
}
