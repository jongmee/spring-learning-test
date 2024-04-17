package cholog.scan;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfiguration {
    @Bean
    public ComponentScanBean componentScanBean() {
        return new ComponentScanBean();
    }
}
