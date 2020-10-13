package apolloClient;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;

public class GetConfigTest {

    //VM options:
    //-Dapp.id=SampleApp -Denv=DEV -Ddev_meta=http://localhost:8080
    public static void main(String[] args) {

        Config appConfig = ConfigService.getConfig("application");
        System.out.println("names===="+appConfig.getPropertyNames());
        //获取配置的第一个参数key,第二个参数默认值
        System.out.println("appConfig+++="+appConfig.toString());

        String timeout = appConfig.getProperty("timeout","0");
        System.out.println(timeout);
    }
}
