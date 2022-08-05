package org.example.FamilyMemberApp.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FamilyMemberRequest {

    private Long familyId;
    private String givenName;
    private String familyName;
}
