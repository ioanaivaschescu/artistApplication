package services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import exceptions.CouldNotWriteUsersException;
import models.ProductModel;
import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class PurchaseService {




    public static List<ProductModel> products;
    public static Path PATH = File.getPathToFile("config", "purchase.json");


    public static void loadPURCHASE() throws IOException {

        if (!Files.exists(PATH)) {
            FileUtils.copyURLToFile(UserService.class.getClassLoader().getResource("purchase.json"), PATH.toFile());
        }

        ObjectMapper objectMapper = new ObjectMapper();

        products = objectMapper.readValue(PATH.toFile(), new TypeReference<List<ProductModel>>() {
        });
    }

    public static void addPURCHASE(String size, String materials, String category, String price, String Description){

        products.add(new ProductModel(size,materials,category, price,Description));
        persistPurchases();
    }



    private static void persistPurchases() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(PATH.toFile(), products);

        } catch (IOException e) {
            throw new CouldNotWriteUsersException();
        }
    }





}

