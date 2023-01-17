package com.tds.shortener.entities;

public class AccessDto {
    private Integer totalAccess;

    public AccessDto(Integer totalAccess) {
        this.totalAccess = totalAccess;
    }

    public AccessDto() {
    }

    public static AccessDto accessToAccessDto(Integer access) {
        return new AccessDto(access);
    }

    public Integer getTotalAccess() {
        return totalAccess;
    }

    public void setTotalAccess(Integer totalAccess) {
        this.totalAccess = totalAccess;
    }

    @Override
    public String toString() {
        return "AccessDto{" +
                "totalAccess=" + totalAccess +
                '}';
    }
}
