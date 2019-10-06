package nikhil.nani.diy.collections;

import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

public class BagTest
{
    @Test
    public void countLetters()
    {
        // Reference https://gist.github.com/JosePaumard/ba9d255ebb1b68b76639681d510f3c71

        String testString = "the quick brown fox jumps over the lazy dog";
        Map<String, Long> map = testString.chars()
                .filter(Character::isLetter)
                .mapToObj(each -> String.valueOf((char) each))
                .collect(Collectors.groupingBy(each -> each, Collectors.counting()));

        Assert.assertEquals(26, map.size());
        Assert.assertEquals(35,
                map.values().stream().mapToInt(Long::intValue).sum());

    }

    @Test
    public void createBag()
    {
        String apple = "apple";
        String banana = "banana";
        String orange = "orange";

        Bag<String> bag = new Bag(apple, banana, orange, apple);

        Assert.assertEquals(2, bag.getOccurrences(apple));
        Assert.assertEquals(1, bag.getOccurrences(banana));
        Assert.assertEquals(1, bag.getOccurrences(orange));
        Assert.assertEquals(4, bag.size());
        Assert.assertEquals(3, bag.sizeDistinct());
    }

    @Test
    public void addOccurrencesBag()
    {
        String apple = "apple";
        String banana = "banana";
        String orange = "orange";

        Bag<String> bag = new Bag(apple, banana, orange, orange, orange, apple);

        Assert.assertEquals(2, bag.getOccurrences(apple));
        Assert.assertEquals(1, bag.getOccurrences(banana));
        Assert.assertEquals(3, bag.getOccurrences(orange));
        Assert.assertEquals(6, bag.size());
        Assert.assertEquals(3, bag.sizeDistinct());

        bag.addOccurrences(orange, 4);
        bag.addOccurrences("strawberry", 12);
        Assert.assertEquals(7, bag.getOccurrences(orange));
        Assert.assertEquals(12, bag.getOccurrences("strawberry"));
        Assert.assertEquals(22, bag.size());
        Assert.assertEquals(4, bag.sizeDistinct());

        bag.addOccurrence("strawberry");
        Assert.assertEquals(13, bag.getOccurrences("strawberry"));
    }

    @Test
    public void removeOccurrencesBag()
    {
        String apple = "apple";
        String banana = "banana";
        String orange = "orange";

        Bag<String> bag = new Bag(apple, banana, orange, orange, orange, apple);

        Assert.assertEquals(2, bag.getOccurrences(apple));
        Assert.assertEquals(1, bag.getOccurrences(banana));
        Assert.assertEquals(3, bag.getOccurrences(orange));
        Assert.assertEquals(6, bag.size());
        Assert.assertEquals(3, bag.sizeDistinct());

        bag.removeOccurrence(orange);
        Assert.assertEquals(2, bag.getOccurrences(orange));
        Assert.assertEquals(5, bag.size());
        Assert.assertEquals(3, bag.sizeDistinct());

        bag.removeOccurrence(orange);
        bag.removeOccurrence(orange);
        bag.removeOccurrence(orange);

        Assert.assertEquals(0, bag.getOccurrences(orange));
        Assert.assertEquals(3, bag.size());
        Assert.assertEquals(2, bag.sizeDistinct());
    }

    @Test
    public void removeOccurrencesBag2()
    {
        String apple = "apple";
        String banana = "banana";
        String orange = "orange";

        Bag<String> bag = new Bag(apple, banana, orange, orange, orange, apple);

        Assert.assertEquals(2, bag.getOccurrences(apple));
        Assert.assertEquals(1, bag.getOccurrences(banana));
        Assert.assertEquals(3, bag.getOccurrences(orange));
        Assert.assertEquals(6, bag.size());
        Assert.assertEquals(3, bag.sizeDistinct());

        bag.removeOccurrences(orange, 4);
        Assert.assertEquals(0, bag.getOccurrences(orange));
        Assert.assertEquals(3, bag.size());
        Assert.assertEquals(2, bag.sizeDistinct());
    }

    @Test
    public void forEachWithOccurrences()
    {
        String apple = "apple";
        String banana = "banana";
        String orange = "orange";

        Bag<String> bag = new Bag(apple, banana, orange);

        StringBuilder builder = new StringBuilder();

        bag.forEachWithOccurrences((each, occurrences)
                -> builder.append(each).append(":").append(occurrences));
        Assert.assertTrue(builder.toString().contains("apple:1"));
    }

    @Test
    public void forEach()
    {
        String apple = "apple";
        String banana = "banana";
        String orange = "orange";

        Bag<String> bag = new Bag(apple, banana, orange, apple);

        StringBuilder builder = new StringBuilder();

        bag.forEach(each -> builder.append(each).append(", "));
        Assert.assertTrue(builder.toString().contains("apple, apple"));
        Assert.assertTrue(builder.toString().contains("banana, "));
    }
}
