package Companies.Bloomberg;

import java.util.*;

public class WordLadder {

    /**
     * O(M×N)
     * M is the length of words and
     * N is the total number of words in the input word list.
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        int len = beginWord.length(), step = 1;
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        while(!q.isEmpty()) {
            step++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                char[] cur = q.poll().toCharArray();
                for (int p = 0; p < len; p++) {
                    char c = cur[p];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        cur[p] = ch;
                        String newone = new String(cur);
                        if (set.contains(newone)) {
                            if (newone.equals(endWord)) {
                                return step;
                            }
                            set.remove(newone);
                            q.add(newone);
                        }
                    }
                    cur[p] = c;
                }
            }
        }
        return 0;
    }
}
