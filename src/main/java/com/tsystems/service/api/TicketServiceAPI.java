package com.tsystems.service.api;

import com.tsystems.bean.UserBean;
import com.tsystems.dto.TicketCarDTO;
import com.tsystems.dto.TicketDTO;

import java.util.LinkedList;

public interface TicketServiceAPI {

    boolean buyTicket(UserBean userBean, String id, String numSit);

    LinkedList<TicketDTO> getTicket(String email);

    LinkedList<TicketCarDTO> getListTicket(String id);
}
