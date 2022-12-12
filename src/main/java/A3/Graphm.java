package A3;

import java.sql.SQLOutput;
import java.util.Queue;
import java.io.*;

/** Source code example for "A Practical Introduction to Data
    Structures and Algorithm Analysis, 3rd Edition (Java)" 
    by Clifford A. Shaffer
    Copyright 2008-2011 by Clifford A. Shaffer
*/

class Graphm implements Graph { // Graph: Adjacency matrix that stores mapped index at position [i][j] number 0-28
  private int[][] matrix;                // The edge matrix
  private int numEdge;                   // Number of edges
  public int[] Mark;                     // The mark array
  public int[] Count;


  
  public Graphm() {}
  public Graphm(int n) {                 // Constructor
    Init(n);
  }

  public void Init(int n) {
    Mark = new int[n];
    Count = new int[n];
    matrix = new int[n][n];
    numEdge = 0;
  }

  public int n() { return Mark.length; } // # of vertices

  public int e() { return numEdge; }     // # of edges

  public int first(int v) { // Get v's first neighbor
    for (int i=0; i<Mark.length; i++)
      if (matrix[v][i] != 0) return i;
    return Mark.length;  // No edge for this vertex
  }

  public int next(int v, int w) { // Get v's next edge
    for (int i=w+1; i<Mark.length; i++)
      if (matrix[v][i] != 0)
        return i;
    return Mark.length;  // No next edge;
  }

  public boolean isEdge(int i, int j) // Is (i, j) an edge?
    { return matrix[i][j] == i; }
  
  // Set edge weight
  public void setEdge(int i, int j, int wt) {
    if (matrix[i][j] == 0) numEdge++;
    matrix[i][j] = wt;
  }



  public int weight(int i, int j) { // Return edge weight
    return matrix[i][j];
  }

 // Get and set marks
  public void setMark(int v, int val) { Mark[v] = val; }
  public int getMark(int v) { return Mark[v]; }
  
  public int incrCount(int w) {return ++Count[w];}

  public String getPrerequisitePath(String courseCode){
      Course coen = new Course();
      coen.mapInit();







    return null;
  }

  public boolean isPrerequisite(String sourceCourse, String destinationCourse) {
      Course coen = new Course();
      coen.mapInit();

      int node1 = coen.course.get(sourceCourse);
      int node2 = coen.course.get(destinationCourse);

      if(isEdge(node1,node2)){
          System.out.println(  sourceCourse + " is a prerequisite of " + destinationCourse + "." );
        return true;
      }
      else{
          System.out.println( sourceCourse + " is not a prerequisite of " + destinationCourse + "." );
        return false;
      }
  }



}