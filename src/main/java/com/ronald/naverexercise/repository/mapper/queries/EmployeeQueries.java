package com.ronald.naverexercise.repository.mapper.queries;

public final class EmployeeQueries {
    public static final String GET_EMPLOYEE_BY_ID
            = "SELECT * FROM EMPLOYEE " +
            "WHERE employee_id = #{id}";
}
