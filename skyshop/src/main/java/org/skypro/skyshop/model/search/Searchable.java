package org.skypro.skyshop.model.search;

import java.util.UUID;

public interface Searchable {
    String getSearchTerm();

    String getSearchableType();

    String getSearchableName();

    default String getStringRepresentation() {
        return getSearchableName() + getSearchableType();
    }

    public UUID getId();
}
