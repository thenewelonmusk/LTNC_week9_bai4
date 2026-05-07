import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FilePathTest {
    @Test
    void testWindowsPath() {
        // Ép buộc dùng dấu \ của Windows
        String path = "src\\test\\resources\\data.txt";
        File file = new File(path);
        
        // Trên Windows: Hệ điều hành tự hiểu và trả về True
        // Trên Ubuntu/macOS: Hệ thống tìm file tên là "src\test\resources\data.txt" (coi \ là ký tự thường) -> False
        assertTrue(file.exists(), "Lỗi: Không tìm thấy file trên hệ điều hành này!");
    }
}