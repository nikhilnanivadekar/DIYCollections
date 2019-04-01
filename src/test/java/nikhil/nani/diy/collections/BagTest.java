package nikhil.nani.diy.collections;

import org.junit.Assert;
import org.junit.Test;

public class BagTest
{
    @Test
    public void createBag()
    {
        Bag<String> bag = new Bag();
        Assert.assertNotNull(bag);
    }

    @Test
    public void createBagWithElements()
    {
        Bag<String> bag = Bag.newBagWith("Apples", "Bananas", "Oranges");
        Assert.assertNotNull(bag);
    }

    @Test
    public void createBagWithDuplicateElements()
    {
        Bag<String> bag = Bag.newBagWith("Apples", "Apples", "Bananas", "Oranges");
        Assert.assertNotNull(bag);
        int appleCount = bag.getOccurrences("Apples");
        Assert.assertEquals(2, appleCount);
        Assert.assertEquals(1, bag.getOccurrences("Bananas"));
    }

    @Test
    public void addElementsToBag()
    {
        Bag<String> bag = Bag.newBagWith("Apples", "Apples", "Bananas", "Oranges");
        Assert.assertNotNull(bag);
        int appleCount = bag.getOccurrences("Apples");
        Assert.assertEquals(2, appleCount);
        Assert.assertEquals(1, bag.getOccurrences("Bananas"));
        bag.add("Bananas");
        Assert.assertEquals(2, bag.getOccurrences("Bananas"));
        bag.addOccurrences("Bananas", 4);
        Assert.assertEquals(6, bag.getOccurrences("Bananas"));
    }

    @Test
    public void removeElementsFromBag()
    {
        Bag<String> bag = Bag.newBagWith();
        bag.addOccurrences("Apple", 12);
        bag.addOccurrences("Banana", 6);
        bag.addOccurrences("Orange", 1);

        Assert.assertEquals(12, bag.getOccurrences("Apple"));
        Assert.assertEquals(6, bag.getOccurrences("Banana"));
        Assert.assertEquals(1, bag.getOccurrences("Orange"));

        bag.removeOccurrence("Apple");
        Assert.assertEquals(11, bag.getOccurrences("Apple"));
        bag.removeOccurrences("Banana", 2);
        Assert.assertEquals(4, bag.getOccurrences("Banana"));
        bag.removeOccurrence("Orange");
        Assert.assertEquals(0, bag.getOccurrences("Orange"));
        bag.removeOccurrence("Orange");
        Assert.assertEquals(0, bag.getOccurrences("Orange"));

        bag.removeOccurrences("Banana", 6);
        Assert.assertEquals(0, bag.getOccurrences("Banana"));
        bag.removeOccurrences("Banana", 6);
        Assert.assertEquals(0, bag.getOccurrences("Banana"));
    }
}
