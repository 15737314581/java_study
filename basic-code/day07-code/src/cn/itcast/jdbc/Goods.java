package cn.itcast.jdbc;

public class Goods {
    private int id;
    private String name;
    private int cate_id;
    private int brand_id;
    private Double price;
    private byte is_show;
    private byte is_saleoff;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCate_id() {
        return cate_id;
    }

    public void setCate_id(int cate_id) {
        this.cate_id = cate_id;
    }

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public byte getIs_show() {
        return is_show;
    }

    public void setIs_show(byte is_show) {
        this.is_show = is_show;
    }

    public byte getIs_saleoff() {
        return is_saleoff;
    }

    public void setIs_saleoff(byte is_saleoff) {
        this.is_saleoff = is_saleoff;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cate_id=" + cate_id +
                ", brand_id=" + brand_id +
                ", price=" + price +
                ", is_show=" + is_show +
                ", is_saleoff=" + is_saleoff +
                '}';
    }
}
