package com.example.partyarchitect.auth;

import com.example.partyarchitect.Model.enumerated.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

  private String name;
  private String email;
  private String pwd;
  private Role role;
}