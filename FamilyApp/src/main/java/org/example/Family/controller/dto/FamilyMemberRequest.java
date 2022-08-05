package org.example.Family.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FamilyMemberRequest {
    private String givenName;
    private String familyName;
    private int age;
}
