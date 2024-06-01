import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class Test02 {
    @Test
    public void test() {
        String str1 = "abc";
        String str2 = new String("abc");
        String str3 = str2.intern();

        log.info("{}", str1 == str2);
        log.info("{}", str2 == str3);
        log.info("{}", str1 == str3);
    }
}
