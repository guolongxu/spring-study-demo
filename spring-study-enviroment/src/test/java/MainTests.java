import com.xgl.study.springenviroment.config.AppConfig;
import com.xgl.study.springenviroment.config.SpringBeanConfig;
import com.xgl.study.springenviroment.service.TestService1;
import com.xgl.study.springenviroment.service.TestService4;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

/**
 * 功能描述：
 *
 * @version 1.0
 * @author: xuguolong
 * @createDate: 2021/3/29
 */
public class MainTests {

    @Test
    public void test1() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringBeanConfig.class);
        TestService1 testService1 = applicationContext.getBean(TestService1.class);
        //TestService2 testService2 = applicationContext.getBean(TestService2.class);
        //TestService3 testService3 = applicationContext.getBean(TestService3.class);
        TestService4 testService4 = applicationContext.getBean(TestService4.class);

        //System.out.println("testService1 >> " + testService1);
        //System.out.println("testService2 >> " + testService2);
        //System.out.println("testService3 >> " + testService3);
        //System.out.println("testService4 >> " + testService4);

        Environment environment = applicationContext.getBean(Environment.class);

        AppConfig appConfig = applicationContext.getBean(AppConfig.class);
        System.out.println(appConfig);
    }

}
