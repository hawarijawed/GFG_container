/*
Given a matrix mat[][] of dimension n * m where each cell in the matrix can have values 0, 1 or 2 which has the following meaning:
0 : Empty cell
1 : Cell have fresh oranges
2 : Cell have rotten oranges

We have to determine what is the earliest time after which all the oranges are rotten. A rotten orange at index (i, j) can rot other fresh orange at indexes (i-1, j), (i+1, j), (i, j-1), (i, j+1) (up, down, left and right) in a unit time.

Note: Your task is to return the minimum time to rot all the fresh oranges. If not possible returns -1.
*/
int rows = mat.length;
        int cols = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        int time = 0;

        // Initialize the queue with rotten oranges and count fresh oranges
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (mat[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        // If there are no fresh oranges, return 0 as no time is needed
        if (freshCount == 0) return 0;

        // Directions for the four possible neighboring cells
        int[] directions = {-1, 0, 1, 0, 0, -1, 0, 1};

        // Perform BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean hasRotten = false;

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int x = curr[0], y = curr[1];

                // Explore the 4 directions
                for (int j = 0; j < 4; j++) {
                    int newX = x + directions[j * 2];
                    int newY = y + directions[j * 2 + 1];

                    // Check bounds and if the cell is a fresh orange
                    if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && mat[newX][newY] == 1) {
                        mat[newX][newY] = 2;  // Rotten the fresh orange
                        queue.offer(new int[]{newX, newY});
                        freshCount--;  // Decrease the count of fresh oranges
                        hasRotten = true;
                    }
                }
            }

            // Increase the time after processing one layer of BFS
            if (hasRotten) {
                time++;
            }
        }

        // If there are any fresh oranges left, return -1 (impossible to rot them all)
        return freshCount == 0 ? time : -1;
