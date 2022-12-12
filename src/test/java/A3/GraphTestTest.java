package A3;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;

import A3.GraphTest;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class GraphTestTest {

    private Path workingDir;
    private static GraphTest cc;

    public static void setUp(){
        cc = new GraphTest();
    }

    public void initFile(){
        this.workingDir = Path.of("coen_course2","coen_course2.gph");
    }

    @Test
    void isPrerequisite() throws IOException {
        cc = new GraphTest();
        BufferedReader f;
        f = new BufferedReader(new InputStreamReader(new FileInputStream("coen_course2.gph")));
        Graph G = new Graphm();
        cc.createGraph(f, G);

        assertTrue( G.isPrerequisite("MATH204","COEN212"));
        assertTrue( G.isPrerequisite("COEN346","COEN366"));
        assertFalse( G.isPrerequisite("COEN366","COEN212"));
    }
}