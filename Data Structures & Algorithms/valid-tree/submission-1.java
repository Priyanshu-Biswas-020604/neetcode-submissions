class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length!=n-1)
            return false;
        List<List<Integer>> rel=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            rel.add(i,new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++)
        {
            int a=edges[i][0];
            int b=edges[i][1];
            rel.get(a).add(b);
            rel.get(b).add(a);
        }
        int visited=0;
        boolean v[]=new boolean[n];
        Queue<Integer> q=new LinkedList<>();
        q.offer(n-1);
        v[n-1]=true;
        while(!q.isEmpty())
        {
            int tq=q.poll();
            List<Integer> t=new ArrayList<>(rel.get(tq));
            visited++;

            for(int a:t)
            {
                if(!v[a])
                {
                    v[a]=true;
                    q.offer(a);
                }
            }
        }
        return visited==n;
    }
}
