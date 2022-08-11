/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm3038.solution;

import cm3038.search.Path;
import cm3038.search.SearchProblem;
import java.util.Scanner;

/**
 *
 * @author edgar
 */
public class Run_Advanced_Problem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Jug A's Current volume: ");
        int jugACurrent = in.nextInt();
        System.out.println();
        
        System.out.println("Enter Jug B's Current volume: ");
        int jugBCurrent = in.nextInt();
        System.out.println();
        
        System.out.println("Enter Jug A's Max capacity: ");
        int jugACapacity = in.nextInt();
        System.out.println();
        
        System.out.println("Enter Jug B's Max capacity: ");
        int jugBCapacity = in.nextInt();
        System.out.println();
        
        Jug_State initState = new Jug_State(jugACurrent, jugBCurrent,jugACapacity,jugBCapacity);
        
        System.out.println("Enter Jug A's Goal Volume: ");
        int gJugACurrent = in.nextInt();
        System.out.println();
        
        System.out.println("Enter Jug B's Goal Volume: ");
        int gJugBCurrent = in.nextInt();
        System.out.println();
        
        Jug_State goalState = new Jug_State(gJugACurrent,gJugBCurrent,jugACapacity,jugBCapacity);
        
        SearchProblem problem = new Problem_State(initState, goalState);
        
        System.out.println("Searching...");
        Path path = problem.search();
        System.out.println("Done!");
        
        if(path == null){
            System.out.println("No Solution");
        } else {
            System.out.println("Nodes Visited: " + problem.nodeVisited);
            System.out.println("Cost: " + path.cost + "\n");
            path.print();
        }
        
    }
    
}
