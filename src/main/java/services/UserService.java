package services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.UserModel;
import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

public class UserService {

    public static List<UserModel> users;
    public static Path USERS_PATH = File.getPathToFile("config", "users.json");

    public static void loadUsers() throws IOException {

        if (!Files.exists(USERS_PATH)) {
            FileUtils.copyURLToFile(UserService.class.getClassLoader().getResource("users.json"), USERS_PATH.toFile());
        }

        ObjectMapper objectMapper = new ObjectMapper();

        users = objectMapper.readValue(USERS_PATH.toFile(), new TypeReference<List<UserModel>>() {
        });
    }

    public static boolean checkUserDoesNotAlreadyExist(String username) throws UsernameAlreadyExistsException {
        for (User user : users) {
            if (Objects.equals(username, user.getUsername()))
                throw new UsernameAlreadyExistsException(username);
            //return true;

        }
        return false;
    }

    public static void addUser(String username, String password, String firstName,String lastName,String phoneNumber,String address,String role) throws UsernameAlreadyExistsException {
        if(!checkUserDoesNotAlreadyExist(username)){
            users.add(new User(username,encodePassword(username, password),firstName,lastName,phoneNumber,address,role));
            persistUsers();
        }

    }


}
