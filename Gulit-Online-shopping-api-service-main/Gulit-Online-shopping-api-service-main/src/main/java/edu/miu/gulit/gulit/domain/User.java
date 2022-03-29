package edu.miu.gulit.gulit.domain;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String username;
//    @NonNull
    private String firstName;
   // @NonNull
    private String lastName;
   // @NonNull
    @Email(regexp=".*@.*\\..*", message = "Email should be valid")
    private String email;
    @NonNull
    private String password;
  //  @NonNull
    private boolean isEnabled;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLES", joinColumns = {
            @JoinColumn(name = "USER_ID") }, inverseJoinColumns = {
            @JoinColumn(name = "ROLE_ID") })
    private Set<Role> roles;
    @OneToOne(mappedBy = "user")
    private Cart cart;
}
