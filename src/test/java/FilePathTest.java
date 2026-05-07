import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FilePathTest {
    @Test
    void testForceFailOnNonWindows() {
        // Lấy tên hệ điều hành
        String os = System.getProperty("os.name").toLowerCase();
        
        // Nếu không phải windows, ta ép nó Fail bằng cách check một điều kiện vô lý
        if (!os.contains("win")) {
            // Trên Linux/Mac, lệnh này sẽ văng lỗi ngay lập tức
            throw new RuntimeException("OS này là " + os + ". Matrix đang hoạt động!");
        }
        
        // Trên Windows thì vẫn cho Pass
        assertTrue(true);
    }
}