public class HashTableLinkedList
{
    // DSAListNode class
    private class DSAListNode
    {
        // Class fields
        public Shop value;
        public DSAListNode next;
        public DSAListNode prev;

        public DSAListNode(Shop inValue)
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
    public HashTableLinkedList()
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
    public void insertFirst(Shop newValue)
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
    public void insertLast(Shop newValue)
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
    public Shop peekFirst()
    {
        Shop nodeValue = null;
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
    public Shop peekLast()
    {
        Shop nodeValue = null;
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
    public Shop removeFirst()
    {
        Shop nodeValue = null;
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
    public Shop removeLast()
    {
        Shop nodeValue = null;
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

    // Mutator
    public Shop remove(Shop valueToRemove)
    {
        DSAListNode node = head;
        boolean nodeRemoved = false;
        Shop nodeValue = null;

        while(node != null)
        {
            if((node.value == valueToRemove) && (!nodeRemoved)) 
            {
                // If it's the first node we call removeFirst
                if(node == head)
                {
                    removeFirst();
                }
                // If it's the last node we call removeLast
                else if(node == tail) 
                {
                    removeLast();
                }
                else 
                {
                    nodeValue = node.value;
                    node.next.prev = node.prev;  // Update the next node's previous reference
                    node.prev.next = node.next;  // Update the previous node's next reference
                }
                nodeRemoved = true;
            }
            else 
            {
                node = node.next;
            }
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
        System.out.println();
    }

    public Shop findShop(int label)
    {
        Shop foundShop = null;

        for(int i = 0; i < this.count(); i++)
        {
            if(this.get(i).getNumber() == label)
            {
                foundShop = this.get(i);
            }
        }
        return foundShop;
    }

    // This function makes it so that I can track how many vertices are in the linked list.
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

    // This function allows getting a specific vertex in a linked list via an index.
    public Shop get(int index)
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

    // This function allows for setting a specific value in the linked list.
    public void set(int index, Shop valueToBeSet)
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

        node.value = valueToBeSet;
    }

    // Sorting is used for graph traversal
    public void bubbleSort()
    {
        int i, j;
        Shop temp;
        boolean swapped;

        for(i = 0; i < this.count() - 1; i++)
        {
            swapped = false;
            for(j = 0; j < this.count() - i - 1; j++)
            {
                if(this.get(j).getNumber() > this.get(j+1).getNumber())
                {
                    temp = this.get(j);
                    this.set(j, this.get(j+1));
                    this.set(j+1, temp);
                    swapped = true;
                }
            }

            if(swapped == false)
            {
                break;
            }
        }
    }
}
