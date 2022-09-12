package my.app.site.service;

import my.app.site.models.PawnTicket;
import my.app.site.repo.PawnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class PawnServImpl implements PawnService {

    @Autowired
    private PawnRepository pawnRepository;

    @Override
    public void create(PawnTicket pawnTicket) {
        Double loanAmount = pawnTicket.getLoanAmount();
        Integer periodDays = pawnTicket.getPeriodDays();
        Double totalAmount = loanAmount + (loanAmount * 0.005 * periodDays);
        pawnTicket.setTotalAmount(totalAmount);
        pawnRepository.save(pawnTicket);
    }

    @Override
    public List<PawnTicket> readAll() {
        return new ArrayList<>((Collection) pawnRepository.findAll());
    }

    @Override
    public PawnTicket read(int id) {
        return pawnRepository.findById(id).get();
    }

    @Override
    public boolean update(int id, PawnTicket pawnTicket) {
        String depositTitle = pawnTicket.getDepositTitle();
        String pawnCondition = pawnTicket.getPawnCondition();
        Double valuation = pawnTicket.getValuation();
        String clientFio = pawnTicket.getClientFio();
        String clientPhone = pawnTicket.getClientPhone();
        Double loanAmount = pawnTicket.getLoanAmount();
        Integer periodDays = pawnTicket.getPeriodDays();
        Double totalAmount = loanAmount + (loanAmount * 0.005 * periodDays);

        var pawnTicket1 = pawnRepository.findById(id).get();
        if (pawnTicket1 != null){
            pawnTicket1.setDepositTitle(depositTitle);
            pawnTicket1.setPawnCondition(pawnCondition);
            pawnTicket1.setValuation(valuation);
            pawnTicket1.setClientFio(clientFio);
            pawnTicket1.setClientPhone(clientPhone);
            pawnTicket1.setLoanAmount(loanAmount);
            pawnTicket1.setPeriodDays(periodDays);
            pawnTicket1.setTotalAmount(totalAmount);

            pawnRepository.save(pawnTicket1);
            return true;
        }
        return false;
    }


    @Override
    public boolean delete(int id) {
        var pawnTicket = pawnRepository.findById(id).get();
        if (pawnTicket != null) {
            pawnRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
