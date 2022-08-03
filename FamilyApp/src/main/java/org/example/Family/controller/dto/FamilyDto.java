package org.example.Family.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;


import java.util.List;

@AllArgsConstructor
@Getter
public class FamilyDto {

    private String familyName;
    private int nrOfInfants;
    private int nrOfChildren;
    private int nrOfAdults;
    private List<FamilyMemberDto> familyMembers;
}
