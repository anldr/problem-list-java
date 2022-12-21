package commonutils.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JavaInputTemplate {
    private static String[] inputInteger() throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        return buf.readLine().split(" ");
    }
}
