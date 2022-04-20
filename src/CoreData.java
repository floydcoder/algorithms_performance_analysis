/*
 * Marco Stevanella - 101307949
 * COMP 2080 - ASGMT_1 (10%)
 * Prof. Andrew Rudder
 */
import java.util.Random;

public class CoreData {

    private int [] coreData;
    private int numElements;
    private int maxElements;
    private String sortingAlgoType;

    public CoreData(){
        maxElements = 1000000;
        numElements = 0;
        coreData = new int[maxElements];
    }
    public CoreData(int max){
        maxElements = max;
        numElements = 0;
        coreData = new int[max];
    }

    public CoreData(CoreData coreData, String algo, int [] numbers){
        this.maxElements= coreData.maxElements;
        this.numElements= coreData.numElements;
        this.coreData = numbers;
        this.sortingAlgoType = algo;
    }

    // GETTERS
    public int getMaxElements() {
        return maxElements;
    }

    public int getNumElements() {
        return numElements;
    }

    public int[] getCoreData() {
        return coreData;
    }

    public String getSortingAlgoType(){
        return sortingAlgoType;
    }
    // Sorting Algorithms
        // Selection Sort

    public void selectionSortDesc(){
        for(int start= 0 ; start < numElements ; start ++){
            // find the index of the biggest id in each iteration of the loop
            int locBiggest = start;
            // loop array again to compare Index of Biggest to the rest of the elements in array
            for(int candidateBigger = start +1 ; candidateBigger < numElements ; candidateBigger++){
                if(coreData[locBiggest] < coreData[candidateBigger]){
                    locBiggest = candidateBigger;
                }
            }
            // now that we found the biggest element of the iteration, SWAP THE VALUES
            int temp = coreData[start];
            coreData[start] = coreData[locBiggest];
            coreData[locBiggest] = start;
        }
    }

        // Insertion Sort
    public void insertionSortDesc(){
        for(int start= 1; start < numElements ; start++){
            // store start element in a temp var for further comparison
            int temp = coreData[start];
            // need to set the current pos before start
            int currentPos = start -1;
            // Keep the sorting in the boundary of the array, and check if the element is bigger.
            while(currentPos >= 0 && coreData[currentPos] < temp){
                // shift the item up to make space, and swap.
                coreData[currentPos +1] = coreData[currentPos];
                // decrement the current pos. Mind that if currPos is at index 0 it will go to -1
                currentPos --;
            }
            // item smaller? keep it there.
            coreData[currentPos +1] = temp;
        }
    }
        // Merge Sort
    private void merge (int [] arr, int left, int mid, int right){
        // new array with copied left values
        int [] leftArray = new int[mid - left+1];
        // new array with copied right values
        int [] rightArray = new int[right - mid];

        //Copy left elements into new array 'leftArray'
        for(int x= 0 ; x < leftArray.length ; x++){
            leftArray[x] = arr[left +x];
        }
        //Copy right elements into new array 'rightArray'
        for(int x= 0 ; x < rightArray.length ; x++){
            rightArray[x] = arr[mid+1 +x];
        }

        // Merge technically starts from here
        int pointerA = 0;
        int pointerB = 0;
        int pointerC =left;

        while(pointerA < leftArray.length && pointerB < rightArray.length){
            if(leftArray[pointerA] > rightArray[pointerB]){
                arr[pointerC] = leftArray[pointerA];
                pointerA++;
            }
            else{
                arr[pointerC] = rightArray[pointerB];
                pointerB++;
            }
            pointerC++;
        }
        // just copy the rest of the element in case there is left over
        while(pointerA < leftArray.length){
            arr[pointerC] = leftArray[pointerA];
            pointerA++;
            pointerC++;
        }
        while(pointerB < rightArray.length){
            arr[pointerC] = rightArray[pointerB];
            pointerB++;
            pointerC++;
        }

    }

    private void mergeSortRecursive(int [] arr, int left, int right){
        if(left < right){
            int mid = (left + right) /2;
            // split on left
            mergeSortRecursive(arr, left, mid);
            // split on right
            mergeSortRecursive(arr, mid+1, right);
            // now merge left and right together
            merge(arr, left, mid, right);
        }
    }

    public void mergeSort(){
        mergeSortRecursive(coreData, 0, numElements-1);
    }

        // Quick Sort
    public void quickSortDesc(){
        // here the call the recursive function
        quickSortRecursive(0, numElements -1);
    }
    public void quickSortRecursive(int low, int high){
        if(low < high){
            int pivot = partition(low,high);
            quickSortRecursive(low, pivot - 1);
            quickSortRecursive(pivot + 1, high);
        }
    }

    private int partition (int low, int high){
        int pivot = coreData[high];
        int marker = low -1, temp;
        for (int pres = low; pres < high ; pres++){
            if(coreData[pres] > pivot){
                marker++;
                temp = coreData[marker];
                coreData[marker] = coreData[pres];
                coreData[pres] = temp;
            }
        }
        temp = coreData[marker +1 ];
        coreData[marker+1] = coreData[high];
        coreData[high] = temp;
        return marker+1;
    }
    // Searching Algorithms

        // Binary Search
    public int binarySearch(int num){
        int low = 0;
        int hi = getNumElements() -1;
        while(low <= hi){
            int mid = (low +hi) / 2;
            if(coreData[mid] == num)
                return mid;
            else if (coreData[mid] > num)
                hi = mid -1;
            else
                low = mid +1;
        }
        return -1;
    }

    // Linear Search
    public int linearSearch(int num){
        for (int i = 0 ; i < getNumElements() ; i++){
            if(coreData[i] == num)
                return i;
        }
        return -1;
    }

    /**
     * HELPER FUNCTIONS
     */

    public void listItems(){
        for (int i = 0 ; i < numElements ; i ++){
            System.out.print(coreData[i] + " - ");
        }
        System.out.println("");
    }

    public void listItems(int amt){
        if(amt <= numElements){
            for (int i = 0 ; i < numElements ; i ++){
                System.out.print(coreData[i] + " - ");
            }
            System.out.println("");
        }
    }

    public void fillArray(){
        Random rand = new Random(2000000);
        for (int index = 0 ; index < maxElements ; index ++){
            int number = rand.nextInt(2000000);
            coreData [index] = number;
            numElements++;
        }
    }

    public CoreData trimBySize(CoreData array, int size){
        CoreData trimmedArray = new CoreData(size);
        for(int i = 0 ; i < size ; i++ ){
            trimmedArray.coreData[i] = array.coreData[i];
            trimmedArray.numElements++;
        }
        return trimmedArray;
    }

}
