package com.metaarch.theatremanagement;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootTest
class TheatreManagementServiceApplicationTests {

  @MockBean(name = "layoutWebClient")
  private WebClient layoutWebClient;

  @Test
  void contextLoads() {
  }
}
