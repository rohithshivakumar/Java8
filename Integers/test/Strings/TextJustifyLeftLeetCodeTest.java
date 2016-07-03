package Strings;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by arjun_000 on 6/5/2016.
 */
public class TextJustifyLeftLeetCodeTest {

    TextJustifyLeftLeetCode justifyLeftLeetCode;

    @Before
    public void setUp() throws Exception {
        justifyLeftLeetCode = new TextJustifyLeftLeetCode();
    }
    @Test
    public void testFullJustify() throws Exception {
        String[] words = new String[1];
        words[0] = "";
        int maxSize = 0;
        List<String> lines = justifyLeftLeetCode.fullJustify(words,maxSize);
        assertTrue(lines.size() == 1 );
        assertTrue(lines.get(0).equals(""));

        words = new String[]{"Listen","to","many,","speak","to","a","few."};
        maxSize = 6;
        List<String> expected = new ArrayList<String>(Arrays.asList("Listen","to    ","many, ","speak ","to   a","few.  "));
        lines = justifyLeftLeetCode.fullJustify(words,maxSize);
        checkJustification(lines, expected);


        words = new String[]{"a","b","c","d","e"};
        maxSize = 1;
        expected = new ArrayList<String>(Arrays.asList("a","b","c","d","e"));
        lines = justifyLeftLeetCode.fullJustify(words,maxSize);
        checkJustification(lines, expected);

        words = new String[]{"a","b","c","d","e"};
        maxSize = 3;
        expected = new ArrayList<String>(Arrays.asList("a b","c d","e  "));
        lines = justifyLeftLeetCode.fullJustify(words,maxSize);
        checkJustification(lines, expected);

        words = new String[]{"When","I","was","just","a","little","girl","I","asked","my","mother","what","will","I","be","Will","I","be","pretty","Will","I","be","rich","Here's","what","she","said","to","me","Que","sera","sera","Whatever","will","be","will","be","The","future's","not","ours","to","see","Que","sera","sera","When","I","was","just","a","child","in","school","I","asked","my","teacher","what","should","I","try","Should","I","paint","pictures","Should","I","sing","songs","This","was","her","wise","reply","Que","sera","sera","Whatever","will","be","will","be","The","future's","not","ours","to","see","Que","sera","sera","When","I","grew","up","and","fell","in","love","I","asked","my","sweetheart","what","lies","ahead","Will","there","be","rainbows","day","after","day","Here's","what","my","sweetheart","said","Que","sera","sera","Whatever","will","be","will","be","The","future's","not","ours","to","see","Que","sera","sera","What","will","be,","will","be","Que","sera","sera..."};
        maxSize = 60;
        expected = new ArrayList<String>(Arrays.asList("When  I was just a little girl I asked my mother what will I","be  Will  I be pretty Will I be rich Here's what she said to","me  Que  sera sera Whatever will be will be The future's not","ours  to see Que sera sera When I was just a child in school","I asked my teacher what should I try Should I paint pictures","Should  I  sing  songs This was her wise reply Que sera sera","Whatever  will  be  will be The future's not ours to see Que","sera  sera  When  I  grew  up  and  fell  in love I asked my","sweetheart  what lies ahead Will there be rainbows day after","day  Here's  what  my sweetheart said Que sera sera Whatever","will  be  will be The future's not ours to see Que sera sera","What will be, will be Que sera sera...                      "));
        lines = justifyLeftLeetCode.fullJustify(words,maxSize);
        checkJustification(lines, expected);



    }

    private void checkJustification(List<String> lines, List<String> expected) {
        assertEquals(expected.size(),lines.size());
        for(int i=0;i < lines.size(); i++){
            String line = lines.get(i);
            assertTrue(line.equals(expected.get(i)));
        }
    }

    @Test
    public void testJustifyLine() throws Exception {

    }

    @Test
    public void testJustifyLastLine() throws Exception {

    }



    @After
    public void tearDown() throws Exception {

    }
}