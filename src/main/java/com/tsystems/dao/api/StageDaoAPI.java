package com.tsystems.dao.api;

import com.tsystems.entity.Line;
import com.tsystems.entity.Stage;

import java.util.List;

public interface StageDaoAPI {

    void saveStage(Stage stage);
    List getToStageByName(String from);
    List getFromStageByName(String from);
    Stage getStageByNameAndLine(String to, Line line);
    Stage getByLineAndNumber(Line line, int num);
    List getStageByLineId(Line line_id);
}
