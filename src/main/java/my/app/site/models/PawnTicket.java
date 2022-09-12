package my.app.site.models;

import org.hibernate.annotations.CreationTimestamp;
//import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

//при первом подключении к пустой БД создается таблица deposit для хранения залоговых билетов
@Entity
@Table(name="deposit")
public class PawnTicket {
    @Id
    @GeneratedValue
    private Integer id;//уникальный номер залогового билета
    private String depositTitle;//описание залогового имущества (в т.ч. свойства, вес, количество)
    private String pawnCondition;//состояние залогового имущества
    private Double valuation;//оценкочная стоимость, определяемая принимающим экспертом
    private String clientFio;//ФИО клиента, принесшего залоговое имущество
    private String clientPhone;//номер телефона клиента, принесшего залоговое имущество
    @CreationTimestamp
    private Timestamp date;//дата формирования залогового билета (ВЫСТАВЛЯЕТСЯ АВТОМАТИЧЕСКИ, в PostMan не указывается)
    private Double loanAmount;//сумма, предоставляемая за залоговое имущество
    private Integer periodDays;//количество дней, на которое берется денежная сумма взамен на залоговое имущество
    private Double totalAmount;//сумма к возврату с начисленными процентами (СЧИТАЕТСЯ АВТОМАТИЧЕСКИ, в PostMan не указывается)


    public PawnTicket(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepositTitle() {
        return depositTitle;
    }

    public void setDepositTitle(String depositTitle) {
        this.depositTitle = depositTitle;
    }

    public String getPawnCondition() {
        return pawnCondition;
    }

    public void setPawnCondition(String pawnCondition) {
        this.pawnCondition = pawnCondition;
    }

    public Double getValuation() {
        return valuation;
    }

    public void setValuation(Double valuation) {
        this.valuation = valuation;
    }

    public String getClientFio() {
        return clientFio;
    }

    public void setClientFio(String clientFio) {
        this.clientFio = clientFio;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Integer getPeriodDays() {
        return periodDays;
    }

    public void setPeriodDays(Integer periodDays) {
        this.periodDays = periodDays;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public PawnTicket(Integer id, String depositTitle, String pawnCondition, Double valuation, String clientFio, String clientPhone, Timestamp date, Double loanAmount, Integer periodDays, Double totalAmount) {
        this.id = id;
        this.depositTitle = depositTitle;
        this.pawnCondition = pawnCondition;
        this.valuation = valuation;
        this.clientFio = clientFio;
        this.clientPhone = clientPhone;
        this.date = date;
        this.loanAmount = loanAmount;
        this.periodDays = periodDays;
        this.totalAmount = totalAmount;
    }
}
