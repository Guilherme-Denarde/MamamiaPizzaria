//package app.service;
//
//import app.dto.UserDTO;
//import app.entity.User;
//import app.repository.UserRepository;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Lazy;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class UserService implements UserDetailsService {
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private ModelMapper modelMapper;
//
//    public UserDTO createUser(UserDTO userDTO) {
//        User user = modelMapper.map(userDTO, User.class);
//        User savedUser = userRepository.save(user);
//        return modelMapper.map(savedUser, UserDTO.class);
//    }
//
//    public UserDTO getUserById(Long id) {
//        User user = userRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
//        return modelMapper.map(user, UserDTO.class);
//    }
//
//    public List<UserDTO> getAllUsers() {
//        List<User> users = userRepository.findAll();
//        return users.stream()
//                .map(user -> modelMapper.map(user, UserDTO.class))
//                .collect(Collectors.toList());
//    }
//
//    public UserDTO updateUser(Long id, UserDTO userDTO) {
//        User existingUser = userRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
//
//        // Update the existing user details
//        modelMapper.map(userDTO, existingUser);
//        User updatedUser = userRepository.save(existingUser);
//        return modelMapper.map(updatedUser, UserDTO.class);
//    }
//
//    public void deleteUser(Long id) {
//        userRepository.deleteById(id);
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        // Implement method logic
//        // Example:
//        User user = userRepository.findByEmail(username)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
//        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
//    }
//}
