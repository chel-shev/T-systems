package com.tsystems.dao.api;

import com.tsystems.entity.Line;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface LineDaoAPI {


    boolean saveLine(Line line);

    Line getLineByName(String name);

    List getAllLines();

    long getLastNumber();
}