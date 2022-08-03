package org.example.Family.client;

import lombok.RequiredArgsConstructor;
import org.example.Family.model.FamilyMember;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class ClientFamilyMember {

    private final RestTemplate restTemplate;

    public void createFamilyMember(FamilyMember familyMember){
        restTemplate.postForLocation(
                "http://localhost:8081/createFamilyMember",
                familyMember
        );
    }

}
