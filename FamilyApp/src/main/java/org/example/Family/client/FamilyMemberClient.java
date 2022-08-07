package org.example.Family.client;

import lombok.RequiredArgsConstructor;
import org.example.Family.controller.dto.FamilyMemberRespond;
import org.example.Family.model.FamilyMember;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class FamilyMemberClient {

    private final RestTemplate restTemplate;

    public void createFamilyMember(FamilyMember familyMember) {
        restTemplate.postForLocation(
                "http://familymemberapp:8081/createFamilyMember",
                familyMember
        );
    }

    public List<FamilyMemberRespond> getFamilyMemberList(Long familyId) {
        ResponseEntity<FamilyMemberRespond[]> responseEntity = restTemplate.getForEntity(
                "http://familymemberapp:8081/getFamilyMember?familyId="+ familyId,
                FamilyMemberRespond[].class
        );
        return Arrays.asList(Objects.requireNonNull(responseEntity.getBody()));
    }

}
