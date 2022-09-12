package my.app.site.service;

import my.app.site.models.PawnTicket;

import java.util.List;

public interface PawnService {

    void create(PawnTicket pawnTicket);

    List<PawnTicket>readAll();

    PawnTicket read(int id);

    boolean update(int id, PawnTicket pawnTicket);

    boolean delete(int id);

}
