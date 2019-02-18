package test1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test2 {

    //@parallel у дата провайдера в true, тогда тесты для каждого набора данных будут запущены паралельно, в отдельном потоке:

    @DataProvider(parallel = true)
    public Object[][] concurrencyData() {
        return new Object[][]{
                {"1", "2"},
                {"3", "4"},
                {"5", "6"},
                {"7", "8"},
                {"9", "10"},
                {"11", "12"},
                {"13", "14"},
                {"15", "16"},
                {"17", "18"},
                {"19", "20"},
        };
    }

    @Test(dataProvider = "concurrencyData")
    public void testParallelData(String first, String second) {
        final Thread thread = Thread.currentThread();
        System.out.printf("# thread id: %d, thread name: %s: %s : %s", thread.getId(),
                thread.getName(), first, second);
        System.out.println();
    }
}
