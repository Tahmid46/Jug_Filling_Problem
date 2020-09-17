
package jug_filling_problem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;


public class BFS {
    
    Queue<State>Q;   //BFS queue
    HashSet<String>visited; //visited array
    
    LinkedList<ArrayList<String>> paths;
    ArrayList<String> shortest_path;
    
    public BFS()
    {
        Q=new LinkedList<>();
        visited=new HashSet<>();
        paths=new LinkedList<>();
    }
    
    public void printShortestPath()
    {
        for(String s: shortest_path)
        {
            System.out.println(s);
        }
    }
    
    public void Start(State start)
    {
        Q.add(start);
        visited.add(start.toString());
        ArrayList<String> r =new ArrayList<>();
        r.add(start.toString());
        paths.add(r);
        
        while(!Q.isEmpty())
        {
            State u=Q.poll();
            shortest_path = paths.poll();
            if(u.toString().equals("34"))
            {
                System.out.println("Solution Found !");
                return;
            }
            
            State v_list[]=u.genNextState();
            
            for(State v : v_list)
            {
                if(v.isIlligalState()){
                    continue;
                }
                
                if(visited.contains(v.toString())){
                    continue;
                }
                
                visited.add(v.toString());
                Q.add(v);
                ArrayList<String>r1=new ArrayList<>(shortest_path);
                r1.add(v.toString());
                paths.add(r1);
            }
        }
    }
    
    
    
}
