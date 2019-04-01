package nikhil.nani.diy.collections;

import java.util.List;

import org.eclipse.collections.impl.factory.Lists;

public class ListMultimap<K, V> extends Multimap<K, V>
{
    @Override
    protected List<V> getEmptyBackingCollection()
    {
        return Lists.mutable.empty();
    }

    public ListMultimap()
    {
    }
}
