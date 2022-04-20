/*
 * Marco Stevanella - 101307949
 * COMP 2080 - ASGMT_1 (10%)
 * Prof. Andrew Rudder
 */

import java.util.Scanner;
public class Tester {

    // Arrays Sizes
    static final int fifty= 50;
    static final int oneThousand= 1000;
    static final int tenThousand= 10000;
    static final int oneHundredThousand= 100000;
    static final int oneMillion= 1000000;

    // Number To Search
    static final int numberToSearch = 2500000;
    static int indexOfElement;

    /**
     * it creates an array containing CoreData objects by the size of 50, 1000, 10000, 100000 and 1000000.
     * @param coreData is the original CoreData obj to be trimmed.
     * @return an array of CoreData objects.
     */
    public static CoreData[] arraySizeBuilder(CoreData coreData) {
        CoreData trimmedCoreData_50 = coreData.trimBySize(coreData, fifty);
        CoreData trimmedCoreData_1000 = coreData.trimBySize(coreData, oneThousand);
        CoreData trimmedCoreData_10000 = coreData.trimBySize(coreData, tenThousand);
        CoreData trimmedCoreData_100000 = coreData.trimBySize(coreData, oneHundredThousand);
        CoreData trimmedCoreData_1000000 = coreData.trimBySize(coreData, oneMillion);
        return new CoreData[]{trimmedCoreData_50, trimmedCoreData_1000, trimmedCoreData_10000, trimmedCoreData_100000, trimmedCoreData_1000000};
    }

    /**
     * Creates a 2 Dimensional Array containing 4 copies of each size to be tested.
     * 4 of size 50, 4 of size 1,000, 4 of size 10,000, 4 of size 100,000, 4 of size 1,000,000
     * @param coreData is an array containing the CoreData Objects to be copied.
     * @return a 2 Dimensional Array that have 4 CoreData Objects, for each size, that will be tested by each sorting algo.
     */
    public static CoreData [] [] arrayCopierBySize(CoreData [] coreData){
        String [] sortAlsoType = new String[] {"SelectSort","InsertionSort","MergeSort","QuickSort"};
        CoreData[][] testCoreData = new CoreData[coreData.length][4];
        for (int i = 0 ; i < coreData.length ; i++){
            for (int j = 0 ; j < 4  ; j++){
                if(coreData[i] != null){
                    int size = coreData[i].getNumElements();
                    switch (size){
                        case fifty:
                            CoreData arraySize_50 = coreData[i];
                            int [] numbers_50 = new int[arraySize_50.getMaxElements()];
                            System.arraycopy(coreData[i].getCoreData(),0,numbers_50,0,numbers_50.length);
                            testCoreData[i][j] = new CoreData(arraySize_50, sortAlsoType[j],numbers_50);
                            break;
                        case oneThousand:
                            CoreData arraySize_1000 = coreData[i];
                            int [] numbers_1000 = new int[arraySize_1000.getMaxElements()];
                            System.arraycopy(coreData[i].getCoreData(),0,numbers_1000,0,numbers_1000.length);
                            testCoreData[i][j] = new CoreData(arraySize_1000, sortAlsoType[j], numbers_1000);
                            break;
                        case tenThousand:
                            CoreData arraySize_10000 = coreData[i];
                            int [] numbers_10000 = new int[arraySize_10000.getMaxElements()];
                            System.arraycopy(coreData[i].getCoreData(),0,numbers_10000,0,numbers_10000.length);
                            testCoreData[i][j] = new CoreData(arraySize_10000, sortAlsoType[j], numbers_10000);
                            break;
                        case oneHundredThousand:
                            CoreData arraySize_100000 = coreData[i];
                            int [] numbers_100000 = new int[arraySize_100000.getMaxElements()];
                            System.arraycopy(coreData[i].getCoreData(),0,numbers_100000,0,numbers_100000.length);
                            testCoreData[i][j] = new CoreData(arraySize_100000, sortAlsoType[j], numbers_100000);
                            break;
                        case oneMillion:
                            CoreData arraySize_1000000 = coreData[i];
                            int [] numbers_1000000 = new int[arraySize_1000000.getMaxElements()];
                            System.arraycopy(coreData[i].getCoreData(),0,numbers_1000000,0,numbers_1000000.length);
                            testCoreData[i][j] = new CoreData(arraySize_1000000, sortAlsoType[j], numbers_1000000);
                            break;
                        default:
                            System.out.println("No arrays found");
                    }
                }
            }
        }
        return testCoreData;
    }

    /**
     * It Tests the CoreData by timing the execution of each Algorithm, based to the chosen size .
     * @param testCoreData is a second dimensional array that contains the CoreData Objects to test.
     */
    public static void testCoreData (CoreData[][] testCoreData) {
        int size = askSizeArrayToTest(fifty, oneThousand, tenThousand, oneHundredThousand, oneMillion);
        long start,
                end,
                timeTaken;
        System.out.println("-=-=-=-=-=-=-=-=-=- TESTING SIZE " + size + "-=-=-=-=-=-=-=-=-=-");
        for (int x = 0; x < testCoreData.length; x++) {
            for(int j= 0 ; j < testCoreData[x].length ; j++){
                if (testCoreData[x][j].getNumElements() == size) {
                    if(testCoreData[x][j].getSortingAlgoType().equals("SelectSort")){
                        start = System.nanoTime();
                        testCoreData[x][j].selectionSortDesc();
                        end = System.nanoTime();
                        timeTaken = end - start;
                        if (size == oneMillion){
                            System.out.println("Selection Sort: " + timeTaken / 1000000 + " millisecond");
                        }
                        else {
                            System.out.println("Selection Sort: " + timeTaken + " nanoseconds");
                        }
                    }
                    if(testCoreData[x][j].getSortingAlgoType().equals("InsertionSort")){
                        start = System.nanoTime();
                        testCoreData[x][j].insertionSortDesc();
                        end = System.nanoTime();
                        timeTaken = end - start;
                        if (size == oneMillion){
                            System.out.println("Insertion Sort: " + timeTaken / 1000000 + " millisecond");
                        }
                        else {
                            System.out.println("Insertion Sort: " + timeTaken + " nanoseconds");
                        }
                    }
                    if(testCoreData[x][j].getSortingAlgoType().equals("MergeSort")){
                        start = System.nanoTime();
                        testCoreData[x][j].mergeSort();
                        end = System.nanoTime();
                        timeTaken = end - start;
                        if (size == oneMillion){
                            System.out.println("Merge Sort: " + timeTaken / 1000000 + " millisecond");
                        }
                        else {
                            System.out.println("Merge Sort: " + timeTaken + " nanoseconds");
                        }
                    }
                    if (testCoreData[x][j].getSortingAlgoType().equals("QuickSort")){
                        start = System.nanoTime();
                        testCoreData[x][j].quickSortDesc();
                        end = System.nanoTime();
                        timeTaken = end - start;
                        if (size == oneMillion){
                            System.out.println("Quick Sort: " + timeTaken / 1000000 + " millisecond");
                        }
                        else {
                            System.out.println("Quick Sort: " + timeTaken + " nanoseconds");
                        }
                        // Execute Binary Search
                        start = System.nanoTime();
                        indexOfElement = testCoreData[x][j].binarySearch(numberToSearch);
                        end = System.nanoTime();
                        timeTaken = end - start;
                        System.out.println("In the worst case, Binary Search takes " + timeTaken + " nanoseconds to find the number " + numberToSearch + " at index "+ indexOfElement);
                        // Execute Linear Search
                        start = System.nanoTime();
                        indexOfElement = testCoreData[x][j].linearSearch(numberToSearch);
                        end = System.nanoTime();
                        timeTaken = end - start;
                        System.out.println("In the worst case, Linear Search takes " + timeTaken + " nanoseconds to find the number " + numberToSearch + " at index "+ indexOfElement);
                    }
                }
            }
        }
    }

    /**
     * Displays a Menu to the user that allow to select the size of the CoreData to be tested.
     * @param fifty CoreData of 50 integer elements.
     * @param oneThousand CoreData of 1000 integer elements.
     * @param tenThousand CoreData of 10000 integer elements.
     * @param oneHundredThousand CoreData of 100000 integer elements.
     * @param oneMillion CoreData of 1000000 integer elements.
     * @return an integer representing the size.
     */
    public static int askSizeArrayToTest(int fifty, int oneThousand, int tenThousand, int oneHundredThousand, int oneMillion){
        Scanner input = new Scanner(System.in);
        System.out.println("Please Select the size of the array you want to test with Sorting Algorithms: Select a number 1 to 5");
        System.out.println("1- Size 50");
        System.out.println("2- Size 1,000");
        System.out.println("3- Size 10,000");
        System.out.println("4- Size 100,000");
        System.out.println("5- Size 1,000,000");
        System.out.println(" ");
        System.out.println("SIZE? ");

        boolean isUserSelecting = true;
        int size = 0;
        while (isUserSelecting){
            String selection = input.next();
            switch (selection){
                case "1":
                    size = fifty;
                    isUserSelecting = false;
                    break;
                case "2":
                    size = oneThousand;
                    isUserSelecting = false;
                    break;
                case "3":
                    size = tenThousand;
                    isUserSelecting = false;
                    break;
                case "4":
                    size = oneHundredThousand;
                    isUserSelecting = false;
                    break;
                case"5":
                    size = oneMillion;
                    isUserSelecting = false;
                    break;
                default:
                    System.out.println("I think you made a mistake, select a number from 1 to 5");
                    System.out.print("SIZE? ");
            }
        }
        return size;
    }

}

