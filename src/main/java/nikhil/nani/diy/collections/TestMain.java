package nikhil.nani.diy.collections;

import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.factory.Lists;

public class TestMain
{
    public static void main(String[] args)
    {
        System.out.println("Test Main");

        MutableList<String> list = Lists.mutable.with("Test Main 1", "Test Main 2");

        System.out.println(list);
    }
}
