package queue;

import org . junit . runner . RunWith ;
import org . junit . runners . Suite ;
import org . junit . runners . Suite . SuiteClasses ;
@RunWith ( Suite . class ) // Запустить класс как тестовый набор
@SuiteClasses ({ // Список тестовых классов в наборе для запуска

        QueueTest1 .class ,
        QueueTest2 .class ,
        QueueTest3 .class ,
})
class RunAll {

}