package com.example.demo.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Cho phép tất cả các API endpoints trong hệ thống
                .allowedOriginPatterns("*") // Giải pháp thay thế hoàn hảo cho "*" khi bật allowCredentials
                .allowCredentials(true) // Giữ nguyên để cho phép gửi kèm Cookie / Session nếu cần
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Thêm OPTIONS cho các request kiểm tra của trình duyệt
                .allowedHeaders("*") // Cho phép tất cả các loại Header truyền lên
                .maxAge(3600); // Lưu cấu hình kiểm tra CORS này trên trình duyệt trong 1 tiếng để tăng tốc độ tải
    }
}