package org.example.FamilyMemberApp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Table
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FamilyMember {

    public FamilyMember(Long familyId, String familyName, String givenName) {
        this.familyId = familyId;
        this.familyName = familyName;
        this.givenName = givenName;
    }

    @Id
    @SequenceGenerator(
            name = "id_sequence",
            sequenceName = "id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "id_sequence"
    )
    private Long id;
    private Long familyId;
    private String familyName;
    private String givenName;
}
