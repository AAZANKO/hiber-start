package com.matveyenka.model;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Builder
@EqualsAndHashCode(of = "id") // переопределение, берет только id для сравнения
@Entity
@Table(name = "employee", schema = "employee_storege")
public class Employee extends BaseEntity<Long>{

    // закоменчено т.к. создан спец класс BaseEntity
/*    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;*/

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "age")
    private String age;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;


    // т.к. в анатации прописали @AllArgsConstructor(staticName = "of")
    // поэтому конструктор пришлось закомитить
/*    public Employee(String name, String age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }*/

}
