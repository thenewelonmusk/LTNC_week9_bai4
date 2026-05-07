import org.junit.jupiter.api.Test;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FilePathTest {

    // Test này sẽ bị lỗi trên Linux/macOS vì dùng dấu \ của Windows
    @Test
    void testFailOnLinux() {
        String path = "src\\test\\resources\\data.txt";
        File file = new File(path);
        assertTrue(file.exists(), "Lỗi! Không tìm thấy file trên OS này: " + path);
    }

    // Test này sẽ chạy tốt trên mọi OS sau khi Refactor
    @Test
    void testSuccessEverywhere() {
        Path path = Paths.get("src", "test", "resources", "data.txt");
        assertTrue(Files.exists(path), "Thành công! Path tự thích nghi: " + path.toString());
    }
}