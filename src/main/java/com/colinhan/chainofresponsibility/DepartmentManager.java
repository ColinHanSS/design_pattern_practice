package com.colinhan.chainofresponsibility;

/**
 * 部门经理处理
 */
public class DepartmentManager extends Handler {
    @Override
    public String handleFeeRequest(String user, double fee) {
        String result = null;
        if (fee < 1000) {
            if ("xiaoming".equals(user)) {
                result = "部门经理同意 " + user + " 申请的聚餐费用 " + fee;
            } else {
                result = "部门经理不同意 " + user + " 申请的聚餐费用 " + fee;
            }
        } else {
            if (nextHandler != null) {
                result = nextHandler.handleFeeRequest(user, fee);
            }
        }
        return result;
    }
}
