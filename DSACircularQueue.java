public class DSACircularQueue
{
    // Class fields
    protected GraphLinkedList queue;

    // Class constructor
    public DSACircularQueue()
    {
        queue = new GraphLinkedList();
    }

    // Mutator 'enqueue'
    public void enqueue(DSAGraphVertex value)
    {
        queue.insertLast(value);
    }

    // Mutator 'dequeue'
    public DSAGraphVertex dequeue()
    {
        DSAGraphVertex dequeueValue;
        if(isEmpty())
        {
            System.out.println("No value to dequeue from front of queue. (Queue is empty).");
            dequeueValue = null;
        }
        else
        {
            dequeueValue = queue.removeFirst();
        }
        return dequeueValue;
    }

    // Accessor 'peek'
    public DSAGraphVertex peek()
    {
        DSAGraphVertex peekValue;
        if(isEmpty())
        {
            System.out.println("No value at the front of queue. (Queue is empty).");
            peekValue = null;
        }
        else
        {
            peekValue = queue.peekFirst();
        }
        return peekValue;
    }

    // Accessor 'isEmpty'
    public boolean isEmpty()
    {
        return queue.isEmpty();
    }
}   
