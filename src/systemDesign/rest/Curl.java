package systemDesign.rest;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Curl {

    public static String request = "curl https://reqbin.com/echo/get/json -d 'email:linuxize@example.com' -H 'Content-Type:application/json' -H 'Accept:everything' -d 'name:john'";

    public static void main(String[] args) throws IOException {
        String URL = null;
        Pattern urlPattern = Pattern.compile("http[^\\s]+");
        Matcher urlMatcher = urlPattern.matcher(request);
        if (urlMatcher.find()) {
            URL = urlMatcher.group();
        }


        Pattern pattern = Pattern.compile(" -H '*'");
        Matcher matcher = pattern.matcher(request);
        Map<String, List<String>> map = new HashMap<>();

        if (matcher.find()) {
            Stream<String> stream = pattern.splitAsStream(request).skip(1);
            stream.forEach(s -> {
                String[] strings = s.split(":");
                if (strings.length > 1) {
                    String sanitize = strings[1].substring(0, strings[1].length() - 1).trim();
                    map.put(strings[0], Collections.singletonList(sanitize));
                }

            });
            System.out.print(map);
        } else {
            System.out.println("Match not found");
        }

    }
}
