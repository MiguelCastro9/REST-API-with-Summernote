package com.summernote.service;

import com.summernote.dto.UserDTO;
import com.summernote.model.User;
import com.summernote.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Miguel Castro
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO convertEntityToDTO(User user) {

        UserDTO dto = new UserDTO();

        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setDateNow(user.getDateNow());
        dto.setProfission(user.getProfission());
        dto.setBiography(user.getBiography());

        return dto;
    }

    public List<UserDTO> getAllUsersDTO() {

        return userRepository.findAll()
                .stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }
}
