package org.dsa.topics.SlidingWindow.FixedSizeSlidingWindow;

public class FirstNegativeInEveryWindowOfSizeK {

    //https://www.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1

    public static void main(String[] args) {
     //   long[] arr = {-8, 2, 3, -6, 10};
        long[] arr = {12, -1, -7, 8, -15, 30, 16, 28};
        //5-3+1
        long[] res = printFirstNegativeInteger(arr,arr.length,3);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]+" ");
        }

    }

    public static long[] printFirstNegativeInteger(long arr[], int n, int k)
    {
        int totalNoOfWindows=n-k+1;
        long[] result = new long[totalNoOfWindows];
        long lastnegative = 0;
        /**
         * initial loop [0:k)
         */
        int i;
        for (i = 0; i < k; i++) {
            if(arr[i]<0 && lastnegative>=0) {
                lastnegative = arr[i];
            }
        }
        int fi = 0;
        int j = i;
        result[fi] = lastnegative;
        fi++;
        for (j = k; j < n; j++) {
            int outgoingIndex= j-k;
            i = j-k+1;
            if(arr[outgoingIndex]<0) {
                //find new lastnegative in between i:j
                lastnegative=0;
                for (int l = i; l <= j; l++) {
                    if(arr[l]<0) {
                        lastnegative = arr[l];
                        break;
                    }
                }
            }
            else {
                if(lastnegative<0) {
                    // as arr[outgoingIndex]>= 0 and lastNegative is <0 , so we have the soln
                    // existing soln will not change

                }
                else {
                    if(arr[j]<0) {
                        //lastnegative>0 and current no <0 so  current no is answer
                        lastnegative = arr[j];
                    }
                    else {
                        // no soln as lastnegative>0 and arr[j] >= 0;
                        lastnegative = 0;
                    }
                }
            }
            result[fi]=lastnegative;
            fi++;

        }
        return result;

    }
}


