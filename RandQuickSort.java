package searching;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RandQuickSort 
{
   
    public static List<Integer> array = new ArrayList<Integer>();
 
    public static void QuickSort(int left, int right) 
    {
        if (right - left <= 0)
            return;
        else 
        {
            Random rand = new Random();
            int pivotIndex = left + rand.nextInt(right - left + 1);
            swap(pivotIndex, right);
 
            int pivot = array.get(right);
            int part = partition(left, right, pivot);
            QuickSort(left, part - 1);
            QuickSort(part + 1, right);
        }
    }
 
    public static int partition(int left, int right, long pivot) 
    {
        int leftPtr = left - 1;
        int rightPtr = right;
        while (true) 
        {
            while (array.get(++leftPtr) < pivot)
                ;
            while (rightPtr > 0 && array.get(--rightPtr) > pivot)
                ;
 
            if (leftPtr >= rightPtr)
                break;
            else
                swap(leftPtr, rightPtr);
        }
        swap(leftPtr, right);
        return leftPtr;
    }
 
    public static void swap(int f, int r) 
    {
        int temp = array.get(f);
        array.set(f, array.get(r));
        array.set(r, temp);
    }
 

 
    public static void main(String args[]) 
    {
        System.out.println("Enter number of elements");
        Scanner sc = new Scanner(System.in);
        int no = sc.nextInt();
        System.out.println("Enter integer elements");
        for (int i = 0; i < no; i++)
            array.add(sc.nextInt());
 
        System.out.println("\nOriginal Sequence: ");
        System.out.println(array);
        System.out.println("\nSorted Sequence: ");
        QuickSort(0, no - 1);
        System.out.println(array);
    }
}