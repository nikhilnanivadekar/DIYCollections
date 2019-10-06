package nikhil.nani.diy.collections;

import java.util.ArrayList;
import java.util.List;

public class ListMultimap<K, V> extends Multimap<K, V>
{
    public ListMultimap()
    {
    }

    @Override
    protected List<V> getEmptyBackingCollection()
    {
        return new ArrayList<>();
    }

}
