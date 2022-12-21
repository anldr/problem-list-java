package commonutils.convert;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Slf4j
public class LeetCodeArrayConvert {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder strBuf = new StringBuilder();
        String input = buf.readLine();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '[') {
                strBuf.append('{');
            } else if (input.charAt(i) == ']') {
                strBuf.append('}');
                strBuf.append("\n");
            } else if (input.charAt(i) == '"') {
                strBuf.append('\'');
            } else {
                strBuf.append(input.charAt(i));
            }
        }

        log.info(strBuf.toString());
    }
}
