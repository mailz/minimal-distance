/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mailz.mindistance;

import static java.lang.Math.abs;
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
        int n = 4;
        Dot[] dots = new Dot[n];
        dots[0] = new Dot(10, 20);
        dots[1] = new Dot(-10, -10);
        dots[2] = new Dot(20, 30);
        dots[3] = new Dot(40, -10);
        double minimalDistance = Double.MAX_VALUE;

        // для слияния массивов
        ArrayList<Dot> t = new ArrayList<>();

        //сортировка по X
        Arrays.sort(dots, new Comparator<Dot>() {
            @Override
            public int compare(Dot a, Dot b) {
                int result = a.getX() - (b.getX());
                return (result < 0.0) ? -1 : (result > 0.0) ? 1 : 0;
            }
        });

        minimalDistance = rec(0, dots.length - 1, dots, t, minimalDistance);
        System.out.println(minimalDistance);
    }

    static double rec(int l, int r, Dot[] arr, ArrayList<Dot> t, double minDistance) {
        int i, j;
        if (r - l < 4) {
            for (i = l; i <= r; ++i) {
                for (j = i + 1; j <= r; ++j) {
                    minDistance = computeMinimalDistance(arr[i], arr[j], minDistance);
                }
            }
            Arrays.sort(arr, new Comparator<Dot>() {
                @Override
                public int compare(Dot a, Dot b) {
                    int result = a.getY() - (b.getY());
                    return (result < 0.0) ? -1 : (result > 0.0) ? 1 : 0;
                }
            });
            return minDistance;
        }

        int m = (l + r) / 2;
        int midx = arr[m].getX();
        rec(l, m, arr, t, minDistance);
        rec(m + 1, r, arr, t, minDistance);
        Arrays.sort(arr, new Comparator<Dot>() {
            @Override
            public int compare(Dot a, Dot b) {
                int result = a.getY() - (b.getY());
                return (result < 0.0) ? -1 : (result > 0.0) ? 1 : 0;
            }
        });

        for (i = l; i <= r; ++i) {
            if (abs(arr[i].getX() - midx) < minDistance) {
                for (j = t.size() - 1; j >= 0 && arr[i].getY() - t.get(j).getY() < minDistance; --j) {
                    minDistance = computeMinimalDistance(arr[i], t.get(j), minDistance);
                }
                t.add(arr[i]);
            }
        }
        return minDistance;
    }

    public static double computeMinimalDistance(Dot a, Dot b, double minDist) {
        double distance = sqrt((a.getX() - b.getX()) * (a.getX() - b.getX()) + (a.getY() - b.getY()) * (a.getY() - b.getY()));
        return distance < minDist ? distance : minDist;
    }

    public static double computeDistance(Dot a, Dot b) {
        return sqrt((a.getX() - b.getX()) * (a.getX() - b.getX()) + (a.getY() - b.getY()) * (a.getY() - b.getY()));
    }

}
