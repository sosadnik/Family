package org.example.Family.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class FamilyMember {
    private String givenName;
    private String familyName;
    private int age;
}
