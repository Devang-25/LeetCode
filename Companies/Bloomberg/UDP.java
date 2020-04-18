package Companies.Bloomberg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class UDP {

    public void udp(List<Stream> l) {
        TreeMap<Integer, String> m = new TreeMap<>();
        int index = 1;
        for (Stream s : l) {
            m.put(s.index, s.content);
            while (!m.isEmpty() && m.firstKey() == index) {
                System.out.println(m.pollFirstEntry().getValue());
                index++;
            }
        }
    }

    public static void main(String...args) {
        UDP test = new UDP();
        test.udp(Arrays.asList(new Stream(1, "a"),
                new Stream(2, "b"), new Stream(4, "d"),
                new Stream(5, "e"), new Stream(3, "c")));

        test.udp(Arrays.asList(new Stream(1, "a"),
                new Stream(2, "b"), new Stream(4, "d")));
    }

    static class Stream {
        int index;
        String content;

        Stream(int index, String content) {
            this.index = index;
            this.content = content;
        }
    }
}
