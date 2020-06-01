package com.fans.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.sql.Date;

/**
 * className: BaseEntiry
 *
 * @author k
 * @version 1.0
 * @description
 * @date 2020-05-30 13:39
 **/
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = -20200530133900L;

    @JsonIgnore
    private Date createTime;
    @JsonIgnore
    private Date updateTime;
    @JsonIgnore
    private Date deleteTime;

}
