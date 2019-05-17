package model;

public class HeroModel {
    private String image;
    private String id;
    private String name;
    private String desc;

    public HeroModel(String image, String id, String name, String desc) {
        this.image = image;
        this.id = id;
        this.name = name;
        this.desc = desc;
    }

    public String getImage() {
        return image;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}
