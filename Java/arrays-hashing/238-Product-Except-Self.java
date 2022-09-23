import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        
        int [] result = new int[nums.length];
        int left_product_sum = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = left_product_sum;
            left_product_sum *= nums[i];
        }

        int right_product_sum = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= right_product_sum;
            right_product_sum *= nums[i];
        }
        return result;


        // int[] result = new int[nums.length];
        // int left_product_sum = 1;
        // for (int i = 0; i < nums.length; i++) {
        //     result[i] = left_product_sum;
        //     left_product_sum *= nums[i];
        // }

        // int right_product_sum = 1;
        // for (int i = nums.length - 1; i >= 0; i--) {
        //     result[i] *= right_product_sum; 
        //     right_product_sum *= nums[i];
        // }
        
        // return result;


        // int product = 1;
        // for (int elem: nums) {
        //     if (elem != 0) {
        //         product = elem * product;
        //     }
        // }

        // // System.out.println(product);
        
        // List<Integer> result = new ArrayList<>(nums.length);

        // // System.out.println(nums.length);
        // for (int elem: nums) {
        //     if (elem == 0) {
        //         result.add(product);
        //     } else {
        //         result.add(product/elem);
        //     }
        // }
        // return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        ProductExceptSelf pes = new ProductExceptSelf();

        int[] res = pes.productExceptSelf(new int []{1,2,3,4,5});
        for (int elem: res) {
            System.out.println(elem);
        }
    }
}
