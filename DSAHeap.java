public class DSAHeap
{
    // Class fields
    private DSAHeapEntry[] heapArray;
    private int count = 0;
    private int currentIndex = 0;  // This variable keeps track of the 'next slot' to place an entry.

    // Constructor with parameters
    public DSAHeap(int pCount)
    {
        count = pCount;
        heapArray = new DSAHeapEntry[count];
    }

    // Mutator
    public void add(int priority, Shop value)
    {
        if(currentIndex < count)
        {
            // Create a new entry.
            DSAHeapEntry newEntry = new DSAHeapEntry();

            // Set the new entry and priority based on parameters supplied to function.
            newEntry.setPriority(priority);
            newEntry.setValue(value);
            heapArray[currentIndex] = newEntry;

            trickleUp(heapArray, currentIndex);

            currentIndex++;
        }
        else
        {
            System.out.println("Heap is full!");
        }
    }

    public DSAHeapEntry remove() 
    { 
        DSAHeapEntry root = null;
    
        if(currentIndex >= 0)
        {
            root = heapArray[0];
            currentIndex--;

            heapArray[0] = heapArray[currentIndex];
            heapArray[currentIndex] = null;  // Remove the last heap entry

            // Resize function
            DSAHeapEntry[] newArray = new DSAHeapEntry[currentIndex];
            System.arraycopy(heapArray, 0, newArray, 0, currentIndex);
            heapArray = newArray;
    
            trickleDown(heapArray, 0, currentIndex);
        }
    
        return root;
    }
    

    public void display()
    {
        for(int i = 0; i < heapArray.length; i++)
        {
            if(heapArray[i] != null)
            {
                System.out.print(heapArray[i].getPriority());
                System.out.print(", ");
                System.out.print(heapArray[i].getValue());

                System.out.println();
            }
        }
    }

    // Recursive trickle-up function
    private DSAHeapEntry[] trickleUp(DSAHeapEntry[] heapArray, int currentIndex)
    {
        int parentIndex = (currentIndex - 1) / 2;
        
        if(currentIndex > 0)
        {
            if(heapArray[currentIndex].getPriority() > heapArray[parentIndex].getPriority())
            {
                // Swapping portion of the code
                DSAHeapEntry temp = heapArray[parentIndex];
                heapArray[parentIndex] = heapArray[currentIndex];
                heapArray[currentIndex] = temp;

                trickleUp(heapArray, parentIndex);
            }
        }

        return heapArray;
    }

    // Recursive trickle-down function
    private DSAHeapEntry[] trickleDown(DSAHeapEntry[] heapArray, int currentIndex, int numOfItems)
    {
        int leftChildIndex = currentIndex * 2 + 1;
        int rightChildIndex = leftChildIndex + 1;

        if(leftChildIndex < numOfItems)
        {
            int largeIndex = leftChildIndex;

            if(rightChildIndex < numOfItems)
            {
                if(heapArray[leftChildIndex].getPriority() < heapArray[rightChildIndex].getPriority())
                {
                    largeIndex = rightChildIndex;
                }
            }

            if(heapArray[largeIndex].getPriority() > heapArray[currentIndex].getPriority())
            {
                // Swapping portion of the code
                DSAHeapEntry temp = heapArray[largeIndex];
                heapArray[largeIndex] = heapArray[currentIndex];
                heapArray[currentIndex] = temp;

                trickleDown(heapArray, largeIndex, numOfItems);
            }
        }

        return heapArray;
    }

    // THE HEAP SORT ALGORITHMS ARE BELOW

    public DSAHeapEntry[] heapify(DSAHeapEntry[] heapArray, int numItems)
    {
        for(int i = (numItems/2) - 1; i >= 0; i--)
        {
            trickleDown(heapArray, i, numItems);
        }

        return heapArray;
    }

    public DSAHeapEntry[] heapSort(DSAHeapEntry[] heapArray, int numItems)
    {
        heapify(heapArray, numItems);
        
        for(int i = (numItems-1); i >= 1; i--)
        {
            DSAHeapEntry temp = heapArray[0];
            heapArray[0] = heapArray[i];
            heapArray[i] = temp;

            trickleDown(heapArray, 0, i);
        }

        return heapArray;
    }

    public DSAHeapEntry[] getHeapArray()
    {
        return heapArray;
    }
}