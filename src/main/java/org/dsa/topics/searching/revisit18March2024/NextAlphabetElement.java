package org.dsa.topics.searching.revisit18March2024;

public class NextAlphabetElement {
    public static void main(String[] args) {
        char[] letters = {'c'};
        char target = 'a';
        char sol = nextGreatestLetter(letters,target);
        System.out.println(sol);

    }
    public static char nextGreatestLetter(char[] letters, char target) {
            int n = letters.length-1;
          //  if(letters.length==1)
            if(target>letters[n]) return '*';
            int low = 0;
            int high = n;
            while (low<=high) {
                int mid = (low+high)/2;
                int prevIndex = (mid-1+n)%n;
                int highIndex = (mid+1)%n;
                if(letters[mid]==target  ) return letters[mid];
                else if (letters[mid]>target ) {
                    if (letters[prevIndex] < target) {
                        return letters[mid];
                    }
                    else {
                        high = mid-1;
                    }
                }
                else if (letters[mid]<target ) {
                    low = mid+1;
                }
            }
            return letters[0];
    }
}
