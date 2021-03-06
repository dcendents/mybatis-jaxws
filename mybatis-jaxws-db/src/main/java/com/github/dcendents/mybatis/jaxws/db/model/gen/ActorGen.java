package com.github.dcendents.mybatis.jaxws.db.model.gen;

import com.github.dcendents.mybatis.jaxws.api.Actor;
import com.github.dcendents.mybatis.jaxws.db.IdTable;
import java.io.Serializable;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public abstract class ActorGen extends IdTable implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table public.actor
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
    protected Actor actor = new Actor();

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.actor.first_name
     *
     * @return the value of public.actor.first_name
     *
     * @mbggenerated
     */
    public String getFirstName() {
        return this.actor.getFirstName();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.actor.first_name
     *
     * @param firstName the value for public.actor.first_name
     *
     * @mbggenerated
     */
    public void setFirstName(String firstName) {
        this.actor.setFirstName(firstName);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.actor.last_name
     *
     * @return the value of public.actor.last_name
     *
     * @mbggenerated
     */
    public String getLastName() {
        return this.actor.getLastName();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.actor.last_name
     *
     * @param lastName the value for public.actor.last_name
     *
     * @mbggenerated
     */
    public void setLastName(String lastName) {
        this.actor.setLastName(lastName);
    }
}