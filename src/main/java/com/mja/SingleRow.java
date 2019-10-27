package com.mja;


import java.util.Objects;
import java.util.StringJoiner;

public class SingleRow{
    private Long id;
    private String state;
    private String areaName;
    private Long civilianLaborForce;
    private Long employed;
    private Long unemployed;

    public SingleRow(Long id, String state, String areaName, Long civilianLaborForce, Long employed, Long unemployed) {
        this.id = id;
        this.state = state;
        this.areaName = areaName;
        this.civilianLaborForce = civilianLaborForce;
        this.employed = employed;
        this.unemployed = unemployed;
    }

    public Long getId() {
        return id;
    }

    public String getState() {
        return state;
    }

    public String getAreaName() {
        return areaName;
    }

    public Long getCivilianLaborForce() {
        return civilianLaborForce;
    }

    public Long getEmployed() {
        return employed;
    }

    public Long getUnemployed() {
        return unemployed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SingleRow singleRow = (SingleRow) o;
        return Objects.equals(id, singleRow.id) &&
                Objects.equals(state, singleRow.state) &&
                Objects.equals(areaName, singleRow.areaName) &&
                Objects.equals(civilianLaborForce, singleRow.civilianLaborForce) &&
                Objects.equals(employed, singleRow.employed) &&
                Objects.equals(unemployed, singleRow.unemployed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, state, areaName, civilianLaborForce, employed, unemployed);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SingleRow.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("state='" + state + "'")
                .add("areaName='" + areaName + "'")
                .add("civilianLaborForce=" + civilianLaborForce)
                .add("employed=" + employed)
                .add("unemployed=" + unemployed)
                .toString();
    }
}

