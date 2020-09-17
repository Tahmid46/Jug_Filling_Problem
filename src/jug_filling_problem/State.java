
package jug_filling_problem;

/**
 *
 * @author Tahmid
 */
public class State {
    
    int x,y; ///x= Quantity of 3L jug , y= Quantity of 5L jug
    
    public State()
    {
        x=y=0;
    }
    
    public State(int x,int y)
    {
        this.x=x;
        this.y=y;
    }
    
    public State[] genNextState()
    {
        State ret[] = new State[6];
        
        ret[0]=new State(3,y); ///Fill 3L jug
        
        ret[1]=new State(x,5); ///Fill 5L jug
        
        ret[2]= new State(x,y); 
        
        if(y>0 && x<3){  //Transferring from 5L to 3L
            
            int amount=Math.min(3-x,y);
            ret[2].x=x+amount;
            ret[2].y=y-amount;
        }
    
        
        ret[3]= new State(x,y); 
        
        if(x>0 && y<5){    //Transferring from 3L to 5L
            int amount=Math.min(x,5-y);
            ret[3].x=x-amount;
            ret[3].y=y+amount;
        }
        
        
        ret[4]=new State(0,y); ///Empty 3L jug
        ret[5]=new State(x,0); //Empty 5L jug
        
        return ret;
    }
    
    public boolean isIlligalState()
    {
        if(x==3 && y==5){
            return true;
        }
        
        return false;
    }
    
     @Override
    public String toString()
    {
        return ""+x+y; 
    }
    
}
