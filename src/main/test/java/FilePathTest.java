import org.junit.jupiter.api.Test;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FilePathTest {

    @Test
    void testPathLogic() {
        // Giả sử bạn muốn lấy tên file từ một đường dẫn đầy đủ
        String fullPath = "src\\test\\resources\\data.txt";
        
        // Tìm vị trí dấu gạch chéo cuối cùng để cắt lấy tên file
        // Trên Windows: tìm thấy ở vị trí cuối cùng
        // Trên Linux: KHÔNG tìm thấy dấu \ nào cả, kết quả trả về -1
        int lastSeparator = fullPath.lastIndexOf("\\");
        
        // Ép lỗi: Nếu không tìm thấy dấu \ (trên Linux/Mac), 
        // phép tính lastSeparator + 1 sẽ không như ý muốn
        assertTrue(lastSeparator != -1, "Phải tìm thấy dấu gạch chéo ngược trong đường dẫn!");
        
        String fileName = fullPath.substring(lastSeparator + 1);
        assertEquals("data.txt", fileName);
    }

    // Test này sẽ chạy tốt trên mọi OS sau khi Refactor
    @Test
    void testSuccessEverywhere() {
        Path path = Paths.get("src", "test", "resources", "data.txt");
        assertTrue(Files.exists(path), "Thành công! Path tự thích nghi: " + path.toString());
    }
}