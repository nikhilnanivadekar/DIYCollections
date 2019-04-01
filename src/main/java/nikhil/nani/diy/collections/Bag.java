package nikhil.nani.diy.collections;

import org.eclipse.collections.api.map.primitive.MutableObjectIntMap;
import org.eclipse.collections.impl.block.factory.primitive.IntToIntFunctions;
import org.eclipse.collections.impl.factory.primitive.ObjectIntMaps;

public class Bag<T>
{
    MutableObjectIntMap<T> backingMap = ObjectIntMaps.mutable.empty();

    public Bag(T... elements)
    {
        for (int i = 0; i < elements.length; i++)
        {
            this.backingMap.updateValue(elements[i], 0, IntToIntFunctions.increment());
        }
    }

    public static <T> Bag<T> newBagWith(T... elements)
    {
        return new Bag<>(elements);
    }

    public int getOccurrences(T element)
    {
        return this.backingMap.get(element);
    }

    public void add(T element)
    {
        this.addOccurrences(element, 1);
    }

    public void addOccurrences(T element, int occurrences)
    {
        this.backingMap.updateValue(element, 0, IntToIntFunctions.add(occurrences));
    }

    public void removeOccurrence(T element)
    {
        this.removeOccurrences(element, 1);
    }

    public void removeOccurrences(T element, int occurrences)
    {
        int value = this.backingMap.updateValue(element, 0, IntToIntFunctions.subtract(occurrences));
        if (value < 0)
        {
            this.backingMap.remove(element);
        }
    }
}
