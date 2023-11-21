package model;

import utils.Period;

public class Magazine extends Book {

    private String id;
    private String title;
    private Period publishedPeriod;
    private Integer publishedYear;

    public Magazine() {
        super();
    }

    public Magazine(String id, String title, Period publishedPeriod, Integer publishedYear) {
        super();
        this.id = id;
        this.title = title;
        this.publishedPeriod = publishedPeriod;
        this.publishedYear = publishedYear;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Period getPublishedPeriod() {
        return publishedPeriod;
    }

    public void setPublishedPeriod(Period publishedPeriod) {
        this.publishedPeriod = publishedPeriod;
    }

    public Integer getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(Integer publishedYear) {
        this.publishedYear = publishedYear;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", publishedPeriod=" + publishedPeriod +
                ", publishedYear=" + publishedYear +
                '}';
    }
}
