package com.cjoa.wms.util;
@FunctionalInterface
public interface DateRangeAction {
    void execute(String startDate, String endDate);
}
