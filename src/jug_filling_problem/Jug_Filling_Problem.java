
package jug_filling_problem;


public class Jug_Filling_Problem {


    public static void main(String[] args) {
        // TODO code application logic here
        State s = new State();
        BFS solver=new BFS();
        solver.Start(s);
        solver.printShortestPath();
    }
    
}
