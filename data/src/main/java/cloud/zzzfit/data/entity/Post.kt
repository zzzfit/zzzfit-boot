package cloud.zzzfit.data.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size
import org.springframework.data.geo.GeoPage
import java.io.Serializable

@Entity
class Post(
    @field:NotEmpty
    @field:Size(max = 255)
    @Column(nullable = false)
    val title: String,

    @Lob @Basic(fetch = FetchType.LAZY)
    @field:NotEmpty
    @field:Size(max = 10240)
    @Column(nullable = false, length = 10240)
    val content: String,
) : Managed<Long>() {
    @Id
    @GeneratedValue
    var id: Long = 0L

    @Column(length = 10240)
    val imageUrls: String? = null

    @Column(name = "comment_size")
    private val commentSize = 0

    @OneToMany(mappedBy = "post", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @OrderBy("id DESC")
//    @Where(clause = "pid=0")
    val comments: List<Comment>? = null
}


@Entity
class Comment(
    @field:NotEmpty
    @field:Size(max = 512)
    @Column(nullable = false)
    val content: String) : Serializable {
    @Id
    @GeneratedValue
    var id: Long = 0L

//    @Column(name = "post_id", nullable = false)
//    var postId: Long? = null

    //    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private var user: User? = null


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private var post: Post? = null

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "pid", referencedColumnName = "id")
    @OrderBy("id ASC")
    private val commentList: List<Comment>? = null

//    @JoinColumn(name = "reply_user_id")
//    @OneToOne(fetch = FetchType.LAZY)

//    private val replyUser: User? = null
}
