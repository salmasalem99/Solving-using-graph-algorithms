
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;
public class Question3 {
    
    static void path(int[]parents, int destination, int source)
    {
        Stack<Integer> path = new Stack();
        path.add(destination);
        int current = parents[destination];
        path.add(current);
        while(current!=source)
        {
            current = parents[current];
            path.add(current);
        }
        Stack<Integer> copy = new Stack();
        current = path.pop();
        copy.push(current);
        System.out.print(" \nThe route with minimum cost is: " + current);
        while(!path.empty())
        {
            current = path.pop();
            System.out.print("->"+current);
            copy.push(current);
        } 
    }
    public static void Dijkstra_Algorithm(LinkedList<Flight>adj[],int source, int M, int N, int dest)
    {
       int [] time;
       int [] parent;
       time = new int [N+1];
       parent = new int [N+1];
       parent [source] = source;
       PriorityQueue <Flight> q;
       q = new PriorityQueue <> (N,new costComparator());
       boolean [] visited;
       visited = new boolean [N+1];  
       int [] d;
       d = new int[N+1];
       for(int i=1;i<N+1;i++)
       {
           Flight f = new Flight();
           f.cost = Integer.MAX_VALUE;
           if(i==source) f.cost=0;  
           visited [i] = false;  
           f.Destination = i;
           q.add(f);
           d [i] = Integer.MAX_VALUE;
           time [i] = 0;
       }
       d [source] = 0;
       Flight u; 
       Flight fl; 
       LinkedList <Flight> fll; 
       while(!q.isEmpty())
       {
           u = q.remove();
           visited [u.Destination] = true;
           fll = adj [u.Destination];
           int size = fll.size();
           for(int i=0;i<size;i++)
           {
               fl = fll.get(i);
               int destination = fl.Destination;
               int additional_cost = 0;
               int additional_time = 0;
               if(u.Destination!=source) 
               {
                   additional_cost = M;
                   additional_time = 1;
               }
               int qsize = q.size();
               int cu2fl = fl.cost;
               if(d[u.Destination]+cu2fl+additional_cost < d[destination] && !visited[destination])
               {
                   d [destination] = d [u.Destination] + cu2fl+additional_cost;
                   parent [destination] = u.Destination;
                   LinkedList <Flight> l2 = new LinkedList();
                   time [destination] = fl.time + time[u.Destination] + additional_time;
                   while(!q.isEmpty())
                   {
                       Flight newF ;
                       newF = q.remove();
                       if(newF.Destination==destination)
                       {
                           newF.cost = d[destination];
                       }
                       l2.add(newF);
                   } 
                    while(!l2.isEmpty())
                    {
                        q.add(l2.poll());
                    }
               }
            }
       }
       path(parent,dest,source);
       System.out.print("\nTotal time "+time[dest]+" hours");
       System.out.print("\ncost of trip: " + d[dest] + "$ \n");
    } 

    
    public static void PartThree()
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("please enter amount m: ");
        int M = sc.nextInt();
        System.out.print("please enter number of cities: ");
        int N = sc.nextInt();
        System.out.print("please enter number of routes: ");
        int R = sc.nextInt();
        
        //Initialisatiion of adjacency list according to input number of cities
        LinkedList <Flight> adj_list[];
        adj_list = new LinkedList [N+1];
        for(int i=0;i<N+1;i++)
        {
            LinkedList <Flight> f = new LinkedList();
            adj_list [i] = f;
        }
        
        //Construction of adjacency list according to input routes

        int city1;
        int city2;
        int t;
        int cost;
        for(int i=0;i<R;i++)
        {
            System.out.print("please enter source, destination, time and cost for each route: ");
            Flight f1 = new Flight();
            Flight f2 = new Flight();
            city1 = sc.nextInt();
            city2 = sc.nextInt();
            t = sc.nextInt();
            cost = (t*M) + sc.nextInt();
            f1.Destination = city1;
            f2.Destination = city2;
            f1.time=f2.time = t;
            f1.cost = f2.cost = cost;
            adj_list [city1].add(f2);
            adj_list [city2].add(f1);
        }
        
        int s;
        int d;
        System.out.print("please enter source city: ");
        s = sc.nextInt();
        System.out.print("please enter destination city: ");
        d = sc.nextInt(); 
        
        Dijkstra_Algorithm(adj_list,s,M,N,d);
    }   
}
