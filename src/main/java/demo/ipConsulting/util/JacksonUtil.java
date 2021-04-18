package demo.ipConsulting.util;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

public class JacksonUtil {
    public static Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder() {
        final Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
        builder.propertyNamingStrategy(PropertyNamingStrategy.LOWER_CAMEL_CASE);
        //builder.simpleDateFormat("dd-MM-yyyy");
        builder.failOnUnknownProperties(false);

        return builder;
    }
}