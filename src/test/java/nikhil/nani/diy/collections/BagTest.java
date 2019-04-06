package nikhil.nani.diy.collections;

import java.util.Map;

import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Maps;
import org.junit.Assert;
import org.junit.Test;

public class BagTest
{
    // Create Bag
    @Test
    public void createBag()
    {
        Bag<String> bag1 = new Bag();
        Assert.assertNotNull(bag1);

        Bag<String> bag2 = Bag.newBagWith("Apples", "Bananas", "Oranges");
        Assert.assertNotNull(bag2);
    }

    // getOccurrences
    @Test
    public void getOccurrences()
    {
        Bag<String> bag = Bag.newBagWith("Apples", "Apples", "Bananas", "Oranges");

        int appleCount = bag.getOccurrences("Apples");
        Assert.assertEquals(2, appleCount);

        Assert.assertEquals(1, bag.getOccurrences("Bananas"));
    }

    // add, addOccurrences
    @Test
    public void add_addOccurrences()
    {
        Bag<String> bag = Bag.newBagWith("Apples", "Apples", "Bananas", "Oranges");
        Assert.assertEquals(2, bag.getOccurrences("Apples"));
        Assert.assertEquals(1, bag.getOccurrences("Bananas"));

        bag.add("Bananas");
        Assert.assertEquals(2, bag.getOccurrences("Bananas"));
        bag.addOccurrences("Bananas", 4);
        Assert.assertEquals(6, bag.getOccurrences("Bananas"));
    }

    // remove, removeOccurrences
    @Test
    public void remove_removeOccurrences()
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
    }

    // forEach
    @Test
    public void forEach()
    {
        Bag<String> bag = Bag.newBagWith();
        bag.addOccurrences("Apple", 12);
        bag.addOccurrences("Banana", 6);
        bag.addOccurrences("Orange", 1);

        MutableList<String> list = Lists.mutable.empty();
        bag.forEach(list::add);

        Assert.assertEquals(12, list.count(each -> each.equals("Apple")));
        Assert.assertEquals(6, list.count(each -> each.equals("Banana")));
        Assert.assertEquals(1, list.count(each -> each.equals("Orange")));
    }

    // forEachWithOccurrencesTest
    @Test
    public void forEachWithOccurrences()
    {
        Bag<String> bag = Bag.newBagWith();
        bag.addOccurrences("Apple", 12);
        bag.addOccurrences("Banana", 6);
        bag.addOccurrences("Orange", 1);

        Map<String, Integer> map = Maps.mutable.empty();
        bag.forEachWithOccurrences((each, occurrences) -> map.put(each, occurrences));

        Assert.assertEquals(Integer.valueOf(12), map.get("Apple"));
        Assert.assertEquals(Integer.valueOf(6), map.get("Banana"));
        Assert.assertEquals(Integer.valueOf(1), map.get("Orange"));
    }
}
