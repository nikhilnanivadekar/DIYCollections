package nikhil.nani.diy.collections;

import org.junit.Assert;
import org.junit.Test;

public class CanaryTests
{
    @Test
    public void canary()
    {
        Assert.assertTrue("This is a Canary Test True", true);
        Assert.assertFalse("This is a Canary Test False", false);
    }
}
