import org.example.Family.controller.dto.FamilyMemberRespond;
import org.example.Family.model.FamilyMember;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.cloud.contract.stubrunner.junit.StubRunnerExtension;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContractTest {

    private RestTemplate restTemplate;

    @BeforeEach
    public void setup() {
        restTemplate = new RestTemplate();
    }

    @RegisterExtension
    public StubRunnerExtension stubRunner = new StubRunnerExtension()
            .downloadStub("org.example", "FamilyMemberApp", "1.0-SNAPSHOT", "stubs")
            .withPort(8100)
            .stubsMode(StubRunnerProperties.StubsMode.LOCAL);

    @Test
    void createFamilyMember_shouldReturnOk() {
        FamilyMember member = new FamilyMember(1L, "Artur", "Nowak");

        ResponseEntity<HttpStatus> httpStatusResponseEntity = restTemplate.postForEntity(
                "http://localhost:8100/createFamilyMember",
                member,
                HttpStatus.class
        );

        assertEquals(httpStatusResponseEntity.getBody(), httpStatusResponseEntity.getBody());
    }

    @Test
    void getFamilyMemberList_shouldReturnCorrectList() {
        long familyId = 2L;
        List<FamilyMemberRespond> expected = new ArrayList<>();
        expected.add(new FamilyMemberRespond(1L, 2L, "Artur", "Nowak"));
        expected.add(new FamilyMemberRespond(2L, 2L, "Agnieszka", "Nowak"));

        ResponseEntity<FamilyMemberRespond[]> forEntity = restTemplate.getForEntity(
                "http://localhost:8100/getFamilyMember?familyId=" + familyId,
                FamilyMemberRespond[].class
        );

        assertEquals(expected, Arrays.asList(Objects.requireNonNull(forEntity.getBody())));
    }
}
