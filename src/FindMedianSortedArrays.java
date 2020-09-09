public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2){
        int l1 = nums1.length;
        int l2 = nums2.length;
        int front1 = 0;
        int front2 = 0;
        double mid;
        if((l1 + l2) % 2 == 0){
            mid = (findKthSmall(nums1, front1, nums2, front2, (l1 + l2)/2) + findKthSmall(nums1, front1, nums2, front2, (l1 + l2)/2 + 1)) / 2;
        }else {
            mid = findKthSmall(nums1, front1, nums2, front2, (l1 + l2 + 1)/2);
        }
        return mid;
    }
    private double findKthSmall(int[] nums1, int front1, int[] nums2, int front2, int k){
        if(front1 == nums1.length) {
            return nums2[front2 + k - 1];
        }
        if(front2 == nums2.length) {
            return nums1[front1 + k - 1];
        }
        if(k == 1){
            double out = (nums1[front1] <= nums2[front2]) ? nums1[front1] : nums2[front2];
            return out;
        }
        int half = k/2;
        int index1 = (front1 + half < nums1.length) ? front1 + half : nums1.length;
        int index2 = (front2 + half < nums2.length) ? front2 + half : nums2.length;
        if(nums1[index1 - 1] <= nums2[index2 - 1]){
            return findKthSmall(nums1, index1, nums2, front2, k - (index1 - front1));
        }else{
            return findKthSmall(nums1, front1, nums2, index2, k- (index2 - front2));
        }
    }

    public static void main(String[] args){
        FindMedianSortedArrays Object = new FindMedianSortedArrays();
        System.out.println(Object.findMedianSortedArrays(new int[] {0,0,0,0,0}, new int[] {-1,0,0,0,0,0,1}));

    }
}
