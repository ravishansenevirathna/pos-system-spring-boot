package com.pos_system.dto.queryInterface;

import java.util.Date;

public interface OrderDetailsInterface {

    String getCustomerName();
    String getPhoneNumber();
    String getAddress();
    Date getDate();
    Double getTotal();
}
