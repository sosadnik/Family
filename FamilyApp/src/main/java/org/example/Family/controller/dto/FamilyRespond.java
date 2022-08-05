package org.example.Family.controller.dto;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class FamilyRespond {

    private Long id;
    private String familyName;
    private int nrOfInfants;
    private int nrOfChildren;
    private int nrOfAdults;
    private List<FamilyMemberRespond> familyMemberList;
}
