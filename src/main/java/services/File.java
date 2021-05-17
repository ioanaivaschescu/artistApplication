package services;

import java.nio.file.Path;
import java.nio.file.Paths;

public class File {

    public static  String FOLDER_NAME = ".ARTISTAPP";


    private static final String USER_FOLDER = System.getProperty("user.home");


    public static final Path APPLICATION_HOME_PATH = Paths.get(USER_FOLDER, FOLDER_NAME);


    public static Path getPathToFile(String... path) {
        return APPLICATION_HOME_PATH.resolve(Paths.get(".", path));
    }








}
