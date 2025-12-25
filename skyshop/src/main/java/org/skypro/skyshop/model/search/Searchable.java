package org.skypro.skyshop.model.search;

public interface Searchable {
    String getSearchTerm();

    String getSearchableType();

    String getSearchableName();

    default String getStringRepresentation() {
        return getSearchableName() + getSearchableType();
    }
}
