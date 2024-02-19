import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class serverSetup {

    static AppiumDriverLocalService server;

    static  void setup() throws IOException {
        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder
                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .usingDriverExecutable(new File("/usr/local/bin/node")) //node path
                .usingPort(4723)
                .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
                .withLogFile(new File( "Appiumlog"+ System.currentTimeMillis() +" txt"))
                .withIPAddress("127.0.0.1");
        server = AppiumDriverLocalService.buildService(builder);
    }

    static AppiumDriverLocalService getInstance() throws IOException {
        if(server == null){
            setup();
        }
        return  server;
    }

    public static void start() throws IOException {
        getInstance().start();
    }
    public static void  stop() throws IOException {
        if(server != null){
            getInstance().stop();
        }
    }

}
