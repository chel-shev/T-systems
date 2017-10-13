package com.tsystems.service.api;

import com.tsystems.dto.SearchDTO;

import java.util.LinkedList;

public interface SearchServiceAPI {

    LinkedList<SearchDTO> getResultSearch(String from, String to, String date_from, String date_to);
}