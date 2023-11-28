//package app.entity;
//
//import jakarta.persistence.*;
//import lombok.Data;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//
//import java.util.*;
//
//@Entity
//@Data
//@Table(name = "\"user\"")
//public class User extends AbstractEntity {
//    @Column
//    private String name;
//    @Column
//    private String email;
//    @Column
//    private String password;
//    @Column
//    private String phone;
//    @Column(name = "profile_picture")
//    private String profilePicture;
//    @Column
//    private String cpf;
//    @Temporal(TemporalType.DATE)
//    @Column(name = "date_of_birth")
//    private Date dateOfBirth;
//    @ManyToOne
//    @JoinColumn(name = "role_id")
//    private Role role;
//    @OneToMany(mappedBy = "user")
//    private Set<Address> addresses;
//    @OneToMany(mappedBy = "user")
//    private Set<Order> orders;
//    @OneToMany(mappedBy = "user")
//    private Set<Card> cards;
//
//    @OneToMany(mappedBy = "user")
//    private Set<Review> reviews;
//
////    @Override
////    public Collection<? extends GrantedAuthority> getAuthorities() {
////        List<GrantedAuthority> authorities = new ArrayList<>();
////        authorities.add(new SimpleGrantedAuthority(this.role));
////        return authorities;
////    }
//
//}