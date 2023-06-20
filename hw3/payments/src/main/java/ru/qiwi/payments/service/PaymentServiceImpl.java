package ru.qiwi.payments.service;

import org.springframework.stereotype.Service;
import ru.qiwi.payments.dataprovider.PaymentsDataProvider;
import ru.qiwi.payments.dto.Payment;
import ru.qiwi.payments.dto.TotalSum;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl {

    private PaymentsDataProvider paymentsDataProvider;

    public PaymentServiceImpl(PaymentsDataProvider paymentsDataProvider) {
        this.paymentsDataProvider = paymentsDataProvider;
    }

    // должен вернуть объект TotalSum, который содержит сумму всех списаний
    // и сумму всех пополнений для пользователя с personId
    public TotalSum getTotalSum(String personId) {
        double fromAccount = paymentsDataProvider.getPayments()
                .stream()
                .filter(payment -> payment.getFromAccount().equals(personId))
                .mapToDouble(Payment::getAmount)
                .sum();
        double toAccount = paymentsDataProvider.getPayments()
                .stream()
                .filter(payment -> payment.getToAccount().equals(personId))
                .mapToDouble(Payment::getAmount)
                .sum();
        return new TotalSum(fromAccount, toAccount);
    }

    // должен вернуть количество платежей, совершенных пользователем
    // фильтры на статус платежа и тип мерчанта
    public int getPaymentsCount(String personId, Payment.Status status, Payment.MerchantType merchantType) {
        return (int) paymentsDataProvider.getPayments()
                .stream()
                .filter(payment -> payment.getFromAccount().equals(personId) &&
                        payment.getStatus().equals(status) &&
                        payment.getMerchantType().equals(merchantType)
                )
                .count();
    }

    // все пополнения пользователя(сортировка по дате)
    public List<Payment> getAllReplenishments(String personId) {
        return paymentsDataProvider.getPayments()
                .stream()
                .filter(payment -> payment.getToAccount().equals(personId))
                .sorted(Comparator.comparing(Payment::getDate))
                .collect(Collectors.toList());
    }

    // все платежи пользователя за период(сортировка по дате)
    public List<Payment> getPayments(
            String personId,
            Payment.MerchantType merchantType,
            LocalDateTime dateFrom,
            LocalDateTime dateTill
    ) {
        return paymentsDataProvider.getPayments()
                .stream()
                .filter(payment -> payment.getFromAccount().equals(personId) || payment.getToAccount().equals(personId))
                .filter(payment -> payment.getMerchantType().equals(merchantType))
                .filter(payment -> payment.getDate().isAfter(dateFrom) && payment.getDate().isBefore(dateTill))
                .collect(Collectors.toList());
    }

    // NR(сумма комиссий) за период по мерчанту
    public double getNR(
            LocalDateTime dateFrom,
            LocalDateTime dateTill,
            Payment.MerchantType merchantType
    ) {
        return paymentsDataProvider.getPayments()
                .stream()
                .filter(payment -> payment.getMerchantType().equals(merchantType))
                .filter(payment -> payment.getDate().isAfter(dateFrom) && payment.getDate().isBefore(dateTill))
                .mapToDouble(Payment::getCommission)
                .sum();
    }

    // Оборот за период по мерчанту
    public double getTurnover(
            LocalDateTime dateFrom,
            LocalDateTime dateTill,
            Payment.MerchantType merchantType
    ) {
        return paymentsDataProvider.getPayments()
                .stream()
                .filter(payment -> payment.getMerchantType().equals(merchantType))
                .filter(payment -> payment.getDate().isAfter(dateFrom) && payment.getDate().isBefore(dateTill))
                .mapToDouble(Payment::getAmount)
                .sum();
    }

    // топ 10 пользователей по обороту(списания + пополнения) за период, сортированый список
    public List<String> getTopUsers(
            LocalDateTime dateFrom,
            LocalDateTime dateTill
    ) {
        return paymentsDataProvider.getPayments()
                .stream()
                // TODO
                ;
    }
}

// filter by date
// collect by getToAccount and getFromAccount
// Collectors.summingDouble
// Sorted
// Cut only top 10
// Collectors.mapping() ? by name?
