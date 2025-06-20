public class Movie {
    private String name;
    private int duration; // in minutes

    public Movie(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public void showDetails() {
        System.out.println("🎥 Movie: " + name + " (" + duration + " mins)");
    }
}

