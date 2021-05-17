package services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import exceptions.CouldNotWriteUsersException;
import exceptions.UsernameAlreadyExistsException;
import models.UserModel;
import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Objects;

public class UserService {

    public static List<UserModel> users;
    public static Path PATH = File.getPathToFile("config", "users.json");

    public static void loadUsers() throws IOException {

        if (!Files.exists(PATH)) {
            FileUtils.copyURLToFile(UserService.class.getClassLoader().getResource("users.json"), PATH.toFile());
        }

        ObjectMapper objectMapper = new ObjectMapper();

        users = objectMapper.readValue(PATH.toFile(), new TypeReference<List<UserModel>>() {
        });
    }

    public static boolean verifyIfThereExistsThisUsername(String username) throws UsernameAlreadyExistsException {
        for (UserModel user : users) {
            if (Objects.equals(username, user.getUsername()))
                throw new UsernameAlreadyExistsException(username);

        }
        return false;
    }

    public static void addUser(String username, String password, String firstName,String lastName,String role) throws UsernameAlreadyExistsException {
        if(!verifyIfThereExistsThisUsername(username)){
            users.add(new UserModel(username,encodePassword(username, password),firstName,lastName,role));
            persistUsers();
        }

    }


    private static void persistUsers() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(PATH.toFile(), users);

        } catch (IOException e) {
            throw new CouldNotWriteUsersException();
        }
    }



    public static String encodePassword(String salt, String password) {
        MessageDigest md = getMessageDigest();
        md.update(salt.getBytes(StandardCharsets.UTF_8));

        byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));


        return new String(hashedPassword, StandardCharsets.UTF_8)
                .replace("\"", "");
    }

    private static MessageDigest getMessageDigest() {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-512 does not exist!");
        }
        return md;
    }




}
