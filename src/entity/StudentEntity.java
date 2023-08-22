package entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

//import entity.embeded.StudentName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "student")
@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@ToString
public class StudentEntity {

    // ID Attrubute
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Attrubute | Derived Attribute
    @Column(name = "nic", nullable = false)
    private String nic;

    //Composite Attribute
    //private StudentName name;

    //Multi Valued Attribute
    @ElementCollection
    @CollectionTable(
        name = "student_mobile",
        joinColumns = @JoinColumn(name = "student_id")
    )
    private List<String> mobiles;

    @CreationTimestamp
    @Column(name= "create_date", nullable = false)
    private Date createDate;

}