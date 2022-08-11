/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm3038.Test;

import cm3038.solution.Choice;
import cm3038.solution.Choice_Action;
import cm3038.solution.Jug_Action;
import cm3038.solution.Jug_State;

/**
 *
 * @author edgar
 */
public class Action_Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Jug_Action jug1 = new Jug_Action(Choice.JUG_A, Choice_Action.FILL_FROM_SINK);
        
        Jug_Action jug2 = new Jug_Action(Choice.JUG_B, Choice_Action.FILL_FROM_SINK);
        
        // System.out.println(jug1.toString());
        //System.out.println(jug2.toString());
        
        Jug_State jugS1 = new Jug_State(0,0,5,3);
        //Jug_State jugS2 = new Jug_State(4,0,5,3);
        System.out.println(jugS1.toString());
        System.out.println("\n");
        
        System.out.println(jugS1.applyAction(jug2));
        
        //System.out.println(jugS2.successor());
        
    }
    
}
