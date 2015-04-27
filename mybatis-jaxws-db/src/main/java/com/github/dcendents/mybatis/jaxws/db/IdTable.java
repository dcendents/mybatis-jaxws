package com.github.dcendents.mybatis.jaxws.db;

import java.util.Comparator;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Base class for all the model objects.
 */
@Data
@ToString
@EqualsAndHashCode
public class IdTable {

    private Integer id;
    private Date modifiedOn;

    /**
     * Sort objects by id.
     */
    @NoArgsConstructor
    public static class IdComparator implements Comparator<IdTable> {
        @Override
        public int compare(IdTable o1, IdTable o2) {
            int compare = 0;

            Integer id1 = o1 != null ? o1.getId() : null;
            Integer id2 = o2 != null ? o2.getId() : null;

            if (id1 == null && id2 != null) {
                compare = -1;
            }
            else if (id1 != null) {
                compare = id1.compareTo(id2);
            }

            return compare;
        }
    }
}
