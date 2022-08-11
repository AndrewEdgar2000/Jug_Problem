/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jug_Search.solution;

import Jug_Search.search.Path;
import Jug_Search.search.SearchProblem;

/**
 *
 * @author edgar
 */
public class Run_Puzzle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Jug_State initState = new Jug_State(0,0,5,3);
        Jug_State goalState = new Jug_State(5,3,5,3);
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
