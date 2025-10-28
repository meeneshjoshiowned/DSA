import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    public static void main(String args[])
    {
        int grid[][]={ {2,1,1} , {1,1,0} , {0,1,1} };
        int rotting = orangesRotting(grid);
        System.out.println("Minimum Number of Minutes Required "+rotting);
    }

    public static int orangesRotting(int[][] grid){
        if (grid == null || grid.length == 0) return -1;

        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        int freshCount = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    freshCount++;
                }
            }
        }

        // If no fresh oranges, result is 0 minutes
        if (freshCount == 0) return 0;

        int minutesElapsed = 0;
        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        // 2. BFS by layers: each iteration is one minute
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rottedThisMinute = false;

            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int r = cell[0], c = cell[1];

                for (int[] d : dirs) {
                    int nr = r + d[0];
                    int nc = c + d[1];

                    // Check valid neighbour and if it's a fresh orange
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1) {
                        // This fresh orange now becomes rotten
                        grid[nr][nc] = 2;
                        freshCount--;
                        rottedThisMinute = true;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }

            if (rottedThisMinute) {
                minutesElapsed++;
            }
        }

        // 3. If there are still fresh oranges, impossible
        return (freshCount == 0) ? minutesElapsed : -1;
    }
}
