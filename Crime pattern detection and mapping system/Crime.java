package model;

public class Crime {
    private String id;
    private String type;
    private String location;
    private String date;
    private String description;

    public Crime(String id, String type, String location, String date, String description) {
        this.id = id;
        this.type = type;
        this.location = location;
        this.date = date;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("Crime ID: %s\n Type: %s\n Location: %s\n Date: %s\n Description: %s\n",
                id, type, location, date, description);
    }
}
