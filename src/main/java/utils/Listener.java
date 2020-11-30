package utils;

import org.testng.ITestListener;
import org.testng.ITestResult;

import java.sql.SQLOutput;

public class Listener implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Тест выполнился успешно ");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Туст упал");
    }
}
