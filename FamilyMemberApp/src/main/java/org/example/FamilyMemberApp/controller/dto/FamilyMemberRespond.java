package org.example.FamilyMemberApp.controller.dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FamilyMemberRespond {

    private Long id;
    private Long familyId;
    private String familyName;
    private String givenName;
}
