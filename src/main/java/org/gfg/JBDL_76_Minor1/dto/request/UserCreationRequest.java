package org.gfg.JBDL_76_Minor1.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.gfg.JBDL_76_Minor1.model.User;
import org.gfg.JBDL_76_Minor1.enums.UserStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserCreationRequest {
    private String userName;

    @NotBlank(message = "user email must not be blank")
    private String userEmail;

    private String userAddress;

    private String userPhone;

    private String password;

    public User toUser() {

        return User.
                builder().
                name(this.userName).
                email(this.userEmail).
                phoneNo(this.userPhone).
                address(this.userAddress).
                userStatus(UserStatus.ACTIVE).
                build();
    }
}
