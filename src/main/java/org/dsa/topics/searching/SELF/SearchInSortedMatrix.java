package org.dsa.topics.searching.SELF;

public class SearchInSortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 60;
        String result = searchMatrixOptimized(matrix,target)? "YES":"NO";
        System.out.println(result);
    }

    /**
     * Using this approach my intuition is that , if a element is to be found in a sorted  matrix like in the problem statement,
     * Here each row elements are sorted , and it propagates to next row too
     * i.e. arr[i][last] < arr[i+1][0]
     * If you want to find the target ,for e.g.
     *   1      3     5     7
     *   10    11     16   20
     *   23    30     34   60
     *   here m=3 and n=4;
     *   So if I want to find say 30
     *   for each row , i will check , that whether target lies between its start and end element
     *   if(target>= first && target<=last)
     *   i.e . for e.g. at row = 0
     *    i will check whether target>=arr[0][0] i.e .1 and target<=arr[0][n-1] , it that's true , then we will have element
     *    in this 1d array arr[0] i.e. in between arr[0][0]...arr[0][n-1];, we can do binary search to find the same
     *    Since its not for arr[0] subarray , we will move to next 1d array arr[1] arr[2]  and so on , till the condition
     *     if(target>= arr[i][0] && target<=arr[i][last]) is met and we find no within the 1D subarray using binary search
     *    so Time complexity is O(mlog(n))
     *
     *
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        boolean found = false;
        int lenOf1d = matrix[0].length;
        for (int i = 0; i < matrix.length && !found; i++) {
            int len = lenOf1d;
            int first = matrix[i][0];
            int last = matrix[i][len-1];
            if(target>= first && target<=last) {
                found = findIn1DArray(matrix[i], target);
            }
        }
        return found;
    }

    private static boolean findIn1DArray(int[] arr, int target) {
        int low = 0;
        int high = arr.length-1;
        while (low<=high ) {
            int mid = (low+high)/2;
            if(arr[mid]==target) {
                return true;
            }
            else if(arr[mid]>target) {
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return false;

    }


/**
 * Here we need to find   if a element is to be found in a sorted  matrix like in the problem statement,
 * Here each row elements are sorted , and it propagates to next row too
 * i.e. arr[i][last] < arr[i+1][0]
 * We can flatten this to reimagine this as 1d array
 * so arr[][] of 3x4 will be translated to
 * arr[0][0]<arr[0][1]<arr[0][2]<arr[0][3]<arr[1][0]<arr[1][1]<arr[1][2]<arr[1][3]<arr[2][0]<arr[2][1]<arr[2][2]<arr[2][3]
 * So we have 12 elements all sorted
 * we can reimagine this , as 1d array , with 3x4=12 nos in it all sorted
 * arr[0][0]<arr[0][1]<arr[0][2]<arr[0][3]<arr[1][0]<arr[1][1]<arr[1][2]<arr[1][3]<arr[2][0]<arr[2][1]<arr[2][2]<arr[2][3]
 *
 *  So now problem statement reduces to finding a element in 1d sorted array , where we can easily apply binary search
 *
 *  But we can only imagine this 2d array as 1d array with mxn elements , we cannot create it as it will increase the space complexity
 *  So we have to rely on a logic to convert an index from 1d array in a corresponding element of 2d array and this value from 2d array will be used for evaluaiton
 *
 *
 *  so if we say what is the actual index of i=7 from this 1d array in a 2d array of mxn arr[m][n] say for  3x4 in this example
 *  in that case x = i/n, y = i%n , for 7 x=7/4=>1 , and y = 7%4=3 , so i=7 in 1d array is corresponsding to arr[x][y] i.e. arr[1][3]
 *
 *  So now logic is
 *
 *  while (lowIndex<=highIndex) {
 *                 int mid = (lowIndex+highIndex)/2;
 *                 Pair pair = getActualIndex(mid,m,n); // gives me x and y index/n , index%n
 *                 int x = pair.x;
 *                 int y = pair.y;
 *                 if(matrix[x][y] == target) {
 *                     return true; // solution found
 *                 }
 *                 else if(matrix[x][y]>target) {
 *                 // here as element is greater than target we ideally move high = mid-1 , just like we did in 1d array
 *                     highIndex = mid-1;
 *                 }
 *                 else {
 *                 here as element is smaller than target we ideally move low = mid+1 , just like we did in 1d array
 *                     lowIndex = mid+1;
 *
 *                 }
 *             }
 * If you want to find the target ,for e.g.
 *   1      3     5     7
 *   10    11     16   20
 *   23    30     34   60
 *   here m=3 and n=4;
 *   So if I want to find say 30
 *   for each row , i will check , that whether target lies between its start and end element
 *   if(target>= first && target<=last)
 *   i.e . for e.g. at row = 0
 *    i will check whether target>=arr[0][0] i.e .1 and target<=arr[0][n-1] , it that's true , then we will have element
 *    in this 1d array arr[0] i.e. in between arr[0][0]...arr[0][n-1];, we can do binary search to find the same
 *    Since its not for arr[0] subarray , we will move to next 1d array arr[1] arr[2]  and so on , till the condition
 *     if(target>= arr[i][0] && target<=arr[i][last]) is met and we find no within the 1D subarray using binary search
 *    so Time complexity is O(mlog(n))
 *
 *
 *
 * */
    public static boolean searchMatrixOptimized(int[][] matrix, int target) {
            int m = matrix.length;
            int n = matrix[0].length;
            int totalNo = m*n;
            int highIndex = totalNo-1;
            int lowIndex = 0;
            while (lowIndex<=highIndex) {
                int mid = (lowIndex+highIndex)/2;
                Pair pair = getActualIndex(mid,m,n);
                int x = pair.x;
                int y = pair.y;
                if(matrix[x][y] == target) {
                    return true;
                }
                else if(matrix[x][y]>target) {
                    highIndex = mid-1;
                }
                else {
                    lowIndex = mid+1;

                }
            }
            return false;
    }

    private static Pair getActualIndex(int flattenedIndex,int m,int n) {
        int x = flattenedIndex/n;
        int leftAfterDivision = flattenedIndex%n;
        int y = leftAfterDivision;
        return new Pair(x,y);
    }



}

 class  Pair {

    int x ;
    int y;

     public Pair(int x, int y) {
         this.x = x;
         this.y = y;
     }

     public int getX() {
         return x;
     }

     public void setX(int x) {
         this.x = x;
     }

     public int getY() {
         return y;
     }

     public void setY(int y) {
         this.y = y;
     }
 }
