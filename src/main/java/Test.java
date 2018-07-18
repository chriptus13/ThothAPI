import model.ThothClass;
import model.ThothResource;
import util.HTTPRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.text.MessageFormat;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Test {
    private static ThothAPI api = new ThothAPI(new ThothRawAPI(new HTTPRequest()));
    private static final String BASE = "https://adeetc.thothapp.com/classes/{0}/resources/{1, number, #}";

    public static void main(String[] args) {

        Stream<ThothClass> tClasses = StreamSupport.stream(() -> api.getThothClasses().join().spliterator(),
                Spliterator.DISTINCT + Spliterator.IMMUTABLE, false);

        tClasses.filter(t -> t.getClassName().startsWith("LI")).forEach(c -> {
            System.out.println(c);
            c.getResources().forEach(res -> System.out.println(MessageFormat.format(BASE, c.getFullName(), res.getId()).replaceAll(" ", "")));
            System.out.println();
        });


        /*ThothClass a = tClasses.skip(4).findAny().get();
        ThothResource r = a.getResources().skip(1).findFirst().get();
        String s = MessageFormat.format(BASE, a.getFullName(), r.getId()).replaceAll(" ", "");
        System.out.println(s);
        System.out.println(r);
        try(BufferedReader bf = new BufferedReader(new InputStreamReader(new URL(s).openStream()));
            PrintWriter pw = new PrintWriter("Test.pdf")) {
            String line;
            while((line = bf.readLine()) != null) pw.println(line);
        } catch(IOException e) {
            e.printStackTrace();
        }*/
    }
}
