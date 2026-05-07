import org.junit.jupiter.api.Test;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FilePathTest {

    @Test
    void testFailOnLinuxDueToCaseAndSeparator() {
        // 1. Ép lỗi dấu gạch chéo ngược: 
        // Trên Linux, dấu này không phải là phân tách thư mục, nó sẽ tìm file tên là "src\test..."
        String windowsPath = "src\\test\\resources\\data.txt";
        File file = new File(windowsPath);
        
        // 2. Ép lỗi Case Sensitivity: 
        // Giả sử file thật là 'data.txt', ta gọi 'DATA.TXT'
        // Windows: Pass | Linux: Fail
        File caseFile = new File("src/test/resources/DATA.TXT");

        assertAll("Bẫy lỗi hệ điều hành",
            () -> assertTrue(file.exists(), "Chắc chắn Fail trên Linux vì dùng dấu \\"),
            () -> assertTrue(caseFile.exists(), "Chắc chắn Fail trên Linux vì DATA.TXT khác data.txt")
        );
    }

    // Test này sẽ chạy tốt trên mọi OS sau khi Refactor
    @Test
    void testSuccessEverywhere() {
        Path path = Paths.get("src", "test", "resources", "data.txt");
        assertTrue(Files.exists(path), "Thành công! Path tự thích nghi: " + path.toString());
    }
}