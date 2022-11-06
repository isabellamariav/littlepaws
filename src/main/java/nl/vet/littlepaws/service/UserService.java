//package nl.vet.littlepaws.service;
//
//import nl.vet.littlepaws.dto.UserDto;
//import nl.vet.littlepaws.exception.UsernameNotFoundException;
//import nl.vet.littlepaws.model.User;
//import nl.vet.littlepaws.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class UserService implements CRUDInterface<User> {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    public UserService() {
//    }
//
//    @Override
//    public Optional<User> create(User dto) {
//        return Optional.of(userRepository.save(dto));
//    }
//
//    @Override
//    public Optional<User> read(Long id) {
//        return userRepository.findById(id);
//    }
//
//    @Override
//    public Optional<User> update(User updateUser, Long id) {
//        User user = userRepository.findById(id).get();
//        user.setAuthorities(updateUser.getAuthorities());
//        return Optional.of(userRepository.save(updateUser));
//    }
//
//    @Override
//    public void delete(long id) {
//        userRepository.deleteById(id);
//    }
//
//    @Override
//    public Iterable<User> getAll() {
//        return userRepository.findAll();
//    }
//}