package services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import exceptions.CouldNotWriteUsersException;
import exceptions.UsernameAlreadyExistsException;
import models.ProductModel;
import models.UserModel;
import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ProductService {




    public static List<ProductModel> products;
    public static Path PATH = File.getPathToFile("config", "products.json");


    public static void loadPRODUCTS() throws IOException {

        if (!Files.exists(PATH)) {
            FileUtils.copyURLToFile(UserService.class.getClassLoader().getResource("products.json"), PATH.toFile());
        }

        ObjectMapper objectMapper = new ObjectMapper();

       products = objectMapper.readValue(PATH.toFile(), new TypeReference<List<ProductModel>>() {
        });
    }

    public static void addPRODUCT(String size, String materials, String category, String price, String Description) throws UsernameAlreadyExistsException {

            products.add(new ProductModel(size,materials,category, price,Description));
            persistUsers();
        }



    private static void persistUsers() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(PATH.toFile(), products);

        } catch (IOException e) {
            throw new CouldNotWriteUsersException();
        }
    }





}

