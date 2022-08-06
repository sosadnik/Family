package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("should create famili member")

    request {
        url "/createFamilyMember"
        method POST()
        body([
            familyId: 1,
            familyName: "Nowak",
            givenName: "Artur"
        ])
        headers {
            contentType('application/json')
        }
    }

    response {
        status(200)
        headers {
            contentType('application/json')
        }
    }
}