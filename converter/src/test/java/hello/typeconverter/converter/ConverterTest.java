package hello.typeconverter.converter;

import hello.typeconverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConverterTest {

    @Test
    public void stringToInteger() throws Exception {
        StringToIntergerConverter converter = new StringToIntergerConverter();
        Integer result = converter.convert("10");
        Assertions.assertThat(result).isEqualTo(10);
    }

    @Test
    public void IntegerToString() throws Exception {
        IntergerToStringConverter intergerToStringConverter = new IntergerToStringConverter();
        String result = intergerToStringConverter.convert(10);
        Assertions.assertThat(result).isEqualTo("10");
    }

    @Test
    public void StringToIpPort() throws Exception {
        StringToIpPortConverter stringToIpPortConverter = new StringToIpPortConverter();
        IpPort convert = stringToIpPortConverter.convert("127.0.0.1:8000");
        Assertions.assertThat(convert.getPort()).isEqualTo(8000);
        Assertions.assertThat(convert.getIp()).isEqualTo("127.0.0.1");


    }
    @Test
    public void IpPortToString() throws Exception {
        IpPortToStringConverter ipPortToStringConverter = new IpPortToStringConverter();
        String convert = ipPortToStringConverter.convert(new IpPort("127.0.0.1",8000));
        Assertions.assertThat(convert).isEqualTo("127.0.0.1:8000");


    }
}