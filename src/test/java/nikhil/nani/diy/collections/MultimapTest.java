package nikhil.nani.diy.collections;

import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Sets;
import org.junit.Assert;
import org.junit.Test;

public class MultimapTest
{
    // create
    @Test
    public void create()
    {
        SetMultimap setMultimap = new SetMultimap();
        ListMultimap listMultimap = new ListMultimap();
        Assert.assertNotNull(setMultimap);
        Assert.assertNotNull(listMultimap);
    }

    // putSetMultimap
    @Test
    public void putSetMultimap()
    {
        SetMultimap<String, String> setMultimap = new SetMultimap();

        setMultimap.put("Animal", "Cat");
        Assert.assertEquals(
                Sets.mutable.with("Cat"),
                setMultimap.get("Animal"));

        setMultimap.put("Animal", "Dog");
        setMultimap.put("Animal", "Elephant");
        Assert.assertEquals(
                Sets.mutable.with("Cat", "Dog", "Elephant"),
                setMultimap.get("Animal"));

        setMultimap.put("Animal", "Dog");
        Assert.assertEquals(
                Sets.mutable.with("Cat", "Dog", "Elephant"),
                setMultimap.get("Animal"));

        setMultimap.putAll("Animal", Lists.mutable.with("Dog", "Cat", "Dog", "Monkey"));
        Assert.assertEquals(
                Sets.mutable.with("Cat", "Dog", "Elephant", "Monkey"),
                setMultimap.get("Animal"));
    }

    // putListMultimap
    @Test
    public void putListMultimap()
    {
        ListMultimap<String, String> listMultimap = new ListMultimap();

        listMultimap.put("Animal", "Cat");
        Assert.assertEquals(
                Lists.mutable.with("Cat"),
                listMultimap.get("Animal"));

        listMultimap.put("Animal", "Dog");
        listMultimap.put("Animal", "Elephant");
        Assert.assertEquals(
                Lists.mutable.with("Cat", "Dog", "Elephant"),
                listMultimap.get("Animal"));

        listMultimap.put("Animal", "Dog");
        Assert.assertEquals(
                Lists.mutable.with("Cat", "Dog", "Elephant", "Dog"),
                listMultimap.get("Animal"));

        listMultimap.putAll("Animal", Lists.mutable.with("Dog", "Cat", "Monkey"));
        Assert.assertEquals(
                Lists.mutable.with("Cat", "Dog", "Elephant", "Dog", "Dog", "Cat", "Monkey"),
                listMultimap.get("Animal"));
    }

    // removeSetMultimap
    @Test
    public void removeSetMultimap()
    {
        SetMultimap setMultimap = new SetMultimap();
        setMultimap.put("Animal", "Cat");
        setMultimap.put("Animal", "Dog");
        setMultimap.put("Animal", "Elephant");
        setMultimap.put("Animal", "Dog");
        Assert.assertEquals(
                Sets.mutable.with("Cat", "Dog", "Elephant"),
                setMultimap.get("Animal"));

        setMultimap.remove("Animal", "Dog");
        Assert.assertEquals(Sets.mutable.with("Cat", "Elephant"), setMultimap.get("Animal"));

        setMultimap.removeAll("Animal");
        Assert.assertEquals(Sets.mutable.empty(), setMultimap.get("Animal"));
    }

    // removeListMultimap
    @Test
    public void removeListMultimap()
    {
        ListMultimap listMultimap = new ListMultimap();
        listMultimap.put("Animal", "Cat");
        listMultimap.put("Animal", "Dog");
        listMultimap.put("Animal", "Elephant");
        listMultimap.put("Animal", "Dog");
        Assert.assertEquals(
                Lists.mutable.with("Cat", "Dog", "Elephant", "Dog"),
                listMultimap.get("Animal"));

        listMultimap.remove("Animal", "Dog");
        Assert.assertEquals(
                Lists.mutable.with("Cat", "Elephant", "Dog"),
                listMultimap.get("Animal"));

        listMultimap.remove("Animal", "Dog");
        Assert.assertEquals(Lists.mutable.with("Cat", "Elephant"), listMultimap.get("Animal"));

        listMultimap.removeAll("Animal");
        Assert.assertEquals(Lists.mutable.empty(), listMultimap.get("Animal"));
    }
}
