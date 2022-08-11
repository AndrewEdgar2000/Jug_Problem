/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jug_Search.solution;

import Jug_Search.search.ActionStatePair;
import Jug_Search.search.State;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author edgar
 */
public class Jug_State implements State{
    
    //Attributes of Jug_State
    public int jugACurrent;
    public int jugBCurrent;
    public int capacityOfJugA;
    public int capacityOfJugB;
    
    //Constructor for Jug_State
    public Jug_State(int jA, int jB, int capA, int capB){
        this.jugACurrent = jA;
        this.jugBCurrent = jB;
        this.capacityOfJugA = capA;
        this.capacityOfJugB = capB;
    }
        
        //Getter Methods
        public int getJugACurrent(){
            return this.jugACurrent;
        }
        public int getJugBCurrent(){
            return this.jugBCurrent;
        }
        public int getCapacityOfJugA(){
            return this.capacityOfJugA;
        }
        public int getCapacityOfJugB(){
            return this.capacityOfJugB;
        }
        
        //Setter Methods
        public void setJugA(int jugA){
            this.jugACurrent = jugA;
        }
        public void setJugB(int jugB){
            this.jugBCurrent = jugB;
        }
        public void setCapacityOfJugA(int capA){
            this.capacityOfJugA = capA;
        }
        public void setCapacityOfJugB(int capB){
            this.capacityOfJugB = capB;
        }
        
            //applyAction method begins
            public Jug_State applyAction (Jug_Action action){
                //Creating temporary variables to store data on the jugs contents
                int tempJugA = this.jugACurrent;
                int tempJugB = this.jugBCurrent;

                    //Switch case to decide what the cost and jug contents will be
                    switch (action.choice){
                        case JUG_A:
                            switch (action.choiceAction){
                                //Fills Jug A from the sink
                                case FILL_FROM_SINK: 
                                    //Finds the correct amount of liquid to be added to the jug
                                    action.cost = (this.getCapacityOfJugA() - tempJugA) * action.fill;
                                    //Change the level of the jug to it's max
                                    tempJugA = this.getCapacityOfJugA();
                                    break;

                                //Pour A into B
                                case POUR_INTO_OTHER:
                                if((this.getJugBCurrent() + this.getJugACurrent()) >= this.getCapacityOfJugB()){
                                    action.cost = (this.getCapacityOfJugB() - this.getJugBCurrent());
                                    tempJugB = this.getCapacityOfJugB();
                                    tempJugA = this.getJugACurrent() - (this.getCapacityOfJugB() - this.getJugBCurrent());
                                } else {
                                    action.cost = (this.getJugACurrent());
                                    tempJugB = this.getJugACurrent() + this.getJugBCurrent();
                                    tempJugA = 0;
                                }
                                break;
                                
                                //Emptying Jug A into the sink
                                case EMPTY_JUG_INTO_SINK: 
                                    //Cost varies depending on how much liquid is being emptied
                                    action.cost = tempJugA * action.empty;
                                    tempJugA = 0;
                                    break;
                            }
                            break;
                    }
                   
                    /* Another switch case for Jug B
                       With the same function as for Jug A
                    */
                    switch (action.choice){
                        case JUG_B: 
                            switch (action.choiceAction){
                                case FILL_FROM_SINK:
                                    action.cost = (this.getCapacityOfJugB() - tempJugB) * action.fill;
                                    tempJugB = this.getCapacityOfJugB();
                                    break;
                                    
                                case POUR_INTO_OTHER:
                                if((this.getJugACurrent() + this.getJugBCurrent()) >= this.getCapacityOfJugA()){
                                    action.cost = (this.getCapacityOfJugA() - this.getJugACurrent());
                                    tempJugA = this.getCapacityOfJugA();
                                    tempJugB = this.getJugBCurrent() - (this.getCapacityOfJugA() - this.getJugACurrent());
                                } else {
                                    action.cost = (this.getJugBCurrent());
                                    tempJugA = this.getJugACurrent() + this.getJugBCurrent();
                                    tempJugB = 0; 
                                }
                                break;
                                
                                case EMPTY_JUG_INTO_SINK:
                                    action.cost = tempJugB * action.empty;
                                    tempJugB = 0;
                                    break;
                            }
                            break;
                    }
                //Creates new state and returns it 
                Jug_State nextState = new Jug_State (tempJugA, tempJugB, this.getCapacityOfJugA(), this.getCapacityOfJugB());
                return nextState;
            }


            @Override
            public List<ActionStatePair> successor(){

                //ArrayList to hold the ActionStatePairs
                List<ActionStatePair> result = new ArrayList<>();

                //Fill jug A from sink
                if(this.getJugACurrent() < this.getCapacityOfJugA()){
                    Jug_Action fillA = new Jug_Action(Choice.JUG_A, Choice_Action.FILL_FROM_SINK);
                    Jug_State nFillA = this.applyAction(fillA);
                    ActionStatePair fillAPair = new ActionStatePair(fillA,nFillA);
                    result.add(fillAPair);
                }
                //Fill jug B from sink
                if(this.getJugBCurrent() < this.getCapacityOfJugB()){
                    Jug_Action fillB = new Jug_Action(Choice.JUG_B, Choice_Action.FILL_FROM_SINK);
                    Jug_State nFillB = this.applyAction(fillB);
                    ActionStatePair fillBPair = new ActionStatePair(fillB, nFillB);
                    result.add(fillBPair);
                }
                //Empty jug A into the sink
                if(this.getJugACurrent() > 0 ){
                    Jug_Action emptyA = new Jug_Action(Choice.JUG_A, Choice_Action.EMPTY_JUG_INTO_SINK);
                    Jug_State nEmptyA = this.applyAction(emptyA);
                    ActionStatePair emptyAPair = new ActionStatePair(emptyA, nEmptyA);
                    result.add(emptyAPair);
                }
                //Empty Jug B into sink
                if(this.getJugBCurrent() > 0){
                    Jug_Action emptyB = new Jug_Action(Choice.JUG_B, Choice_Action.EMPTY_JUG_INTO_SINK);
                    Jug_State nEmptyB = this.applyAction(emptyB);
                    ActionStatePair emptyBPair = new ActionStatePair(emptyB, nEmptyB);
                    result.add(emptyBPair);
                }
                //Pour Jug A into Jug B
                if(this.getJugBCurrent() < this.getCapacityOfJugB() && this.getJugACurrent() > 0){
                    Jug_Action aToB = new Jug_Action(Choice.JUG_A, Choice_Action.POUR_INTO_OTHER);
                    Jug_State nAToB = this.applyAction(aToB);
                    ActionStatePair aToBPair = new ActionStatePair(aToB, nAToB);
                    result.add(aToBPair);
                }
                //Pour Jug B into Jug A
                if(this.getJugACurrent() < this.getCapacityOfJugA() && this.getJugBCurrent() > 0){
                    Jug_Action bToA = new Jug_Action(Choice.JUG_B, Choice_Action.POUR_INTO_OTHER);
                    Jug_State nBToA = this.applyAction(bToA);
                    ActionStatePair bToAPair = new ActionStatePair(bToA, nBToA);
                    result.add(bToAPair);
                }
                return result;
            }
            
        
        
        @Override
        public int hashCode(){
            int hash;
            
            //Each attribute is multiplied with a unique number 
            hash =  this.getJugACurrent()*1000 + 
                    this.getCapacityOfJugB()*100 +
                    this.getCapacityOfJugA()*10 +
                    this.getCapacityOfJugB();
            
            return hash;
        }
        
        @Override 
        public boolean equals(Object state){
            
            //Checks to see if the state object is a Jug_State type
            if(!(state instanceof Jug_State)){
                return false;
            }
            /* Checks to see if the 'tempState' attributes are the same as 
               Jug_State attributes
            */
            Jug_State tempState = (Jug_State) state;
            if(tempState.getJugACurrent() != this.getJugACurrent()) return false;
            if(tempState.getJugBCurrent() != this.getJugBCurrent()) return false;
            if(tempState.getCapacityOfJugA() != this.getCapacityOfJugA()) return false;
            if(tempState.getCapacityOfJugB() != this.getCapacityOfJugB()) return false;
            return true;
        }
        
    //toString method to output information about the state
    @Override 
    public String toString(){
        return "Jug A's Current level: " + this.getJugACurrent() + 
                "\nJug A's Maximum Capacity: " + this.getCapacityOfJugA() +
                "\n \nJug B's Current level: " + this.getJugBCurrent() + 
                "\nJug B's Maximum Capacity: " + this.getCapacityOfJugB();
        
    }
    
    
    
    
    
    
}
