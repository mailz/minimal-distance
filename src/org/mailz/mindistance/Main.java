/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.mailz.mindistance;

import static java.lang.Math.sqrt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author ubick
 */


public class Main {

    /**
     * @param args the command line arguments
     */
     
    
    public static void main(String[] args) {
        // TODO code application logic here
       Dot [] dots = new Dot [3 ];
       dots[0] = new Dot(100,200);
       dots[1] = new Dot(20,8030);
       dots[2] = new Dot(30,60);
       //X
       Arrays.sort(dots, new Comparator<Dot> () {
            @Override
            public int compare(Dot a, Dot b) {
                int result =  a.getX()-(b.getX());
                return ( result < 0.0 ) ? -1 : ( result > 0.0 ) ? 1 : 0;
            }
        });
       //Y
        Arrays.sort(dots, new Comparator<Dot> () {
            @Override
            public int compare(Dot a, Dot b) {
                int result =  a.getY()-(b.getY());
                return ( result < 0.0 ) ? -1 : ( result > 0.0 ) ? 1 : 0;
            }
        });
        
        double minimalDistance;
        Dot ma, mb;

        
        
    }
    
   void rec(int l, int r)
{
  int i, j;
  if (r - l < 4) {
    for (i = l; i <= r; ++i)
      for (j = i + 1; j <= r; ++j)
         computeDistance(dots[i], dots[j]);
    Arrays.sort(dots[0] + l, dots[0] + r + 1, cmp_y);
    return;
  }
 
  int m = (l + r) / 2;
  int midx = x[m].x;
  rec(l, m);
  rec(m + 1, r);
  inplace_merge(x.begin() + l, x.begin() + m + 1, x.begin() + r + 1, cmp_y);
 
  vector<dot> t;
  for (i = l; i <= r; ++i)
    if (abs(x[i].x - midx) < mindist) {
      for (j = t.size() - 1; j >= 0 && x[i].y - t[j].y < mindist; --j)
        upd_ans (x[i], t[j]);
      t.push_back(x[i]);
    }
}
 
    
    
   public double computeDistance(Dot a, Dot b){
    return sqrt ((a.getX()-b.getX())*(a.getX()-b.getX()) + (a.getY()-b.getY())*(a.getY()-b.getY()));
}


}