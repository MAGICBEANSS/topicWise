package org.dsa.topics.mcm;

import java.util.Arrays;

public class PalindromicMemoizedOptimised {
    private static int[][] mat;
    static long  dc=0;

    public static void main(String[] args) {

        String str = "fiefhgdcdcgfeibggchibffahiededbbegegdfibdbfdadfbdbceaadeceeefiheibahgececggaehbdcgebaigfacifhdbecbebfhiefchaaheiichgdbheacfbhfiaffaecicbegdgeiaiccghggdfggbebdaefcagihbdhhigdgbghbahhhdagbdaefeccfiaifffcfehfcdiiieibadcedibbedgfegibefagfccahfcbegdfdhhdgfhgbchiaieehdgdabhidhfeecgfiibediiafacagigbhchcdhbaigdcedggehhgdhedaebchcafcdehcffdiagcafcgiidhdhedgaaegdchibhdaegdfdaiiidcihifbfidechicighbcbgibadbabieaafgeagfhebfaheaeeibagdfhadifafghbfihehgcgggffgbfccgafigieadfehieafaehaggeeaaaehggffccddchibegfhdfafhadgeieggiigacbfgcagigbhbhefcadafhafdiegahbhccidbeeagcgebehheebfaechceefdiafgeddhdfcadfdafbhiifigcbddahbabbeedidhaieagheihhgffbfbiacgdaifbedaegbhigghfeiahcdieghhdabdggfcgbafgibiifdeefcbegcfcdihaeacihgdchihdadifeifdgecbchgdgdcifedacfddhhbcagaicbebbiadgbddcbagbafeadhddaeebdgdebafabghcabdhdgieiahggddigefddccfccibifgbfcdccghgceigdfdbghdihechfabhbacifgbiiiihcgifhdbhfcaiefhccibebcahidachfabicbdabibiachahggffiibbgchbidfbbhfcicfafgcagaaadbacddfiigdiiffhbbehaaacidggfbhgeaghigihggfcdcidbfccahhgaffiibbhidhdacacdfebedbiacaidaachegffaiiegeabfdgdcgdacfcfhdcbfiaaifgfaciacfghagceaaebhhibbieehhcbiggabefbeigcbhbcidbfhfcgdddgdffghidbbbfbdhcgabaagddcebaechbbiegeiggbabdhgghciheabdibefdfghbfbfebidhicdhbeghebeddgfdfhefebiiebdchifbcbahaddhbfafbbcebiigadhgcfbebgbebhfddgdeehhgdegaeedfadegfeihcgeefbbagbbacbgggciehdhiggcgaaicceeaefgcehfhfdciaghcbbgdihbhecfbgffefhgiefgeiggcebgaacefidghdfdhiabgibchdicdehahbibeddegfciaeaffgbefbbeihbafbagagedgbdadfdggfeaebaidchgdbcifhahgfdcehbahhdggcdggceiabhhafghegfdiegbcadgaecdcdddfhicabdfhbdiiceiegiedecdifhbhhfhgdbhibbdgafhgdcheefdhifgddchadbdggiidhbhegbdfdidhhfbehibiaacdfbiagcbheabaaebfeaeafbgigiefeaeheabifgcfibiddadicheahgbfhbhddaheghddceedigddhchecaghdegigbegcbfgbggdgbbigegffhcfcbbebdchffhddbfhhfgegggibhafiebcfgeaeehgdgbccbfghagfdbdfcbcigbigaccecfehcffahiafgabfcaefbghccieehhhiighcfeabffggfchfdgcfhadgidabdceediefdccceidcfbfiiaidechhbhdccccaigeegcaicabbifigcghcefaafaefd";
        System.out.println(minCut(str)+" dc="+dc);
    }

    public static int minCut(String str) {

        mat = new int[str.length()][str.length()];
        initDPMatrix(mat);
        return findPossiblePartitionsMemo(str,0,str.length()-1);

    }



    private static int findPossiblePartitionsMemo(String str, int i, int j) {

        if(i>=j) {
            return 0;
        }
        if(mat[i][j]!=-1) {
            dc++;
            // just to count how much we saved;
            System.out.println("Not solving for i="+i+" and j="+j+" dc="+dc);
            return mat[i][j];
        }
     //   System.out.println("solving for i="+i+" and j="+j);
        if(isPalindrome(str.substring(i,j+1))) {
            return 0;
        }

        int count = Integer.MAX_VALUE;
        for (int k=i;k<j;k++) {
            int pcount=0;
            pcount++;// we are partitioning at k=i
            if(mat[k+1][j]==-1) {
                mat[k+1][j] =  findPossiblePartitionsMemo(str,k+1,j);
            }
            else {
                // just to count how much we saved;
                dc++;
            }
            pcount = pcount+mat[k+1][j];
            if(mat[i][k]==-1) {
                mat[i][k] =  findPossiblePartitionsMemo(str,i,k);
            }
            else {
                // just to count how much we saved;
                dc++;
            }
            pcount = pcount+mat[i][k];
            count = Math.min(count,pcount);
        }
        mat[i][j] = count;
        return count;

    }

    private static boolean isPalindrome(String s) {
        return s.isEmpty() || s.contentEquals(new StringBuilder(s).reverse());
    }

    private static void initDPMatrix(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            Arrays.fill(mat[i],-1);
        }
    }
}
