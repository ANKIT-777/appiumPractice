import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TestAndroidFirst {
    UiAutomator2Options option = new UiAutomator2Options();

    @Test
    void androidSetup() throws MalformedURLException, InterruptedException {
        option.setPlatformName("Android");
        option.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        option.setDeviceName("Ankit-device");
        option.setApp("/Users/ankitsharma/IdeaProjects/appium2.0/src/test/Android-MyDemoAppRN.1.3.0.build-244.apk");
        URL url = new URL("http://127.0.0.1:4723/");
        AndroidDriver androidDriver = new AndroidDriver(url,option);
        Thread.sleep(2000);
    }


}
