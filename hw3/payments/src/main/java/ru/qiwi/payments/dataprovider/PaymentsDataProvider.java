package ru.qiwi.payments.dataprovider;

import org.springframework.stereotype.Component;
import ru.qiwi.payments.dto.Payment;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

@Component
public class PaymentsDataProvider {

    public List<Payment> getPayments() {
        return Arrays.asList(
                new Payment(
                        0,
                        LocalDateTime.of(2023, Month.JUNE, 1, 19, 0, 0),
                        10,
                        1,
                        "1",
                        "2",
                        Payment.MerchantType.SHOP,
                        Payment.Status.OK
                ),
                new Payment(
                        1,
                        LocalDateTime.of(2023, Month.JUNE, 1, 20, 0, 0),
                        10,
                        1,
                        "1",
                        "2",
                        Payment.MerchantType.SHOP,
                        Payment.Status.OK
                ),
                new Payment(
                        2,
                        LocalDateTime.of(2023, Month.JUNE, 1, 19, 0, 0),
                        10,
                        1,
                        "2",
                        "1",
                        Payment.MerchantType.SHOP,
                        Payment.Status.OK
                ),
                new Payment(
                        3,
                        LocalDateTime.of(2023, Month.JUNE, 2, 19, 0, 0),
                        120,
                        1,
                        "1",
                        "2",
                        Payment.MerchantType.P2P,
                        Payment.Status.OK
                ),
                new Payment(
                        4,
                        LocalDateTime.of(2023, Month.MARCH, 1, 19, 0, 0),
                        10,
                        1,
                        "3",
                        "4",
                        Payment.MerchantType.SHOP,
                        Payment.Status.OK
                ),
                new Payment(
                        0,
                        LocalDateTime.of(2023, Month.JUNE, 1, 19, 0, 0),
                        10,
                        1,
                        "1",
                        "2",
                        Payment.MerchantType.SHOP,
                        Payment.Status.IN_PROGRESS
                )
        );
    }
}
