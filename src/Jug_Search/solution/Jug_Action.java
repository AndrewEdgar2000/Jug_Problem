/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jug_Search.solution;

import Jug_Search.search.Action;

/**
 *
 * @author edgar
 */

public class Jug_Action extends Action {
    
    //Attributes of Jug_Action
    public Choice choice;
    public Choice_Action choiceAction;
    public double amount;
    double fill = cost * 5.0;
    double empty = cost * 20.0;

    /**
     * Constructor for Jug_Action
     * @param c
     * @param cA
     */
    public Jug_Action(Choice c, Choice_Action cA){
                this.choice = c;
                this.choiceAction = cA;
            }

    /**
     * toString method outputs the information of the Jug_Action object
     * @return
     */
    @Override 
    public String toString(){
        
        String result = "";
        
        //Switch statement to determine what the output should be 
        switch (choice){
            case JUG_A: 
                switch (choiceAction){
                    case FILL_FROM_SINK:        result += "Filling Jug A, from the sink. \nCost: " + cost;
                                                break;
                    case POUR_INTO_OTHER:       result += "Pouring Jug A into Jug B. \nCost: " + cost;
                                                break;
                    case EMPTY_JUG_INTO_SINK:   result += "Emptying Jug A into the sink. \nCost: " + cost;
                                                break;
                }
                break;
            case JUG_B:
                switch (choiceAction){
                    case FILL_FROM_SINK:        result += "Filling Jug B, from the sink. \nCost: " + cost;
                                                break;
                    case POUR_INTO_OTHER:       result += "Pouring Jug B into Jug A. \nCost: " + cost;       
                                                break;
                    case EMPTY_JUG_INTO_SINK:   result += "Emptying Jug A into the sink. \nCost: " + cost;
                                                break;
                }
        }
        return result;
    }
}
