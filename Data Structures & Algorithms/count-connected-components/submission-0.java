class Solution {
    public int countComponents(int n, int[][] edges) {
        int res=0;
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++)
        {
            int a=edges[i][0];
            int b=edges[i][1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        Queue<Integer> q;
        boolean v[]=new boolean[n];
        int tq;
        List<Integer> t;

        for(int i=0;i<n;i++)
        {
            if(!v[i])
            {
                res++;
                q=new LinkedList<>();
                q.offer(i);
                v[i]=true;
                while(!q.isEmpty())
                {
                    tq=q.poll();
                    t=new ArrayList<>(adj.get(tq));
                    for(int a:t)
                    {
                        if(!v[a])
                        {
                            v[a]=true;
                            q.offer(a);
                        }
                    }
                }
            }
        }
        return res;
    }
}
