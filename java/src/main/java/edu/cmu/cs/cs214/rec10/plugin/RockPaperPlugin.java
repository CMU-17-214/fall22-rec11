package edu.cmu.cs.cs214.rec10.plugin;

public class RockPaperPlugin {
    private final String name;
    private final String link;

    public RockPaperPlugin(String name, String link){
        this.name = name;
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public String getLink() {
        return link;
    }
}
