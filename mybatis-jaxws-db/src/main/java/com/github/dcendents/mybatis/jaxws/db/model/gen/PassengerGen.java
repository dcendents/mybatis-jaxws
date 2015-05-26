package com.github.dcendents.mybatis.jaxws.db.model.gen;

import com.github.dcendents.mybatis.jaxws.api.complex.Passenger;
import com.github.dcendents.mybatis.jaxws.db.IdTable;
import java.io.Serializable;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public abstract class PassengerGen extends IdTable implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table public.passenger
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the wrapped object.
     *
     * @mbggenerated
     */
    protected Passenger passenger = new Passenger();

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.passenger.first_name
     *
     * @return the value of public.passenger.first_name
     *
     * @mbggenerated
     */
    public String getFirstName() {
        return this.passenger.getFirstName();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.passenger.first_name
     *
     * @param firstName the value for public.passenger.first_name
     *
     * @mbggenerated
     */
    public void setFirstName(String firstName) {
        this.passenger.setFirstName(firstName);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.passenger.last_name
     *
     * @return the value of public.passenger.last_name
     *
     * @mbggenerated
     */
    public String getLastName() {
        return this.passenger.getLastName();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.passenger.last_name
     *
     * @param lastName the value for public.passenger.last_name
     *
     * @mbggenerated
     */
    public void setLastName(String lastName) {
        this.passenger.setLastName(lastName);
    }
}