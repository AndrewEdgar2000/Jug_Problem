/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jug_Search.solution;

import Jug_Search.search.Node;
import Jug_Search.search.State;
import Jug_Search.search.informed.BestFirstSearchProblem;

/**
 *
 * @author edgar
 */
public class Problem_State extends BestFirstSearchProblem{

    //Constructor for the problem state class
    public Problem_State(State start, State goal) {
        super(start, goal);
    }

    //The heuristic function determines how many moves it will take to reach the goal state
    public double heuristic(State state){
        Jug_State jugState = (Jug_State)state;
        Jug_State goalJugState = (Jug_State)this.goalState;
        
        //Getting the difference between the goal and start state 
        int jugADiff = jugState.getJugACurrent() - goalJugState.getJugACurrent();
        int jugBDiff = jugState.getCapacityOfJugB() - goalJugState.getJugBCurrent();
        
        //Returning an absolute double
        return Math.abs(jugADiff)+Math.abs(jugBDiff);
    }
    
    
    @Override
    public double evaluation(Node node){
        //calls the heuristic function
        return node.getCost() + heuristic(node.state);
    }

    @Override
    public boolean isGoal(State state) {
        //Checks to see if the current state is the goal state
        return state.equals(this.goalState);
    }

    
    
    
    
}
