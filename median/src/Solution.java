public class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] numsum = new int[nums1.length+nums2.length];
        int elso=0;
        int masodik=0;
        for(int i = 0; i<numsum.length; i++){
            int temp=0;
            if (nums1.length<=elso && nums2.length>masodik){
                temp=masodik;
                for (int j = temp; j<nums2.length; j++){
                    numsum[i]=nums2[j];
                    i++;
                }
                masodik=nums2.length;
                break;
            } else if (nums1.length>elso && nums2.length<=masodik){
                temp=elso;
                for (int j = temp; j<nums1.length; j++){
                    numsum[i]=nums1[j];
                    i++;
                }
                elso=nums1.length;
                break;
            }
            if (nums1.length>elso && nums2.length>masodik) {
                if (nums1[elso] < nums2[masodik] && elso < nums1.length) {

                    numsum[i] = nums1[elso];
                    elso++;
                } else if (nums1[elso] > nums2[masodik] && masodik < nums2.length) {
                    numsum[i] = nums2[masodik];
                    masodik++;
                } else if (nums1[elso] == nums2[masodik]) {
                    numsum[i] = nums1[elso];
                    elso++;
                    i++;
                    numsum[i] = nums2[masodik];
                    masodik++;
                }
            }
        }
        for (int i=0; i<numsum.length; i++){
            System.out.print(numsum[i]+" ");
        }
        int hossz = numsum.length-1;
        if (hossz % 2 == 0){
            int index = hossz/2;
            return numsum[index];
        } else {
            int index = (int) hossz/2;
            double els = numsum[index];
            double masod = numsum[index+1];
            double vege = (double)((els+masod)/2);
            return vege;
        }
    }
}