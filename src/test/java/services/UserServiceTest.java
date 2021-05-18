package services;

import exceptions.UsernameAlreadyExistsException;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;


import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotEquals;


class UserServiceTest {
    @BeforeAll
    public static void setupClass() throws IOException {

        File.FOLDER_NAME= ".test-artist-app";

    }

    @BeforeEach
    public void setUp() throws IOException {
        FileUtils.cleanDirectory(File.getPathToFile().toFile());
    }

    @Test
    public static void loadUsers() throws IOException{
        UserService.loadUsers();
        assertTrue(Files.exists(UserService.PATH));
    }

    @Test
    public void addUser() throws IOException, UsernameAlreadyExistsException {
        //int aux=UserService.getUsers().size();
        UserService.loadUsers();
        UserService.addUser("ok1","ok2","ok3","ok4","ok5");
        assertNotNull(UserService.users);
        //assertEquals(aux+1,UserService.getUsers().size());
    }
    @Test
    public static void encodePassword()
    {
        assertNotEquals("test for pass",UserService.encodePassword("usr1","pass1"));
    }


}