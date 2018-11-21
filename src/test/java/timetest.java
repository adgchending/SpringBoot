import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class timetest {
    public static void main(String[] args) {
        boolean mozilla = StringUtils.contains("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0", "Mozilla");
        System.out.println(mozilla);
    }


}
