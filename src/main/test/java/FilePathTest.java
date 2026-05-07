import org.junit.jupiter.api.Test;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FilePathTest {

    @Test
    void testFailOnLinux() {
        // SỬ DỤNG DOUBLE BACKSLASH (\\)
        // Đây là định dạng cứng của Windows.
        // Trên Linux, nó sẽ tìm một cái file tên là "src\test\resources\data.txt" 
        // thay vì vào từng thư mục, nên chắc chắn sẽ báo lỗi (Fail).
        String path = "src\\test\\resources\\data.txt";
        
        File file = new File(path);
        assertTrue(file.exists(), "Job này sẽ FAIL trên Linux/macOS vì không hiểu dấu \\");
    }

    // Test này sẽ chạy tốt trên mọi OS sau khi Refactor
    @Test
    void testSuccessEverywhere() {
        Path path = Paths.get("src", "test", "resources", "data.txt");
        assertTrue(Files.exists(path), "Thành công! Path tự thích nghi: " + path.toString());
    }
}