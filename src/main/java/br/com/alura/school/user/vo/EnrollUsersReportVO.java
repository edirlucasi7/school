package br.com.alura.school.user.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EnrollUsersReportVO {

    @JsonProperty("email")
    private String userEmail;

    @JsonProperty("amount_enroll")
    private Long amountEnroll;

    public EnrollUsersReportVO(String userEmail, Long amountEnroll) {
        this.userEmail = userEmail;
        this.amountEnroll = amountEnroll;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public Long getAmountEnroll() {
        return amountEnroll;
    }
}
