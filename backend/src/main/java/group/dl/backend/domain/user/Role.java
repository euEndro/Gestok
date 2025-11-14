package group.dl.backend.domain.user;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public enum Role {

  ADMIN(List.of(
      new SimpleGrantedAuthority("ROLE_ADMIN"),
      new SimpleGrantedAuthority("PERM_STORE_READ"),
      new SimpleGrantedAuthority("PERM_STORE_WRITE"),
      new SimpleGrantedAuthority("PERM_USER_WRITE"),
      new SimpleGrantedAuthority("PERM_USER_READ"))),
  MANAGER(List.of(
      new SimpleGrantedAuthority("ROLE_MANAGER"),
      new SimpleGrantedAuthority("PERM_STORE_READ"),
      new SimpleGrantedAuthority("PERM_USER_READ"),
      new SimpleGrantedAuthority("PERM_USER_WRITE"))),

  USER(List.of(
      new SimpleGrantedAuthority("ROLE_USER"),
      new SimpleGrantedAuthority("PERM_STORE_READ")));

  private final List<GrantedAuthority> authorities;

  Role(List<GrantedAuthority> authorities) {
    this.authorities = authorities;
  }

  public List<GrantedAuthority> getAuthorities() {
    return authorities;
  }
}
