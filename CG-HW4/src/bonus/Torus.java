package bonus;
// Torus.java: Generating a data file for a torus. R is the radius of 
//    a large horizontal circle, on which n equidistant points will be
//    the centers of small vertical circles with radius 1. The values
//    of n and R as well as the output file name are to be supplied as
//    program arguments.

// Copied from Appendix E of
//    Ammeraal, L. and K. Zhang (2007). Computer Graphics for Java Programmers, 2nd Edition,
//       Chichester: John Wiley.

import java.io.*;

public class Torus
{  public static void main(String[] args)throws IOException
   {  
      new TorusObj(25, 3, "lalala.dat");
   } 
}

class TorusObj
{  TorusObj(int n, double R, String fileName)throws IOException
   {  FileWriter fw = new FileWriter(fileName);
      double delta = 2 * Math.PI / n;
      double rotate = 30 * Math.PI;
      for (int i=0; i<n; i++)
      {  double alpha = i * delta, 
            cosa = Math.cos(alpha), sina = Math.sin(alpha);
         for (int j=0; j<n; j++)
         {  double beta = j * delta, x = R + Math.cos(beta);
             float x1 = (float)(cosa * x),
                   y1 = (float)(sina * x),
                   z1 = (float)Math.sin(beta);
             fw.write((i * n + j + 1) + " " +
                x1 + " " + y1 + " " + z1 + "\r\n");
             /*fw.write((i * n + j + 1 + n*n) + " " +
                     (-z1) + " " + (y1 - R) + " " + (x1) + "\r\n");*/
             /*fw.write((i * n + j + 1 + n*n) + " " +
                     (x1 + R) + " " + (-z1) + " " + (y1) + "\r\n");*/
             fw.write((i * n + j + 1 + n*n) + " " +
                     (x1+R) + " " + y1 + " " + z1 + "\r\n");
         }
      }
      fw.write("Faces:\r\n");
      for (int i=0; i<n; i++)
      {  for (int j=0; j<n; j++)
         {  int i1 = (i + 1) % n, j1 = (j + 1) % n,
                a = i  * n + j  + 1,
                b = i1 * n + j  + 1,
                c = i1 * n + j1 + 1,
                d = i  * n + j1 + 1;
            fw.write(a + " " + b + " " + c + " " + d + ".\r\n");
            fw.write((a + n*n) + " " + (b + n*n) + " " + (c + n*n) + " " + (d + n*n) + ".\r\n");
         }
      }
      fw.close();
   }
}
