package org.example.Family.controller.dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FamilyMemberRespond {

    private Long id;
    private Long familyId;
    private String givenName;
    private String familyName;
}
