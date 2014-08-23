/*
 * $filename: Main.java,v $
 * $Date: 2014-4-12  $
 * Copyright (C) ZhengHaibo, Inc. All rights reserved.
 * This software is Made by Zhenghaibo.
 */
package edu.njupt.zhb;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {3,2,1};
        int inversionCount = count(array,0,array.length-1); 
        System.out.println(inversionCount);
	}
	public static int count(int[] array, int p, int r) {  
        int inversionCount = 0;  
        if (p<r){
            int mid = (p + r) / 2;  
            inversionCount += count(array, p, mid);  
            inversionCount += count(array, mid+1, r);  
            inversionCount += mergeInversion(array, p, mid, r);  
        }  
        return inversionCount;  
    }  
  
    private static int mergeInversion(int[] array, int p, int mid, int r) {  
        int inversionCount = 0;  
        int[] temp = new int[r-p+1];  
        if(array.length < r)  
            return inversionCount;  
        int left = p;  
        int right = mid + 1;  
        int storeIndex = 0;  
        while(left <= mid && right <= r)  
        {  
            if(array[left] > array[right])  
            {  
                inversionCount += mid-left+1; //当前right存在逆序数，数目等于mid-left+1  
                temp[storeIndex] = array[right];  
                right++;  
            }  
            else  
            {  
                temp[storeIndex] = array[left];  
                left++;  
            }  
            storeIndex++;  
        }  
        if(left <= mid)  
        {  
            for(int i = left; i <= mid; i++)  
            {  
                temp[storeIndex] = array[i];  
                storeIndex++;  
            }  
        }  
        if(right <= r)  
        {  
            for(int i = right; i <= r; i++)  
            {  
                temp[storeIndex] = array[i];  
                storeIndex++;  
            }  
        }  
          
        for(int i = p; i <= r; i++)  
        {  
            array[i] = temp[i-p];  
              
        }  
        return inversionCount;  
    }
	

}
