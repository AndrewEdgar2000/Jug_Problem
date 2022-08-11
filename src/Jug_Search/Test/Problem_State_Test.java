/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jug_Search.Test;

import Jug_Search.solution.Jug_State;
import Jug_Search.solution.Problem_State;

/**
 *
 * @author edgar
 */
public class Problem_State_Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Jug_State jug1 = new Jug_State(0,0,5,4);
        Jug_State jug2 = new Jug_State(5,2,5,4);
        
        Problem_State problemState = new Problem_State(jug1, jug2);
        
        System.out.println(problemState.heuristic(jug1));
        
        //System.out.println(problemState.isGoal(jug1));

    }
    
}
