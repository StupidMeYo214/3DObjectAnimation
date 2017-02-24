package bonus;

import java.io.FileWriter;
import java.io.IOException;

public class Toris {
	Toris(int n1, double R1, int n2, double R2, String fileName)throws IOException
	   {  FileWriter fw = new FileWriter(fileName);
	      double delta = 2 * Math.PI / n1;
	      double rotate = 30 * Math.PI;
	      for (int i=0; i<n1; i++)
	      {  double alpha = i * delta, 
	            cosa = Math.cos(alpha), sina = Math.sin(alpha);
	         for (int j=0; j<n1; j++)
	         {  double beta = j * delta, x = R1 + Math.cos(beta);
	             float x1 = (float)(cosa * x),
	                   y1 = (float)(sina * x),
	                   z1 = (float)Math.sin(beta);
	             fw.write((i * n1 + j + 1) + " " +
	                x1 + " " + y1 + " " + z1 + "\r\n");
	         }
	      }
	      
	      double delta2 = 2 * Math.PI / n2;
	      double rotate2 = 30 * Math.PI;
	      for (int i=0; i<n2; i++)
	      {  double alpha = i * delta2, 
	            cosa = Math.cos(alpha), sina = Math.sin(alpha);
	         for (int j=0; j<n2; j++)
	         {  double beta = j * delta2, x = R2 + Math.cos(beta);
	             float x1 = (float)(cosa * x),
	                   y1 = (float)(sina * x),
	                   z1 = (float)Math.sin(beta);
	            /* fw.write((i * n2 + j + 1) + " " +
	                x1 + " " + y1 + " " + z1 + "\r\n");
	             fw.write((i * n + j + 1 + n*n) + " " +
	                     (-z1) + " " + (y1 - R) + " " + (x1) + "\r\n");*/
	             fw.write((i * n2 + j + 1 +n1*n1) + " " +
	                     (x1+R1)  + " " + (-z1) + " " + y1 + "\r\n");
	         }
	      }
	      
	      fw.write("Faces:\r\n");
	      for (int i=0; i<n1; i++)
	      {  for (int j=0; j<n1; j++)
	         {  int i1 = (i + 1) % n1, j1 = (j + 1) % n1,
	                a = i  * n1 + j  + 1,
	                b = i1 * n1 + j  + 1,
	                c = i1 * n1 + j1 + 1,
	                d = i  * n1 + j1 + 1;
	            fw.write(a + " " + b + " " + c + " " + d + ".\r\n");
	         }
	      }
	      
	      for (int i=0; i<n2; i++)
	      {  for (int j=0; j<n2; j++)
	         {  int i1 = (i + 1) % n2, j1 = (j + 1) % n2,
	                a = i  * n2 + j  + 1,
	                b = i1 * n2 + j  + 1,
	                c = i1 * n2 + j1 + 1,
	                d = i  * n2 + j1 + 1;
	            fw.write((a + n1*n1) + " " + (b + n1*n1) + " " + (c + n1*n1) + " " + (d + n1*n1) + ".\r\n");
	            //fw.write((a) + " " + (b ) + " " + (c ) + " " + (d) + ".\r\n");
	         }
	      }
	      fw.close();
	   }
}
