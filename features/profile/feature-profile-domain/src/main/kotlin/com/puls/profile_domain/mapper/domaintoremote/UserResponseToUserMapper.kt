package com.puls.profile_domain.mapper.domaintoremote

import com.puls.profile_domain.data.model.response.UserResponse
import com.puls.profile_domain.domain.model.response.User
import javax.inject.Inject

internal class UserResponseToUserMapper @Inject constructor() :
    (UserResponse) -> User {

    override fun invoke(user: UserResponse) = User(
        id = user.id,
        fullName = user.fullName,
        firstName = user.firstName,
        lastName = user.lastName,
        gender = user.gender,
        birthday = user.birthday,
        age = user.age,
        avatar = user.avatar,
        address = user.address,
        zip = user.zip,
        state = user.state,
        phone = user.phone,
        email = user.email,
        twitter = user.twitter,
        ssn = user.ssn,
    )
}