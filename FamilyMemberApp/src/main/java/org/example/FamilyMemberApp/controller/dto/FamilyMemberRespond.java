package org.example.FamilyMemberApp.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class FamilyMemberRespond {

    private Long id;
    private Long familyId;
    private String givenName;
    private String familyName;
}
