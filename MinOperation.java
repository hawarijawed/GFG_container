/*
Given two strings str1 and str2. The task is to remove or insert the minimum number of characters from/in str1 so as to transform it into str2. 
It could be possible that the same character needs to be removed/deleted from one point of str1 and inserted to some another point.

*/
class Solution
{
	public int minOperations(String str1, String str2) 
	{ 
	    
	    int m=str1.length(), n=str2.length();
	    int[][] c= new int[m+1][n+1];
	    for(int i=0;i<=m;i++)
        c[i][0]=0;
        for(int j=0;j<=n;j++)
        c[0][j]=0;
        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(str1.charAt(i-1)==str2.charAt(j-1))
                c[i][j]=c[i-1][j-1]+1;
                else
                c[i][j]=Math.max(c[i-1][j],c[i][j-1]);
            }
        }
        
        
	    int lcsL = c[m][n];
	    return (n-lcsL)+(m-lcsL);
	} 
}
