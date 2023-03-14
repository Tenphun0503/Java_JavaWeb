/**
 * Created a table tb_brand
 * Use JDBC to control and update the table
 *
 */
package myjava.practices.mybatis;

public class Brand {
    private final Integer id;
    private final String brandName;
    private final String companyName;
    private final Integer ordered;
    private final String description;
    private final Integer status;

    // Use alt+insert to generate constructor
    public Brand(Integer id, String brandName, String companyName, Integer ordered, String description, Integer status) {
        this.id = id;
        this.brandName = brandName;
        this.companyName = companyName;
        this.ordered = ordered;
        this.description = description;
        this.status = status;
    }

    @Override
    public String toString() {
        return "JDBCBrand{" +
                "id=" + id +
                ", brandName='" + brandName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", ordered=" + ordered +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
