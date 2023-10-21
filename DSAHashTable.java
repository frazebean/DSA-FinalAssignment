// Credits to 'Jim Mischel' on StackOverflow for his answer on how to resize a hash table:
// https://stackoverflow.com/questions/22437416/best-way-to-resize-a-hash-table

// Credits to: https://www.geeksforgeeks.org/load-factor-and-rehashing/ for assisting me in
// choosing suitable upper/lower threshold values for resizing the hashArray.

public class DSAHashTable
{
    // Class fields
    private HashTableLinkedList[] hashArray;
    private int count = 0;

    // Constructor with parameters (tableSize)
    public DSAHashTable(int tableSize)
    {
        int actualSize;
        actualSize = findNextPrime(tableSize);
        hashArray = new HashTableLinkedList[actualSize];

        for(int i = 0; i < actualSize; i++)
        {
            hashArray[i] = new HashTableLinkedList();
        }
    }

    // Accessor method to get the hashArray length
    public int getHashArrayLength()
    {
        return hashArray.length;
    }

    // 'put' function. NOTE: inKey is the shop category, while inValue is the shop object.
    public void put(String inKey, Shop inValue)
    {
        int hashIndex = hash(inKey);
        hashArray[hashIndex].insertLast(inValue);

        //resizeIfNeeded();
    }

    // 'update' function
    public Shop get(String inKey, int label)
    {
        int hashIndex = hash(inKey);
        Shop foundShop = hashArray[hashIndex].findShop(label);

        return foundShop;
    }

    // 'remove' function
    public void remove(String inKey, int label)
    {
        int hashIndex = hash(inKey);
        Shop foundShop = hashArray[hashIndex].findShop(label);
        hashArray[hashIndex].remove(foundShop);

        //resizeIfNeeded();
    }

    // getLoadFactor function
    public double getLoadFactor()
    {
        return (double)count / (double)hashArray.length;
    }

    // Print
    public void printTable(String inKey)
    {
        int hashIndex = hash(inKey);

        for(int i = 0; i < hashArray[hashIndex].count(); i++)
        {
            int number = hashArray[hashIndex].get(i).getNumber();
            String name = hashArray[hashIndex].get(i).getName();
            String location = hashArray[hashIndex].get(i).getLocation();
            int rating = hashArray[hashIndex].get(i).getRating();

            System.out.println(number + ", " + name + ", " + location + ", " + rating);
        }
    }

    // Hash function.
    private int hash(String key)
    {
        int hashIndex = 0;

        for(int i = 0; i < key.length(); i++)
        {
            hashIndex = (31 * hashIndex) + key.charAt(i);
        }
        return Math.abs(hashIndex % hashArray.length);
    }

    // Function to find next prime number.
    private int findNextPrime(int startValue)
    {
        int primeValue;
        boolean isPrime = false;

        if(startValue % 2 == 0)
        {
            primeValue = startValue + 1;
        }
        else
        {
            primeValue = startValue;
        }

        primeValue = primeValue - 2;

        while(!isPrime)
        {
            primeValue = primeValue + 2;

            // Test if prime value candidate is actually a prime number.
            int i = 3;
            isPrime = true;
            while((i * i <= primeValue) && (isPrime))
            {
                if(primeValue % i == 0)
                {
                    isPrime = false;
                }
                else
                {
                    i = i + 2;
                }
            }
        }

        return primeValue;
    }

    // Function to check if a specific category even exists in the table.
    public boolean checkIfCategoryExists(String inKey)
    {
        boolean categoryExists = false;

        int hashIndex = hash(inKey);

        if(hashArray[hashIndex].count() != 0)
        {
            categoryExists = true;
        }

        return categoryExists;
    }
}