/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_ordenamiento;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Random;

/**
 *
 * @author USUARIO
 */
public class Sorts {

    public void bubbleSort (int[] unsorted){
        boolean swap = false;
        int temp;
        do{
            swap = false;
            for(int i = 0; i < unsorted.length - 1; i++){
                if(unsorted[i] > unsorted[i+1]){
                 temp = unsorted[i];
                 unsorted[i] = unsorted[i+1];
                 unsorted[i+1] = temp;
                 swap = true;
                }
            }
        }
        while(swap);
    }
    
    public void insertionSort (int[] unsorted){
        int temp, indexHole;
        for(int i = 1; i < unsorted.length; i++){
            temp = unsorted[i];
            indexHole = i;
            while(indexHole > 0 && unsorted[indexHole - 1] > temp){
                unsorted[indexHole] = unsorted [indexHole - 1];
                indexHole -= 1;
            }
            unsorted [indexHole] = temp;
        }
    }
    
    public int[] mergeSort(int[] unsorted){
        int size; 
        if(unsorted.length > 1){
            size = unsorted.length / 2;
            int[] right_array = new int[unsorted.length - size];
            int[] left_array = new int[size];
            
            for(int i = 0; i < size; i++){
                left_array[i] = unsorted[i];
            }
            for (int i = size; i < unsorted.length; i++) {
                right_array[i-size] = unsorted[i];                
            }
            
            left_array = mergeSort(left_array);
            right_array = mergeSort(right_array);
            
            return merge(left_array, right_array);
        }
        return unsorted;
    }
    
    public int[] merge(int[] a,int[] b){
        int l = a.length + b.length;
        int [] c = new int[l];
        int index_a = 0,index_b = 0,index_c =0;
        
        while(index_a < a.length && index_b < b.length){
            if(a[index_a] < b[index_b]){
                c[index_c] = a[index_a];
                index_a++;               
            }
            else{
                c[index_c] = b[index_b];
                index_b++;
            }
            index_c++;
        }
        while(index_a < a.length){
            c[index_c] = a[index_a];
            index_a++;
            index_c++;
        }
        while(index_b < b.length){
            c[index_c] = b[index_b];
            index_b++;
            index_c++;
        }
        return c;
    }
    
    public void countingSort(int[] unsorted){
        int max = Integer.MIN_VALUE;
        int index = 0;
        for(int i = 0;i < unsorted.length;i++){
            if(unsorted[i] > max){
                max = unsorted[i];
            }
        }
        int[] temp = new int[max + 1];
        for(int i = 0; i < unsorted.length; i++){
            temp[unsorted[i]]++;
        }
        for(int i = 0; i < temp.length; i++){
            for(int j = 0; j < temp[i]; j++){
                unsorted[index] = i;
                index += 1;
            }
        }
    }
    
    public int busquedaBinaria(int[]unsorted, int x, int lowerBound, int upperBound){
        int middlePoint = (upperBound + lowerBound) / 2;
        if(lowerBound == upperBound){
            if( x == unsorted[middlePoint]){
                return middlePoint;
            }
            else {
                return -1;
            }
        }
        else{
            if(x == unsorted[middlePoint]){
                return middlePoint;
            }
            else{
                if(x < unsorted[middlePoint]){
                    return busquedaBinaria(unsorted, x, lowerBound, middlePoint);
                }
                else{
                    return busquedaBinaria(unsorted, x, middlePoint + 1, upperBound);
                }
            }
        }
    }
    
    public int[] bigArray(int length){
        Random rd = new Random();
        int [] temp = new int[length];
        for(int i = 0; i < length; i++){
            temp[i] = rd.nextInt(1000000);
        }
        return temp;
    }
    
    public void printArraY (int[] array) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < array.length; i++){
            bw.write(array[i] + " ");
        }
        bw.write("\n");
        bw.flush();
    }
    public static void main(String[] args) throws IOException {
    Sorts s = new Sorts();
//    int[] a = s.bigArray(10000000);
//    int[] b = a.clone();
//    int[] c = a.clone();
//    int[] d = a.clone();
    int[] e = {0,1,2,3,4,5};
//    s.printArraY(a);
//    s.bubbleSort(a);
//    s.printArraY(a);
//    s.insertionSort(b);
//    s.printArraY(b);    
//    s.printArraY(s.mergeSort(c));
//    s.countingSort(d);
//    s.printArraY(d);
    System.out.println(s.busquedaBinaria(e,-2,0,e.length-1));
        
    }    
}
