package test1;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test2 {


    @BeforeClass
    private void beforeMethod(){
        System.out.println("parallel thread");
    }

    //@parallel � ���� ���������� � true, ����� ����� ��� ������� ������ ������ ����� �������� ����������, � ��������� ������:

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

    @Test(dataProvider = "concurrencyData", alwaysRun = true)
    public void testParallelData(String first, String second) {
        final Thread thread = Thread.currentThread();
        System.out.printf("# thread id: %d, thread name: %s: %s : %s", thread.getId(),
                thread.getName(), first, second);
        System.out.println();
    }
}
