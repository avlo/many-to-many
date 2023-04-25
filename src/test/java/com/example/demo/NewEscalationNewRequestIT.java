package com.example.demo;

import com.example.demo.entity.Escalationnick;
import com.example.demo.entity.Requestnick;
import com.example.demo.service.EscalationnickService;
import com.example.demo.service.RequestnickService;
import java.util.IllegalFormatException;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
//@TestPropertySource(properties = {
//    "spring.jpa.hibernate.ddl-auto=validate"
//})
//@TestPropertySource(locations = "classpath:application-dev.properties")
class NewEscalationNewRequestIT {
  public static final String NEW_REQUEST = "NEW REQUEST";
  public static final String NEW_ESCALATION_WITH = "NEW ESCALATION WITH ";
  @Autowired
  EscalationnickService escalationNickService;

  @Autowired
  RequestnickService requestnickService;

  @Test
  void newEscalationNewRequestIT() {
    Requestnick newRequestnick = new Requestnick();
    newRequestnick.setName(NEW_REQUEST);

    Escalationnick escalationNick = new Escalationnick();
    escalationNick.setName(NEW_ESCALATION_WITH + newRequestnick.getName());
    escalationNick.setRequestnick(newRequestnick);

    Escalationnick saved = escalationNickService.save(escalationNick);
    Optional<Escalationnick> checkSaved = escalationNickService.findById(saved.getId());
    System.out.println("XXXXXXXXXXXXXXXXX");
    System.out.println("XXXXXXXXXXXXXXXXX");
    System.out.println("escalation: " + checkSaved.get().getName());
    System.out.println("request   : " + checkSaved.get().getRequestnick().getName());
    System.out.println("XXXXXXXXXXXXXXXXX");
    System.out.println("XXXXXXXXXXXXXXXXX");
  }

  @Test
  @Sql(scripts={"classpath:somevalues.sql"})
  void addSomeValuesIT() {
    Assertions.assertEquals("REQUEST 100", requestnickService.findByName("REQUEST 100").getName());
  }

  @Test
  @Sql(scripts={"classpath:someothervalues.sql"})
  void addSomeOtherValuesIT() {
    Assertions.assertNotEquals("REQUEST 100", requestnickService.findByName("REQUEST 101").getName());
  }

  @Test
  void shouldNotThrowExceptionBecauseDataWasPreloadedInMethodAboveIT() {
    Assertions.assertEquals("REQUEST 101", requestnickService.findByName("REQUEST 101").getName());
  }
  @Test
  void shouldThrowExceptionBecauseDataIsMissingIT() {
    Assertions.assertThrows(
        NullPointerException.class, () -> requestnickService.findByName("REQUEST 102").getName());
  }
}
