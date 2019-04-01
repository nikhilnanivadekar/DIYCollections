package nikhil.nani.diy.collections;

import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Sets;
import org.junit.Assert;
import org.junit.Test;

public class MultimapTest
{
    @Test
    public void create()
    {
        SetMultimap setMultimap = new SetMultimap();
        ListMultimap listMultimap = new ListMultimap();
        Assert.assertNotNull(setMultimap);
        Assert.assertNotNull(listMultimap);
    }

    @Test
    public void put()
    {
        SetMultimap<String, String> setMultimap = new SetMultimap();
        ListMultimap<String, String> listMultimap = new ListMultimap();

        setMultimap.put("Animal", "Cat");
        Assert.assertNotNull(setMultimap);

        Assert.assertEquals(
                setMultimap.get("Animal"),
                Sets.mutable.with("Cat"));
        setMultimap.put("Animal", "Dog");
        setMultimap.put("Animal", "Elephant");

        Assert.assertEquals(
                setMultimap.get("Animal"),
                Sets.mutable.with("Cat", "Dog", "Elephant"));

        listMultimap.put("Animal", "Cat");
        Assert.assertNotNull(listMultimap);

        Assert.assertEquals(
                listMultimap.get("Animal"),
                Lists.mutable.with("Cat"));
        listMultimap.put("Animal", "Dog");
        listMultimap.put("Animal", "Elephant");

        Assert.assertEquals(
                listMultimap.get("Animal"),
                Lists.mutable.with("Cat", "Dog", "Elephant"));

        setMultimap.put("Animal", "Dog");
        listMultimap.put("Animal", "Dog");

        Assert.assertEquals(
                setMultimap.get("Animal"),
                Sets.mutable.with("Cat", "Dog", "Elephant"));

        Assert.assertEquals(
                listMultimap.get("Animal"),
                Lists.mutable.with("Cat", "Dog", "Elephant", "Dog"));

        setMultimap.putAll("Animal", Lists.mutable.with("Dog", "Cat", "Monkey"));
        listMultimap.putAll("Animal", Lists.mutable.with("Dog", "Cat", "Monkey"));

        Assert.assertEquals(
                setMultimap.get("Animal"),
                Sets.mutable.with("Cat", "Dog", "Elephant", "Monkey"));

        Assert.assertEquals(
                listMultimap.get("Animal"),
                Lists.mutable.with("Cat", "Dog", "Elephant", "Dog", "Dog", "Cat", "Monkey"));
    }

    @Test
    public void removeAll()
    {
        SetMultimap setMultimap = new SetMultimap();
        ListMultimap listMultimap = new ListMultimap();

        setMultimap.put("Animal", "Cat");
        setMultimap.put("Animal", "Dog");
        setMultimap.put("Animal", "Elephant");

        listMultimap.put("Animal", "Cat");
        listMultimap.put("Animal", "Dog");
        listMultimap.put("Animal", "Elephant");

        setMultimap.put("Animal", "Dog");
        listMultimap.put("Animal", "Dog");

        Assert.assertEquals(
                setMultimap.get("Animal"),
                Sets.mutable.with("Cat", "Dog", "Elephant"));

        Assert.assertEquals(
                listMultimap.get("Animal"),
                Lists.mutable.with("Cat", "Dog", "Elephant", "Dog"));

        setMultimap.removeAll("Animal");
        Assert.assertEquals(setMultimap.get("Animal"), Sets.mutable.empty());
        listMultimap.remove("Animal", "Cat");
        Assert.assertEquals(listMultimap.get("Animal"), Lists.mutable.with("Dog", "Elephant", "Dog"));

        listMultimap.remove("Animal", "Dog");
        Assert.assertEquals(listMultimap.get("Animal"), Lists.mutable.with("Elephant", "Dog"));
    }
}
