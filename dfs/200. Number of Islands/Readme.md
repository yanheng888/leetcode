
两个重要函数：
```
//determine if index is out of range
public boolean check(int r, int c,int m, int n){
    if(r>=m || r<0 || c>=n || c<0){
        return false;
    }
    return true;
}


public void dfs(char[][] grid, int r, int c){
    //check index
    if(!check(r,c,grid.length,grid[0].length)){
        return;
    }
    if(grid[r][c] == '0'){
        return;
    }
    grid[r][c] = '0';
    //up,down,left,right
    dfs(grid,r-1,c);
    dfs(grid,r+1,c);
    dfs(grid,r,c-1);
    dfs(grid,r,c+1);
}
```

通常dfs matrix 就是检查index,标记visited
