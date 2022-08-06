package org.example.FamilyMemberApp.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class FamilyMemberRequest {

    private Long familyId;
    private String givenName;
    private String familyName;
}
