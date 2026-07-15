class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> treasure=new LinkedList<>();
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==0)
                    treasure.add(new int[]{i,j});
            }
        }

        int directions[][]={{0,-1},{0,1},{1,0},{-1,0}};

        while(!treasure.isEmpty())
        {
            int cell[]=treasure.poll();
            int r=cell[0];
            int c=cell[1];
            
            for(int[] dir:directions)
            {
                int nr=r+dir[0];
                int nc=c+dir[1];

                if(nr<0 || nr>=grid.length || nc<0 || nc>=grid[0].length || grid[nr][nc]!=2147483647)
                {
                    continue;
                }

                grid[nr][nc]=grid[r][c]+1;

                treasure.offer(new int[]{nr,nc});
            }
        }
    }
}
