package org.example.Family.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class FamilyMemberRequest {
    private String givenName;
    private String familyName;
    private int age;
}
