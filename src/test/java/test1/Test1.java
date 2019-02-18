package test1;

import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test1 {

    private Map<String, String> data;

    @BeforeClass
    void setUp(){
        data = new HashMap<String, String>();
    }

    @AfterClass
    void tearDown(){
        data = null;
    }

//    threadPoolSize определяет максимальное количество потоков используемое для тестов
//    singleThreaded если установлен в true все тесты будут запущены в одном потоке.
//    invocationCount определяет количество запусков теста.
//    invocationTimeOut определяет общее время всех запусков теста, после которого тест считается провалившемся.

    @Test(threadPoolSize = 10, invocationCount = 10, invocationTimeOut = 100)
    public void testMapOperations(){
        data.put("1", "11");
        data.put("2", "22");
        data.put("3", "33");
        data.put("4", "44");
        data.put("5", "55");
        data.put("6", "66");
        data.put("7", "77");
        for (Map.Entry<String, String> entry : data.entrySet()) {
            System.out.println(entry);
        }
        data.clear();
    }

    @Test(singleThreaded = true, invocationCount = 100, invocationTimeOut = 10000)
    public void testMapOperationsSafe(){
        data.put("1", "111");
        data.put("2", "111");
        data.put("3", "111");
        data.put("4", "111");
        data.put("5", "111");
        data.put("6", "111");
        data.put("7", "111");
        for (Map.Entry<String, String> entry : data.entrySet()) {
            System.out.println(entry);
        }
        data.clear();
    }
}
