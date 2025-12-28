package org.skypro.skyshop.model.article;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;

import java.util.Objects;
import java.util.UUID;

public final class Article implements Searchable {
    String title;
    String text;
    private final UUID id;

    @Override
    public UUID getId() {
        return id;
    }

    public Article(UUID id, String name, String text) {
        this.id = id;
        this.title = name;
        this.text = text;
    }

    @Override
    public String toString() {
        return title + "\n" + text;
    }

    @JsonIgnore
    @Override
    public String getSearchTerm() {
        return title + text;
    }

    @JsonIgnore
    @Override
    public String getSearchableType() {
        return "ARTICLE";
    }

    @Override
    public String getSearchableName() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article)) return false;
        Article article = (Article) o;
        return Objects.equals(title, article.title);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(title);
    }
}
