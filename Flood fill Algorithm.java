/*
You are given a 2D grid image[][] of size n*m, where each image[i][j] represents the color of a pixel in the image. Also provided a coordinate(sr, sc) representing the starting pixel (row and column) and a new color value newColor.

Your task is to perform a flood fill starting from the pixel (sr, sc), changing its color to newColor and the color of all the connected pixels that have the same original color. Two pixels are considered connected if they are adjacent horizontally or vertically (not diagonally) and have the same original color.
*/
class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // Code here
        int originalColor = image[sr][sc];
        if (originalColor == newColor) return image; // Avoid infinite loop

        dfs(image, sr, sc, originalColor, newColor);
        return image;
    }
    
    private void dfs(int[][] image, int i, int j, int originalColor, int newColor) {
        int rows = image.length;
        int cols = image[0].length;

        // Base case: check bounds and color
        if (i < 0 || i >= rows || j < 0 || j >= cols || image[i][j] != originalColor) {
            return;
        }

        // Change color
        image[i][j] = newColor;

        // Directions: up, down, left, right
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};

        // Explore neighbors
        for (int dir = 0; dir < 4; dir++) {
            int newRow = i + dRow[dir];
            int newCol = j + dCol[dir];
            dfs(image, newRow, newCol, originalColor, newColor);
        }
    }
}
