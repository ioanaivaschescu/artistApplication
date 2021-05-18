package models;

public class ProductModel {

    private String size;
    private String materials;
    private String category;
    private String price;
    private String Description;


    public ProductModel() {

    }

    public ProductModel(String size, String materials, String category, String price, String Description) {


        this.size = size;
        this.materials = materials;
        this.category = category;
        this.price = price;
        this.Description = Description;


    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setMaterials(String materials) {
        this.materials = materials;
    }

    public String getMaterials() {
        return materials;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }


    @Override
    public int hashCode() {
        int result = size.hashCode();
        result = 31 * result + materials.hashCode();
        result = 31 * result + category.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + Description.hashCode();

        return result;
    }


    @Override
    public String toString() {
        return "Product{" +
                "size='" + size + '\'' +
                ", materials='" + materials + '\'' +
                ", category='" + category + '\'' +
                ", price='" + price + '\'' +
                ", Description='" + Description + '\'' +
                '}';
    }
}
