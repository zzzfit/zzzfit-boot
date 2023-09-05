package cloud.zzzfit.data.repository

import cloud.zzzfit.data.entity.Comment
import cloud.zzzfit.data.entity.Post

import org.springframework.data.jpa.repository.JpaRepository

interface CommentRepository : JpaRepository<Comment, Long> {
    fun countByPost(post: Post): Int
}