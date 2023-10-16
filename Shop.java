public class Shop 
{
    // Class fields
    private int number;
    private String name;
    private String category;
    private String location;
    private int rating;

    // Constructor with parameters
    public Shop(int pNumber, String pName, String pCategory, String pLocation, int pRating)
    {
        number = pNumber;
        name = pName;
        category = pCategory;
        location = pLocation;
        rating = pRating;
    }

    // Accessors
    public int getNumber()
    {
        return number;
    }
    public String getName()
    {
        return name;
    }
    public String getCategory()
    {
        return category;
    }
    public String getLocation()
    {
        return location;
    }
    public int getRating()
    {
        return rating;
    }

    // Mutators
    public void setNumber(int pNumber)
    {
        number = pNumber;
    }
    public void setName(String pName)
    {
        name = pName;
    }
    public void setCategory(String pCategory)
    {
        category = pCategory;
    }
    public void setLocation(String pLocation)
    {
        location = pLocation;
    }
    public void setRating(int pRating)
    {
        rating = pRating;
    }
}
