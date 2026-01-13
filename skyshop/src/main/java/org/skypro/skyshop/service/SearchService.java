package org.skypro.skyshop.service;

import org.skypro.skyshop.model.search.SearchResult;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class SearchService {
    private final StorageService storageService;

    public SearchService(StorageService storageService) {
        this.storageService = storageService;
    }

    public List<SearchResult> search(String searchWord) {
        return storageService.getSearchables().stream()
                .filter(s -> s.getSearchTerm().toLowerCase().contains(searchWord.toLowerCase()))
                .map(SearchResult::fromSearchable)
                .toList();
    }
}
