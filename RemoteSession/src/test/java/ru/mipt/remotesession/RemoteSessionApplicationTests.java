package ru.mipt.remotesession;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;


@EntityScan("ru.mipt.remotesession.models")
@SpringBootTest
class RemoteSessionApplicationTests {

    @Test
    void contextLoads() {
    }

}
