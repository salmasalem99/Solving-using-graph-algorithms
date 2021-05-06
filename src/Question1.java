

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Question1 {
    public  int PartOneAlg(LinkedList<Integer> adj[], int s, int k, int N)
    {
        int level=0;
        int sv=N+1;
        boolean visited[] = new boolean[sv];
        for(int i=0;i<sv;i++)
        {    visited[i] = false;}
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s]=true;
        int size;
        while(!q.isEmpty())
        {
            size=q.size();
            while((size--)>0)
            {
                s=q.poll();
                LinkedList<Integer> l= adj[s];
                int sl=l.size()+1;
                for( int i=1;i<sl;i++)
                {
                    int x=l.pop();
                    if(!visited[x])
                    {
                        q.add(x);
                        visited[x]=true;
                    }
                }
            }
            level++;
            if(level==k)
                return q.size();
        }
        return q.size();
    }

    public  void PartOne()
    {
        Scanner sc= new Scanner(System.in);
        int N,M,u,v,s,i,k, result1;
        System.out.print("Please Enter Number Of Vertices: " );
        N=sc.nextInt();
        System.out.print("Please Enter Number Of Edges: ");
        M=sc.nextInt();
        LinkedList<Integer> adj_list[];
        adj_list= new LinkedList[N+1];

        for(i=0;i<N+1;i++)
        {
            adj_list[i]=new LinkedList();
        }
        for(i=0;i<M;i++)
        {
            System.out.print("Please Enter Edges In The Form (U V): ");
            u=sc.nextInt();
            v=sc.nextInt();
            adj_list[u].push(v);
            adj_list[v].push(u);
        }
        System.out.print("Please Enter Starting Vertex: ");
        s=sc.nextInt();
        System.out.print("\nPlease Enter Value: ");
        k=sc.nextInt();
        result1=PartOneAlg(adj_list,s,k,N);
        System.out.println("\nResult of Part 1: "+"There are "+result1+" people with "+k+" connections away starting from "+s);
    }
}
