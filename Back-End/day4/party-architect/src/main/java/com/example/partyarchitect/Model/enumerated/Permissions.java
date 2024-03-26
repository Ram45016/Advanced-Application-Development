package com.example.partyarchitect.Model.enumerated;
import java.util.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public enum Permissions {
    ADMIN_READ("ADMIN:read "),
    ADMIN_UPDATE(" ADMIN:write"),
    ADMIN_CREATE("ADMIN:create"),
    ADMIN_DELETE("ADMIN:delete"),
    USER_READ("USER:read "),
    USER_UPDATE(" USER:write"),
    USER_CREATE("USER:create"),
    USER_DELETE("USER:delete");

    @Getter
    private  String permission;
    Permissions(String permission) {
        this.permission = permission;
    }
}
