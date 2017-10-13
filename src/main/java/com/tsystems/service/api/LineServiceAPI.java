package com.tsystems.service.api;

import java.util.LinkedList;

public interface LineServiceAPI {

    LinkedList<String> getNameLines();

    void addLine(String line_str);
}
