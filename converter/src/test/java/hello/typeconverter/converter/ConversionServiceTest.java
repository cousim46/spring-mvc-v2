package hello.typeconverter.converter;

import hello.typeconverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.support.DefaultConversionService;

public class ConversionServiceTest {

    @Test
    public void conversionService() throws Exception {
        // 등록
        DefaultConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(new StringToIpPortConverter());
        conversionService.addConverter(new IntergerToStringConverter());
        conversionService.addConverter(new StringToIntergerConverter());
        conversionService.addConverter(new IpPortToStringConverter());
        // 사용
        Integer result = conversionService.convert("10", Integer.class);
        Assertions.assertThat(conversionService.convert("10", Integer.class)).isEqualTo(10);
        Assertions.assertThat(conversionService.convert(10, String.class)).isEqualTo("10");

        IpPort ipPort = conversionService.convert("127.0.0.1:8000", IpPort.class);
        Assertions.assertThat(ipPort).isEqualTo(new IpPort("127.0.0.1", 8000));

        String ipPortToString = conversionService.convert(new IpPort("127.0.0.1", 8000), String.class);
        Assertions.assertThat(ipPortToString).isEqualTo("127.0.0.1:8000");

        // then
    }
}
