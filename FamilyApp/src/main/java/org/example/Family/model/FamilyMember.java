package org.example.Family.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class FamilyMember {

    private Long familyId;
    private String givenName;
    private String familyName;

}
