package nikhil.nani.diy.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Bag<T>
{
    private Map<T, Integer> backingMap = new HashMap<>();
    private int size = 0;

    public Bag(T... elements)
    {
        // TODO implement constructor
        for (T element : elements)
        {
            backingMap.merge(element, 1, (existingCount, e) -> existingCount + 1);
            size++;
        }
    }

    public int size()
    {
        // TODO implement size
        return this.size;
    }

    public int sizeDistinct()
    {
        // TODO implement sizeDistinct
        return this.backingMap.size();
    }

    public int getOccurrences(T element)
    {
        // TODO implement getOccurrences
        return this.backingMap.getOrDefault(element, 0);
    }

    public int addOccurrence(T element)
    {
        return this.addOccurrences(element, 1);
    }

    public int addOccurrences(T element, int occurrences)
    {
        // TODO implement addOccurrences
        size = size + occurrences;
        return backingMap.merge(element, occurrences, (existingCount, e) -> existingCount + occurrences);
    }

    public boolean removeOccurrence(T element)
    {
        // TODO implement removeOccurrence
        return this.removeOccurrences(element, 1);
    }

    public boolean removeOccurrences(T element, int occurrences)
    {
        Integer existing = backingMap.get(element);
        if (existing != null)
        {
            Integer newCount = existing - occurrences;
            if (newCount <= 0)
            {
                this.backingMap.remove(element);
                size = size - existing;
            }
            else
            {
                this.backingMap.put(element, newCount);
                size = size - occurrences;
            }
            return true;
        }
        return false;
    }

    public void forEachWithOccurrences(BiConsumer<T, Integer> biConsumer)
    {
        // TODO implement forEachWithOccurrences
        this.backingMap.forEach(biConsumer);
    }

    public void forEach(Consumer<T> consumer)
    {
        // TODO implement forEach
        this.backingMap.forEach((each, count) ->
        {
            for (int i = 0; i < count; i++)
            {
                consumer.accept(each);

            }
        });
    }
}
