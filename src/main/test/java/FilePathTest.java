public class FilePathTest {

    @Test
    void testSeparatorLogic() {
        // Chúng ta ép logic: "Đường dẫn phải chứa dấu gạch chéo ngược"
        String path = "src\\test\\resources\\data.txt";
        
        // Lệnh này sẽ trả về dấu phân tách của OS đang chạy
        // Windows: \  |  Linux/Mac: /
        String currentOSSeparator = File.separator;

        // Test này CHẮC CHẮN FAIL trên Ubuntu và macOS 
        // vì File.separator của chúng là "/" chứ không phải "\"
        assertEquals("\\", currentOSSeparator, "Lỗi: OS này không sử dụng dấu gạch chéo ngược!");
    }
}