package nikhil.nani.diy.collections;

import java.util.Set;

import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.impl.factory.Maps;
import org.eclipse.collections.impl.factory.Sets;

public class SetMultimap<K, V> extends Multimap<K, V>
{
    private MutableMap<K, Set<V>> backingMap = Maps.mutable.empty();

    public SetMultimap()
    {
    }

    @Override
    protected Set<V> getEmptyBackingCollection()
    {
        return Sets.mutable.empty();
    }
}
