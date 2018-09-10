/*
* Adam Hoffman, ID: 2000970666, CS 326-1002, assignment #1 quicksort in java.
* Compilation: javac QuickSort.java
*
* The purpose of this program is to write a program in java that is able to
* quicksort a list of user specified size array of integers and print the time
* it take to complete the sorting of the array.
* Utilizes Lomuto partition scheme.
*
* input: in commandline argument after QuickSort should be a user selected int
* that idicated size of array
* output: Quicksort took .925 seconds to complete
*/
public class QuickSort
{
/*
*  public void: main
*  Must accept one argument which will indicate how many numbers to sort.
*  Allocate an array filled with randomly generate numbers.
*  Use time functions to find the length of Sort to complete in millisecond.
*  Call quicksort.
*  print time it took to complete sorting process.
*  i.e. Quicksort took 0.925ms to complete.
*/
    public static void main(String [] args)
    {
        long start, MS, NS; //used for keeping time of quicksort
        int arrSize = Integer.parseInt(args[0]); //changing string to type int for array size
        int [] randArr = new int[arrSize];  //creating array of type int

        fillArray(arrSize, randArr); //fills array with random numebers;

        start = System.nanoTime();
        quicksort(0, arrSize-1, randArr);
        NS = System.nanoTime() - start;
        print(arrSize, randArr); //prints array used for error checking sort algorithm
        //must uncomment the print function as well

        MS = NS / 1000000;
        NS = NS % 1000000;
        NS = NS / 1000;
        System.out.println("Quicksort took " + MS + "." + NS +  "ms to complete");

    } //end of main
/*
*  Public void: fillArray
*  Populates the array with random numbers between 0 - 1000;
*  to change the number range, Math.Random returns a double between
*  doubles 0.0 and 1.0 and then multiply it by larger than 1000 to
*  generate larger numbers.
*/
    public static void fillArray(int size, int [] randArr)
    {
        for(int i = 0; i < size; i++)
        {
            randArr[i] = (int) (Math.random() * 1000000000);
        }
        return;
    }//end of fillArray

/*
*  Public void: quicksort
*  Used to recurisvely call quicksort until array low index is greater than
*  high index, then stops. This indicated end of recursion.
*  Utilizes Lomuto partitioning scheme.
*/
    public static void quicksort(int low, int high, int [] randArr)
    {

        if (low < high)
        {
            int pivot = partition(low, high, randArr); //returns location of most recent pivot
            quicksort(low, pivot-1, randArr);
            quicksort(pivot+1, high, randArr);
        }
        return;
    }

/*public int: parition
* finds number less then pivot and swaps values, making sure all values less
* then pivot to the left of the pivot position in the array.
* low and high are the left of right sides of the partition to be sorted,
* randArr = random number array being sorted
* returns posotion of next wall to be partitioned and sorted.
*/
    public static int partition(int low, int high, int [] randArr)
    {
      int pivot = randArr[high];
      int i = low;
      for(int j = low; j < high; j++)
      {
          if(randArr[j] < pivot){
              swap(i, j, randArr);
              i++;
          }
      }
      swap(i, high, randArr);
      return i;
    }


/*
* public void: swap
* swap allows you to swap positions of 2 integers in an array.
* int a, and b hold the positions of the 2 numbers in the array to be swapped
*/
    private static void swap(int A,int B, int [] randArr)
    {
        int hold = randArr[B];
        randArr[B] = randArr[A];
        randArr[A] = hold;
        return;
    }

/*
* Public void: print
* Prints array to ensure sorted of arrays less than size 100.
* added for error checking.
*

    public static void print(int arrSize, int [] randArr){
      //will only print arrays of size less than 100
      if(arrSize <= 100)
      {
          for (int i = 0; i < arrSize; i++)
          {
             //printing sorted array with width of 4 and boarder
              System.out.format("|%-4d| ", randArr[i]);
              //prints line feed every 10th number
              if((i % 10) == 9 && i != 0)
              {
                  System.out.println();
              }
          }

      }
      else  //just double checking at least the lower end is sorted for very large numbers
      {
            for (int i = 0; i < 100; i++)
            {
                //printing sorted array with width of 4 and boarder
                System.out.format("|%-4d| ", randArr[i]);
                //prints line feed every 10th number
                if((i % 10) == 9 && i != 0)
                {
                    System.out.println();
                }
            }
            System.out.println();
      }


    }//end of print
*/ //uncomment here for print function and replace after print comment
} //end of QuickSort class
