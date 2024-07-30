/******************************************************************************
Consider a rat placed at (0, 0) in a square matrix mat of order n* n. It has to reach the destination at (n - 1, n - 1).
Find all possible paths that the rat can take to reach from source to destination. The directions in which the rat can
move are 'U'(up), 'D'(down), 'L' (left), 'R' (right). Value 0 at a cell in the matrix represents that it is blocked and
rat cannot move to it while value 1 at a cell in the matrix represents that rat can be travel through it.
Note: In a path, no cell can be visited more than one time. If the source cell is 0, the rat cannot move to any other cell.
In case of no path, return an empty list. The driver will output "-1" automatically.

*******************************************************************************/

public class RatInMaze
{
	public void helper(int mat[][], int i, int j, int n, String path, ArrayList<String> res) {

		if(i<0 || i>=n || j<0 || j>=n || mat[i][j] == 0 ||mat[i][j]==2) {
			return;
		}

		//base casee
		if(i==n-1 && j == n-1) {
			res.add(path);
			return;
		}
		//visited elements
		int orig = mat[i][j];
		mat[i][j] = 2;
		helper(mat,i-1,j,n,path+"U",res);
		helper(mat,i+1,j,n,path+"D",res);
		helper(mat,i,j-1,n,path+"L",res);
		helper(mat,i,j+1,n,path+"R",res);
		mat[i][j] = orig;

	}


	public ArrayList<String> findPath(int[][] mat) {
		// Your code here
		ArrayList<String> res = new ArrayList<>();
		helper(mat,0,0,mat.length,"",res);
		return res;
	}

}