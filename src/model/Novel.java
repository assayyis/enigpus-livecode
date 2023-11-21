package model;

public class Novel extends Book{
    private String id;
    private String title;
    private String publisher;
    private Integer publishedYear;
    private String author;

    public Novel() {
        super();
    }

    public Novel(String id, String title, String publisher, Integer publishedYear, String author) {
        super();
        this.id = id;
        this.title = title;
        this.publisher = publisher;
        this.publishedYear = publishedYear;
        this.author = author;
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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(Integer publishedYear) {
        this.publishedYear = publishedYear;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Novel{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", publisher='" + publisher + '\'' +
                ", publishedYear=" + publishedYear +
                ", author='" + author + '\'' +
                '}';
    }
}
