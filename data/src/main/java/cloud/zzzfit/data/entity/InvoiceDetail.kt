package cloud.zzzfit.data.entity

import jakarta.persistence.Embeddable
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import org.hibernate.annotations.Comment
import java.math.BigDecimal

@Embeddable
class InvoiceDetail {

    @Comment("纳税人识别号")
    val taxPayerId: String? = null

    @Comment("发票内容")
    val content: String? = null

    @Comment ("发票金额")
    private val amount: BigDecimal? = null
}

@Entity
class Tutorial {
    @Id
    @GeneratedValue
//        (strategy = GenerationType.AUTO)
    val id: Long = 0

//    @Column(name = "title")
//    var title: String? = null
//
//    @Column(name = "description")
//    var description: String? = null
//
//    @Column(name = "published")
//    var isPublished = false
//
//    constructor()
//    constructor(title: String?, description: String?, published: Boolean) {
//        this.title = title
//        this.description = description
//        isPublished = published
//    }
//
//    override fun toString(): String {
//        return "Tutorial [id=" + id + ", title=" + title + ", desc=" + description + ", published=" + isPublished + "]"
//    }
}
