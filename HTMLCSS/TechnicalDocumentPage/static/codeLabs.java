import java.util.*;
//import static org.junit.Assert.assertEquals;  
//import org.junit.Test; 

public class HelloWorld{

    public static void main(String []args){
        
        int[] data = {1001, 501, 80, 754, 40 , 2001, 40, 20, 67, 503, 999, 80};
        System.out.println("Technical Assignment: Size=" + data.length);
        PrintArray(data);
        Search search = new Search(data);
        
        System.out.println("[search.Index for 2001 = " + search.IndexFor(2001));
        System.out.println("[search.Index for 67 = " + search.IndexFor(67));
        System.out.println("[search.Max value = " + search.FindMax());
        System.out.println("[search.IndeOfMax value = " + search.IndexOfMax());
        System.out.println("[search.FindMin value = " + search.FindMin());
        
    }
    
    static void PrintArray(int[] array){
        for (int i=0; i < array.length; i++) {
           System.out.println("[" + i + "]=" + array[i]);
       }
        
    }
}

class Search {
   private int[] Data;
   
   public Search(int[] data) {
       this.Data = data;
   }
   
    public List<Integer> IndexFor(int value) {
       List values = new ArrayList<Integer>();
       for(int i = 0 ; i < Data.length; i++){
           if(Data[i] == value)
               values.add(i);
       }
       return values;
   }
   
   // Returns the maximum value
   public int FindMax() {
       int max = Integer.MIN_VALUE;
       if(Data.length != 0){
           for(int i = 0; i < Data.length; i++){
               if(Data[i] > max)
               max = Data[i];
           }
           
       }
       return max;
   }
   
   // Returns an arry of indexes of the maximum values
   public int IndexOfMax() {
       int max = this.FindMax();
       List<Integer> maxValues  = IndexFor(max);
       return maxValues.get(0);
   }
   
   // Returns the index of the minimum value
   public int FindMin() {
       int min = Integer.MAX_VALUE;
       if(Data.length != 0){
           for(int i =0; i < Data.length ; i++){
               if(Data[i] < min)
               min = Data[i];
           }
       }
       return min;
   }
   
   // Returns the index of the minimum value
   public int IndexOfMin() {
        int min = this.FindMin();
       List<Integer> minIndexes  = IndexFor(min);
       return minIndexes.get(0);
   }
   
   // Indicate if duplicates exist  for the given value 
   public Boolean HaveDuplicate(int value){
       if(IndexFor(value).size() > 1){
           return true;
       }
       return false;
       
   }
   
   // Indicate if the data array contains duplicate value
   public Boolean HaveDuplicates(){
       int data[] = Arrays.copyOf(Data,Data.length);
       Arrays.sort(data);
       if(data.length > 1)
       for(int i = 0; i < data.length-1; i++){
           if(data[i] == data[i+1])
           return true;
       }
       return false;
   }
   
   // Return list of values that have one or more occurrences in the data
   public ArrayList<Integer> Duplicates() {
   int data[] = Arrays.copyOf(Data,Data.length);
   Arrays.sort(data);
   
   ArrayList<Integer> listOfValues = new ArrayList<Integer>();
   
   for(int i = 1 ; i < data.length; i++){
       if(data[i] == data[i-1])
       listOfValues.add(data[i]);
   }
   
    return listOfValues;
   }
}


/*
class SearchTestCase{
   int emptyData[] = new int[0];
   int orderedData[] = {1,2,3,4,5,6,7,8,9};
   int unorderedData[] = {5,6,1,2,3,7,8,9,0};
   int orderedDataWithSingleDuplicate [] = {1,2,2,3,4,5,6,7,8};
   int orderedDataWithMultipleDuplicates [] = {1,2,2,3,3,3,4,5,6,7,8};
   int unOrderedDataWithSingleDuplicate [] = {1,2,3,4,5,8,2,6,7};
   int unOrderedDataWithMultileDuplicates [] = {1,2,2,3,3,4,6,3,7,5,8,4};
   
   @Test
   public void testFindMax(){
       Search search = new Search(emptyData);
       assertEquals("Finding max of an empty dataset",null,search.FindMax());
       search = new Search(orderedData);
       assertEquals("Finding max of an ordered dataset",9,search.FindMax());
       search = new Search(unorderedData); 
       assertEquals("Finding max of an unordered dataset",9,search.FindMax());
       search = new Search(orderedDataWithSingleDuplicate);
       assertEquals("Finding max of an orderedDataWithSingleDuplicate dataset",9,search.FindMax());
       search = new Search(orderedDataWithMultipleDuplicates);
       assertEquals("Finding max of an orderedDataWithMultipleDuplicates dataset",9,search.FindMax());
       search = new Search(unOrderedDataWithSingleDuplicate);
       assertEquals("Finding max of an uOrderedDataWithSingleDuplicate dataset",9,search.FindMax());
       search = new Search(unOrderedDataWithMultileDuplicates);
       assertEquals("Finding max of an orderedDataWithMultipleDuplicates dataset",9,search.FindMax());
       
   }
   @Test
   public void testFindMin(){
       Search search = new Search(emptyData);
       assertEquals("Finding min of an empty dataset",null,search.FindMin());
       search = new Search(orderedData);
       assertEquals("Finding min of an ordered dataset",1,search.FindMin());
       search = new Search(unorderedData); 
       assertEquals("Finding min of an unordered dataset",1,search.FindMin());
       search = new Search(orderedDataWithSingleDuplicate);
       assertEquals("Finding min of an orderedDataWithSingleDuplicate dataset",1,search.FindMin());
       search = new Search(orderedDataWithMultipleDuplicates);
       assertEquals("Finding min of an orderedDataWithMultipleDuplicates dataset",1,search.FindMin());
       search = new Search(unOrderedDataWithSingleDuplicate);
       assertEquals("Finding min of an uOrderedDataWithSingleDuplicate dataset",1,search.FindMin());
       search = new Search(unOrderedDataWithMultileDuplicates);
       assertEquals("Finding min of an orderedDataWithMultipleDuplicates dataset",1,search.FindMin());
 
   }
   @Test
   public void testIndexOfMax(){
       Search search = new Search(emptyData);
       assertEquals("Finding index of max on a empty dataset",null,search.IndexOfMax());
       search = new Search(orderedData);
       assertEquals("Finding index of max on a ordered dataset",8,search.IndexOfMax());
       search = new Search(unorderedData); 
       assertEquals("Finding index of max on a unordered dataset",7,search.IndexOfMax());
       search = new Search(orderedDataWithSingleDuplicate);
       assertEquals("Finding index of max on a orderedDataWithSingleDuplicate dataset",8,search.IndexOfMax());
       search = new Search(orderedDataWithMultipleDuplicates);
       assertEquals("Finding index of max on a orderedDataWithMultipleDuplicates dataset",10,search.IndexOfMax());
       search = new Search(unOrderedDataWithSingleDuplicate);
       assertEquals("Finding index of max on a uOrderedDataWithSingleDuplicate dataset",5,search.IndexOfMax());
       search = new Search(unOrderedDataWithMultileDuplicates);
       assertEquals("Finding index of max on a  orderedDataWithMultipleDuplicates dataset",9,search.IndexOfMax());


   }
   @Test
   public void testIndexOfMin(){
       Search search = new Search(emptyData);
       assertEquals("Finding index of min on a empty dataset",null,search.IndexOfMin());
       search = new Search(orderedData);
       assertEquals("Finding index of min on a ordered dataset",0,search.IndexOfMin());
       search = new Search(unorderedData); 
       assertEquals("Finding index of min on a unordered dataset",0,search.IndexOfMin());
       search = new Search(orderedDataWithSingleDuplicate);
       assertEquals("Finding index of min on a orderedDataWithSingleDuplicate dataset",0,search.IndexOfMin());
       search = new Search(orderedDataWithMultipleDuplicates);
       assertEquals("Finding index of min on a orderedDataWithMultipleDuplicates dataset",0,search.IndexOfMin());
       search = new Search(unOrderedDataWithSingleDuplicate);
       assertEquals("Finding index of min on a uOrderedDataWithSingleDuplicate dataset",0,search.IndexOfMin());
       search = new Search(unOrderedDataWithMultileDuplicates);
       assertEquals("Finding index of min on a  orderedDataWithMultipleDuplicates dataset",0,search.IndexOfMin());

   }
   @Test
   public void testHaveDuplicate(){
      Search search = new Search(emptyData);
       assertEquals("Test for duplicates on a empty dataset",false,search.HaveDuplicates());
       search = new Search(orderedData);
       assertEquals("Test for duplicates on ordered dataset",false,search.HaveDuplicates());
       search = new Search(unorderedData); 
       assertEquals("Test for duplicates on a unordered dataset",true,search.HaveDuplicates());
       search = new Search(orderedDataWithSingleDuplicate);
       assertEquals("Test for duplicates on a orderedDataWithSingleDuplicate dataset",true,search.HaveDuplicates());
       search = new Search(orderedDataWithMultipleDuplicates);
       assertEquals("Test for duplicates on a orderedDataWithMultipleDuplicates dataset",true,search.HaveDuplicates());
       search = new Search(unOrderedDataWithSingleDuplicate);
       assertEquals("Test for duplicates on a uOrderedDataWithSingleDuplicate dataset",true,search.HaveDuplicates());
       search = new Search(unOrderedDataWithMultileDuplicates);
       assertEquals("Test for duplicates on a  orderedDataWithMultipleDuplicates dataset",true,search.HaveDuplicates());

   }
   
}
*/