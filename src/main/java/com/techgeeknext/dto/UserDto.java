package com.techgeeknext.dto;

import com.techgeeknext.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserDto {

    int id;
    String userName;
    boolean isActive;
    List<Role> roles;
}
