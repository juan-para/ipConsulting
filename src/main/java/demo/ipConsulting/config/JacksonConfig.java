package demo.ipConsulting.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import demo.ipConsulting.util.JacksonUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class JacksonConfig {

    @Bean
    public Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder() {
        return JacksonUtil.jackson2ObjectMapperBuilder();
    }

    @Bean
    public ObjectMapper primaryObjectMapper(final Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder) {
        return jackson2ObjectMapperBuilder.build();
    }
}
