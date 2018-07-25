package com.power.saas.common;


public class BaseEntity {

    public String tenantCode; //租户

    public PageUtil pageUtil;

    public PageUtil getPageUtil() {
        return pageUtil;
    }

    public void setPageUtil(PageUtil pageUtil) {
        this.pageUtil = pageUtil;
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }
}