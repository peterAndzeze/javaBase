package com.customer.test.disruptor;

import com.customer.thread.disruptor.datatype.DataTypePattern;

import java.io.Serializable;

public class PayOrder implements DataTypePattern, Serializable {
    private static final long serialVersionUID = -5252254643047876934L;

    private String name;
    private String amt;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmt() {
        return amt;
    }

    public void setAmt(String amt) {
        this.amt = amt;
    }

    /**
     * 订阅的数据类型
     * @return
     */
    @Override
    public DataType getDataType() {
        return DataType.PAY_ORDER;
    }
}
