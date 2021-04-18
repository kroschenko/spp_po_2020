package queue;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses ({EmptyQueueTests.class, ManyElementsQueueTests.class, OneElementQueueTests.class})
public class QueueSuiteTest
{

}
