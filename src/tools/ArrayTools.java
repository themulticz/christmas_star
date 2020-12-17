package tools;

import java.util.Arrays;

public class ArrayTools {
    
    //Sum
    public static int sum(int[] arr){
        int sum = 0;
        for (int a : arr){
            sum+=a;
        }
        return sum;
    }
    public static float sum(float[] arr){
        float sum = 0;
        for (float a : arr){
            sum+=a;
        }
        return sum;
    }
    
    //MultiplyArray
    public static int multiply(int[] arr){
        int sum = 0;
        for (int a : arr){
            sum*=a;
        }
        return sum;
    }  
    public static float multiply(float[] arr){
        float sum = 0;
        for (float a : arr){
            sum*=a;
        }
        return sum;
    }
    
    //maxValue
    public static int maxValue(int[] arr){
        int max = 0;
        for(int a : arr){
            if(a>max){
                max=a;
            }
        }
        return max;
    }
    public static float maxValue(float[] arr){
        float max = 0;
        for(float a : arr){
            if(a>max){
                max=a;
            }
        }
        return max;
    }
    
    //minValue
    public static int minValue(int[] arr){
        if(arr.length == 0) return 0;
        
        int min = arr[0];
        for(int a : arr){
            if(a<min){
                min=a;
            }
        }
        return min;
    }
    public static float minValue(float[] arr){
        if(arr.length == 0) return 0;
        
        float min = arr[0];
        for(float a : arr){
            if(a<min){
                min=a;
            }
        }
        return min;
    }
    
    /**
     * Reverse with changing value of referenced array
     * @param arr 
     */
    public static void reverse(int[] arr){
        int size = arr.length;
        int temp;
        for (int i = 0; i < size/2; i++) {
            temp = arr[size-1-i];
            arr[size-1-i] = arr[i];
            arr[i] = temp;
        }
    }
    
    /**
     * Reverse with new array
     * @param arr
     * @return 
     */
    public static int[] reverse2(int[] arr){
        int size = arr.length;
        int[] reversed = new int[size];
        for (int i = 0; i < size; i++) {
            reversed[i] = arr[size-1-i];
        }
        return reversed;
    }
    
    /**
     * Reverse with copy of array + usage of first reverse
     * @param arr
     * @return 
     */
    public static int[] reverse3(int[] arr){
        int size = arr.length;
        int[] reversed = Arrays.copyOf(arr, size);
        reverse(reversed);
        return reversed;
    }
    
    /**
     * Prints array and splits lines based on splitBy parameter
     * @param arr
     * @param splitBy 
     */
    public static void print(int[] arr,int splitBy){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
            if((i+1)%splitBy==0){
                System.out.println("");
            }
        }
        System.out.println("");
    }
}