package org.example.Family.controller.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class FamilyMemberRespond {

    private Long id;
    private Long familyId;
    private String givenName;
    private String familyName;
}
