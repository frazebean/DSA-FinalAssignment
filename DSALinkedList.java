public class DSALinkedList 
{
    // DSAListNode class
    private class DSAListNode
    {
        // Class fields
        public DSAGraphVertex value;
        public DSAListNode next;
        public DSAListNode prev;

        public DSAListNode(DSAGraphVertex inValue)
        {
            value = inValue;
            next = null;
            prev = null;
        }
    }

    // Class fields
    private DSAListNode head;
    private DSAListNode tail;

    // Default constructor
    public DSALinkedList()
    {
        head = null;
        tail = null;
    }

    // Accessor
    public boolean isEmpty()
    {
        boolean empty = false;
        if(head == null)
        {
            empty = true;
        }
        
        return empty;
    }

    // Mutator
    public void insertFirst(DSAGraphVertex newValue)
    {
        DSAListNode newNode = new DSAListNode(newValue);
        if(isEmpty())
        {
            tail = newNode;
        }
        else
        {
            head.prev = newNode;
        }
        newNode.next = head;
        head = newNode;
    }
    
    // Mutator
    public void insertLast(DSAGraphVertex newValue)
    {
        DSAListNode newNode = new DSAListNode(newValue);
        if(isEmpty())
        {
            head = newNode;
        }
        else
        {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
    }

    // Accessor
    public DSAGraphVertex peekFirst()
    {
        DSAGraphVertex nodeValue = null;
        if(isEmpty())
        {
            System.out.println("No first value to peek.");
        }
        else
        {
            nodeValue = head.value;
        }

        return nodeValue;
    }
    
    // Accessor
    public DSAGraphVertex peekLast()
    {
        DSAGraphVertex nodeValue = null;
        if(isEmpty())
        {
            System.out.println("No last value to peek.");
        }
        else
        {
            nodeValue = tail.value;
        }

        return nodeValue;
    }

    // Mutator
    public DSAGraphVertex removeFirst()
    {
        DSAGraphVertex nodeValue = null;
        try
        {
            nodeValue = head.value;
            if(head.next == null)
            {
                tail = null;
            }
            else
            {
                head.next.prev = null;
            }
            head = head.next;
        }
        catch(NullPointerException error)
        {
            System.out.println("No first value to remove.");
        }

        return nodeValue;
    }

    // Mutator
    public DSAGraphVertex removeLast()
    {
        DSAGraphVertex nodeValue = null;
        try
        {
            nodeValue = tail.value;
            if(head.next == null)
            {
                head = null;
            }
            else
            {
                tail.prev.next = null;
            }
            tail = tail.prev;
        }
        catch(NullPointerException error)
        {
            System.out.println("No last value to remove.");
        }

        return nodeValue;
    }

    public void printLinkedList()
    {
        DSAListNode node = head;

        while(node != null)
        {
            if(node.next != null)
            {
                System.out.print(node.value + ", ");
            }
            else
            {
                System.out.print(node.value);
            }
            node = node.next;
        }
    }

    public DSAGraphVertex find(DSAGraphVertex target)
    {
        boolean resume = true;
        DSAGraphVertex targetValue = null;
        DSAListNode node = head;

        while((node != null) && resume)
        {
            if(node.value.equals(target))
            {
                targetValue = node.value;
                resume = false;
            }
            node = node.next;
        }

        return targetValue;
    }

    public DSAGraphVertex findVertex(int label)
    {
        DSAGraphVertex foundVertex = null;

        for(int i = 0; i < this.count(); i++)
        {
            if(this.get(i).getLabel() == label)
            {
                foundVertex = this.get(i);
            }
        }
        return foundVertex;
    }

    public int count()
    {
        int count = 0;
        DSAListNode node = head;

        while(node != null)
        {
            count++;
            node = node.next;
        }
        return count;
    }

    public DSAGraphVertex get(int index)
    {
        if(index < 0 || index >= count())
        {
            throw new IndexOutOfBoundsException("Index out of bounds!");
        }

        int i = 0;
        DSAListNode node = head;
        while(i < index)
        {
            node = node.next;
            i++;
        }

        return node.value;
    }
}
