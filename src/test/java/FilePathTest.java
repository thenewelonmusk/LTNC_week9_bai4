import org.junit.jupiter.api.Test;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FilePathTest {
    @Test
    void testPath() {
        Path path = Paths.get("src", "test", "resources", "data.txt");
        assertTrue(Files.exists(path));
    }
}