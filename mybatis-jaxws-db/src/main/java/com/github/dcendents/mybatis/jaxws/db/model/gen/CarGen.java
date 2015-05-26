package com.github.dcendents.mybatis.jaxws.db.model.gen;

import com.github.dcendents.mybatis.jaxws.api.complex.Car;
import com.github.dcendents.mybatis.jaxws.db.IdTable;
import com.github.dcendents.mybatis.jaxws.db.model.Vehicle;
import java.io.Serializable;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public abstract class CarGen extends IdTable implements Vehicle, Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table public.car
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
    protected Car car = new Car();

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.car.color
     *
     * @return the value of public.car.color
     *
     * @mbggenerated
     */
    public String getColor() {
        return this.car.getColor();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.car.color
     *
     * @param color the value for public.car.color
     *
     * @mbggenerated
     */
    public void setColor(String color) {
        this.car.setColor(color);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.car.no_wheels
     *
     * @return the value of public.car.no_wheels
     *
     * @mbggenerated
     */
    public Integer getNoWheels() {
        return this.car.getNoWheels();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.car.no_wheels
     *
     * @param noWheels the value for public.car.no_wheels
     *
     * @mbggenerated
     */
    public void setNoWheels(Integer noWheels) {
        this.car.setNoWheels(noWheels);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.car.no_doors
     *
     * @return the value of public.car.no_doors
     *
     * @mbggenerated
     */
    public Integer getNoDoors() {
        return this.car.getNoDoors();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.car.no_doors
     *
     * @param noDoors the value for public.car.no_doors
     *
     * @mbggenerated
     */
    public void setNoDoors(Integer noDoors) {
        this.car.setNoDoors(noDoors);
    }
}