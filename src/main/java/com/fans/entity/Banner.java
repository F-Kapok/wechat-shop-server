package com.fans.entity;

import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * className: Banner
 *
 * @author k
 * @version 1.0
 * @description
 * @date 2020-05-30 13:32
 **/
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Where(clause = "delete_time is null")
public class Banner extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -20200530133243L;
    @Id
    private Long id;
    private String name;
    private String description;
    private String title;
    private String img;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "banner_id")
    private List<BannerItem> items;
}
