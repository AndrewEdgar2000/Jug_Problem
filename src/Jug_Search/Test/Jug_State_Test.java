/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jug_Search.Test;

import Jug_Search.solution.Jug_State;

/**
 *
 * @author edgar
 */
public class Jug_State_Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Jug_State jug1 = new Jug_State(5,2,5,4);
        Jug_State jug2 = new Jug_State(3,2,5,4);
        
        System.out.println(jug1.hashCode());
        System.out.println(jug1.equals(jug2));

    }
    
}
