package cn.itcast.domain;

public class Goods {
    private Integer id;
    private String name;
    private Integer cate_id;
    private Integer brand_id;
    private Double price;
    private Integer is_show;
    private Integer is_saleoff;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCate_id() {
        return cate_id;
    }

    public void setCate_id(Integer cate_id) {
        this.cate_id = cate_id;
    }

    public Integer getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(Integer brand_id) {
        this.brand_id = brand_id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getIs_show() {
        return is_show;
    }

    public void setIs_show(Integer is_show) {
        this.is_show = is_show;
    }

    public Integer getIs_saleoff() {
        return is_saleoff;
    }

    public void setIs_saleoff(Integer is_saleoff) {
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
