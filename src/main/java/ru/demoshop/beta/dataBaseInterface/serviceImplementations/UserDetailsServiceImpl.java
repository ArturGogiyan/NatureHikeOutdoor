package ru.demoshop.beta.dataBaseInterface.serviceImplementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.demoshop.beta.dataBaseInterface.DAO.AppUsersDAO;
import ru.demoshop.beta.dataBaseInterface.DAO.PasswordDAO;
import ru.demoshop.beta.dataBaseInterface.DAO.UserRoleDAO;
import ru.demoshop.beta.dataBaseInterface.entities.AppUsers;
import ru.demoshop.beta.dataBaseInterface.entities.UserRole;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AppUsersDAO appUserDAO;

    @Autowired
    private UserRoleDAO appRoleDAO;

    @Autowired
    private PasswordDAO passwords;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        AppUsers appUser = this.appUserDAO.findByEmail(userName);

        if (appUser == null) {
            System.out.println("User not found! " + userName);
            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
        }

        System.out.println("Found User: " + appUser);

        // [ROLE_USER, ROLE_ADMIN,..]
        List<UserRole> roleNames = this.appRoleDAO.findAllByUserId(appUser.getId());

        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if (roleNames != null) {
            for (UserRole role : roleNames) {
                // ROLE_USER, ROLE_ADMIN,..
                GrantedAuthority authority = new SimpleGrantedAuthority(role.getRoleName());
                grantList.add(authority);
            }
        }

        UserDetails userDetails = (UserDetails) new User(appUser.getEmail(), //
                passwords.findByUserId(appUser.getId()).getPassword(), grantList);

        return userDetails;
    }

}
